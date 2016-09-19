package ru.gdgkazan.footbalproject.repository;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.gdgkazan.footbalproject.api.ApiFactory;
import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.model.content.Player;
import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.model.response.FixturesListResponse;
import ru.gdgkazan.footbalproject.model.response.PlayersResponse;
import ru.gdgkazan.footbalproject.model.response.TeamResponse;
import ru.gdgkazan.footbalproject.model.response.TeamsResponse;
import rx.Observable;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
public class DefaulFootballRepository implements FootballRepository {

    @Override
    public Observable<List<Fixture>> fixtures() {
        return ApiFactory.getFootballService()
                .fixtures()
                .map(FixturesListResponse::getFixtures)
                .flatMap(Observable::from)
                .toList()
                .flatMap(fixtures -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        RealmResults<Fixture> fixtureRealmResults = realm.where(Fixture.class).findAll();
                        fixtureRealmResults.deleteAllFromRealm();
                        realm.insert(fixtures);
                    });
                    return Observable.just(fixtures);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<Fixture> fixtureRealmResults = realm.where(Fixture.class).findAll();
                    return Observable.just(realm.copyFromRealm(fixtureRealmResults));
                });
    }

    @NonNull
    @Override
    public Observable<List<Player>> players(int teamId) {
        return ApiFactory.getFootballService()
                .players(teamId)
                .map(PlayersResponse::getPlayers)
                .flatMap(Observable::from)
                .map(player -> {
                    player.setTeamId(teamId);
                    return player;
                })
                .toList()
                .flatMap(players -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        RealmResults<Player> teamPlayers = realm.where(Player.class).equalTo(Player.FIELD_TEAM_ID, teamId).findAll();
                        teamPlayers.deleteAllFromRealm();
                        realm.insert(players);
                    });
                    return Observable.just(players);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<Player> teamPlayers = realm.where(Player.class).equalTo(Player.FIELD_TEAM_ID, teamId).findAll();
                    return Observable.just(realm.copyFromRealm(teamPlayers));
                });
    }

    @Override
    public Observable<Team> team(String teamName) {
        return Observable.just(0)
                .flatMap(integer -> {
                    Team team = Realm.getDefaultInstance().where(Team.class).equalTo(Team.FIELD_NAME,teamName).findFirst();
                    if(team != null) {
                        return team(team.getId());
                    } else {
                        return getTeamFromAllTeams(teamName);
                    }
                });
    }

    private Observable<Team> getTeamFromAllTeams(String teamName) {
        return ApiFactory.getFootballService()
                .teams()
                .map(TeamsResponse::getTeams)
                .flatMap(Observable::from)
                .flatMap(this::teamMapper)
                .toList()
                .flatMap(teams -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        realm.delete(Team.class);
                        realm.insert(teams);
                    });
                    return Observable.from(teams);
                })
                .filter(team -> teamName.equals(team.getName()));
    }

    private Observable<Team> team(int teamId) {
        return ApiFactory.getFootballService()
                .team(teamId)
                .flatMap(this::teamMapper)
                .flatMap(team -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        realm.insertOrUpdate(team);
                    });
                    return Observable.just(team);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    Team team = realm.where(Team.class).equalTo(Team.FIELD_ID,teamId).findFirst();
                    return Observable.just(realm.copyFromRealm(team));
                });
    }

    private Observable<Team> teamMapper(TeamResponse response) {
        String link = response.getLinks().getSelf().getHref();
        Matcher m = Pattern.compile("\\d{2,}")
                .matcher(link);
        if(m.find()) {
            int id = Integer.parseInt(m.group());
            return Observable.just(new Team(
                    id,
                    response.getName(),
                    response.getCode(),
                    response.getShortName(),
                    response.getSquadMarketValue(),
                    response.getCrestUrl()));
        } else {
            return Observable.error(new NoSuchElementException());
        }
    }



}

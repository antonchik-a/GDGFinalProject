package ru.gdgkazan.footbalproject.screen.team;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.model.response.TeamResponse;
import rx.Observable;

/**
 * Created by Sergei Riabov
 */
public class TeamPresenter implements TeamContract.UserActionListener {

    @Override
    public void init(String teamName) {

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

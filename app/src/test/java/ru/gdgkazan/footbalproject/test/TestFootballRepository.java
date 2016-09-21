package ru.gdgkazan.footbalproject.test;

import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.model.content.Team;
import ru.gdgkazan.footbalproject.repository.FootballRepository;
import rx.Observable;

/**
 * @author Sergei Riabov
 */
public class TestFootballRepository implements FootballRepository {

    private boolean returnError = true;

    public TestFootballRepository(boolean returnError) {
        this.returnError = returnError;
    }

    @Override
    public Observable<List<Fixture>> fixtures() {
        return Observable.empty();
    }

    @Override
    public Observable<List<Standings>> standingsList() {
        return Observable.empty();
    }

    @Override
    public Observable<Team> team(String teamName) {
        if(returnError) {
            return Observable.error(new Exception());
        } else {
            return Observable.just(new Team());
        }
    }
}


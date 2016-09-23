package ru.gdgkazan.footbalproject.repository;

import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Fixture;
import ru.gdgkazan.footbalproject.model.content.Standings;
import ru.gdgkazan.footbalproject.model.content.Team;
import rx.Observable;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
public interface FootballRepository {

    Observable<List<Fixture>> fixtures();

    Observable<List<Standings>> standingsList();

    Observable<Team> team(String teamName);

}

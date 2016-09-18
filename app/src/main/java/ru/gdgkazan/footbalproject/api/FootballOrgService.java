package ru.gdgkazan.footbalproject.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.gdgkazan.footbalproject.model.response.FixturesListResponse;
import ru.gdgkazan.footbalproject.model.response.PlayersResponse;
import ru.gdgkazan.footbalproject.model.response.TableResponse;
import ru.gdgkazan.footbalproject.model.response.TeamResponse;
import ru.gdgkazan.footbalproject.model.response.TeamsResponse;
import rx.Observable;

/**
 * Created by Alexey Antonchik on 17.09.16.
 */
public interface FootballOrgService {

    @GET("competitions/426/fixtures")
    Observable<FixturesListResponse> fixtures();

    @GET("competitions/424/leagueTable")
    Observable<TableResponse> resultsTable();

    @GET("teams/{id}/players")
    Observable<PlayersResponse> players(@Path("id") int id);

    @GET("teams/{id}")
    Observable<TeamResponse> team(@Path("id") int id);

    @GET("competitions/426/teams")
    Observable<TeamsResponse> teams();

}

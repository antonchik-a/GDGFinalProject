package ru.gdgkazan.footbalproject.api;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.gdgkazan.footbalproject.model.response.FixturesListResponse;
import ru.gdgkazan.footbalproject.model.response.PlayersResponse;
import ru.gdgkazan.footbalproject.model.response.TableResponse;
import ru.gdgkazan.footbalproject.model.response.TeamResponse;
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
    Observable<PlayersResponse> players(@NonNull @Path("id") String id);

    @GET("teams/{id}")
    Observable<TeamResponse> team(@NonNull @Path("id") String id);

}

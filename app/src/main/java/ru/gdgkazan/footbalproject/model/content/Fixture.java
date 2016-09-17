
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Fixture extends RealmObject {

    @SerializedName("date")
    private String date;

    @SerializedName("status")
    private String status;

    @SerializedName("matchday")
    private Integer matchday;

    @SerializedName("homeTeamName")
    private String homeTeamName;

    @SerializedName("awayTeamName")
    private String awayTeamName;

    @SerializedName("result")
    private Result result;

    /**
     * 
     * @return
     *     The date
     */
    @NonNull
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(@NonNull String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The status
     */
    @NonNull
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The matchday
     */
    @NonNull
    public Integer getMatchday() {
        return matchday;
    }

    /**
     * 
     * @param matchday
     *     The matchday
     */
    public void setMatchday(@NonNull Integer matchday) {
        this.matchday = matchday;
    }

    /**
     * 
     * @return
     *     The homeTeamName
     */
    @NonNull
    public String getHomeTeamName() {
        return homeTeamName;
    }

    /**
     * 
     * @param homeTeamName
     *     The homeTeamName
     */
    public void setHomeTeamName(@NonNull String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    /**
     * 
     * @return
     *     The awayTeamName
     */
    @NonNull
    public String getAwayTeamName() {
        return awayTeamName;
    }

    /**
     * 
     * @param awayTeamName
     *     The awayTeamName
     */
    public void setAwayTeamName(@NonNull String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    /**
     * 
     * @return
     *     The result
     */
    @Nullable
    public Result getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(@Nullable Result result) {
        this.result = result;
    }

}

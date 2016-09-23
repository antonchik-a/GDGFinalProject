
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

public class Fixture extends RealmObject {

    @SerializedName("date")
    private Date mDate;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("matchday")
    private Integer mMatchday;

    @SerializedName("homeTeamName")
    private String mHomeTeamName;

    @SerializedName("awayTeamName")
    private String mAwayTeamName;

    @SerializedName("result")
    private Result mResult;

    /**
     *
     * @return
     *     The Date
     */
    @NonNull
    public Date getDate() {
        return mDate;
    }

    /**
     *
     * @param date
     *     The Date
     */
    public void setDate(@NonNull Date date) {
        this.mDate = date;
    }

    /**
     *
     * @return
     *     The Status
     */
    @NonNull
    public String getStatus() {
        return mStatus;
    }

    /**
     *
     * @param status
     *     The Status
     */
    public void setStatus(@NonNull String status) {
        this.mStatus = status;
    }

    /**
     *
     * @return
     *     The Matchday
     */
    @NonNull
    public Integer getMatchday() {
        return mMatchday;
    }

    /**
     *
     * @param matchday
     *     The Matchday
     */
    public void setMatchday(@NonNull Integer matchday) {
        this.mMatchday = matchday;
    }

    /**
     *
     * @return
     *     The HomeTeamName
     */
    @NonNull
    public String getHomeTeamName() {
        return mHomeTeamName;
    }

    /**
     *
     * @param homeTeamName
     *     The HomeTeamName
     */
    public void setHomeTeamName(@NonNull String homeTeamName) {
        this.mHomeTeamName = homeTeamName;
    }

    /**
     *
     * @return
     *     The AwayTeamName
     */
    @NonNull
    public String getAwayTeamName() {
        return mAwayTeamName;
    }

    /**
     *
     * @param awayTeamName
     *     The AwayTeamName
     */
    public void setAwayTeamName(@NonNull String awayTeamName) {
        this.mAwayTeamName = awayTeamName;
    }

    /**
     *
     * @return
     *     The Result
     */
    @Nullable
    public Result getResult() {
        return mResult;
    }

    /**
     *
     * @param result
     *     The Result
     */
    public void setResult(@Nullable Result result) {
        this.mResult = result;
    }


    public boolean hasQueryData(String query){
        boolean result = false;

        if(getAwayTeamName().toLowerCase().contains(query)) result = true;

        if(getHomeTeamName().toLowerCase().contains(query)) result = true;

        if(getResult() != null && (query.length() == 1 || query.length() == 2)){

            if(String.valueOf(getResult().getGoalsAwayTeam()).equals(query)) result = true;

            if(String.valueOf(getResult().getGoalsHomeTeam()).equals(query)) result = true;
        }

        return result;
    }

    public static Fixture getFixtureWithResult(){
        Fixture fixture = new Fixture();
        fixture.setAwayTeamName("Chelsea");
        fixture.setHomeTeamName("Arsenal");
        Result result = new Result();
        result.setGoalsAwayTeam(3);
        result.setGoalsHomeTeam(2);
        fixture.setResult(result);

        return fixture;
    }

    public static Fixture getFixtureWithoutResult(){
        Fixture fixture = new Fixture();
        fixture.setAwayTeamName("Chelsea");
        fixture.setHomeTeamName("Arsenal");
        return fixture;
    }

}

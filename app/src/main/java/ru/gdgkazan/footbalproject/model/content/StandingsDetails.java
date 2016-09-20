package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by mikes on 20.09.16.
 */

public class StandingsDetails extends RealmObject {

    @SerializedName("goals")
    private Integer mGoals;

    @SerializedName("goalsAgainst")
    private Integer mGoalsAgainst;

    @SerializedName("wins")
    private Integer mWins;

    @SerializedName("draws")
    private Integer mDraws;

    @SerializedName("losses")
    private Integer mLosses;

    @NonNull
    public Integer getGoals() {
        return mGoals;
    }

    public void setGoals(@NonNull Integer goals) {
        mGoals = goals;
    }

    @NonNull
    public Integer getGoalsAgainst() {
        return mGoalsAgainst;
    }

    public void setGoalsAgainst(@NonNull  Integer goalsAgainst) {
        mGoalsAgainst = goalsAgainst;
    }

    @NonNull
    public Integer getWins() {
        return mWins;
    }

    public void setWins(@NonNull  Integer wins) {
        mWins = wins;
    }

    @NonNull
    public Integer getDraws() {
        return mDraws;
    }

    public void setDraws(@NonNull Integer draws) {
        mDraws = draws;
    }

    @NonNull
    public Integer getLosses() {
        return mLosses;
    }

    public void setLosses(@NonNull  Integer losses) {
        mLosses = losses;
    }

}

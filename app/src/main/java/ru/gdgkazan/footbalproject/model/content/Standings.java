
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Standings extends RealmObject {

    @SerializedName("position")
    private Integer mPosition;

    @SerializedName("teamName")
    private String mTeamName;

    @SerializedName("crestUri")
    private String mCrestUri;

    @SerializedName("playedGames")
    private Integer mPlayedGames;

    @SerializedName("points")
    private Integer mPoints;

    @SerializedName("goals")
    private Integer mGoals;

    @SerializedName("goalsAgainst")
    private Integer mGoalsAgainst;

    @SerializedName("goalDifference")
    private Integer mGoalDifference;

    @SerializedName("wins")
    private Integer mWins;

    @SerializedName("draws")
    private Integer mDraws;

    @SerializedName("losses")
    private Integer mLosses;

    @SerializedName("home")
    private StandingsDetails mStandingsDetailsHome;

    @SerializedName("away")
    private StandingsDetails mStandingsDetailsAway;

    @NonNull
    public Integer getPosition() {
        return mPosition;
    }

    public void setPosition(@NonNull Integer position) {
        this.mPosition = position;
    }

    @NonNull
    public String getTeamname() {
        return mTeamname;
    }

    public void setTeamname(@NonNull String teamname) {
        this.mTeamname = teamname;
    }

    @NonNull
    public String getCrestUri() {
        return mCrestUri;
    }

    public void setCrestUri(@NonNull String crestUri) {
        this.mCrestUri = crestUri;
    }

    @NonNull
    public Integer getPlayedGames() {
        return mPlayedGames;
    }

    public void setPlayedGames(@NonNull Integer playedGames) {
        this.mPlayedGames = playedGames;
    }

    @NonNull
    public Integer getPoints() {
        return mPoints;
    }

    public void setPoints(@NonNull Integer points) {
        this.mPoints = points;
    }

    @NonNull
    public Integer getGoals() {
        return mGoals;
    }

    public void setGoals(@NonNull Integer goals) {
        this.mGoals = goals;
    }

    @NonNull
    public Integer getGoalsAgainst() {
        return mGoalsAgainst;
    }

    public void setGoalsAgainst(@NonNull Integer goalsAgainst) {
        this.mGoalsAgainst = goalsAgainst;
    }

    @NonNull
    public Integer getGoalDifference() {
        return mGoalDifference;
    }

    public void setGoalDifference(@NonNull Integer goalDifference) {
        this.mGoalDifference = goalDifference;
    }

    @NonNull
    public Integer getWins() {
        return mWins;
    }

    public void setWins(@NonNull Integer wins) {
        this.mWins = wins;
    }

    @NonNull
    public Integer getDraws() {
        return mDraws;
    }

    public void setDraws(@NonNull Integer draws) {
        this.mDraws = draws;
    }

    @NonNull
    public Integer getLosses() {
        return mLosses;
    }

    public void setLosses(@NonNull Integer losses) {
        this.mLosses = losses;
    }

    @NonNull
    public StandingsDetails getStandingsDetailsHome(){
        return mStandingsDetailsHome;
    }

    public void setStandingsDetailsHome(@NonNull  StandingsDetails standingsDetailsHome){
        mStandingsDetailsHome = standingsDetailsHome;
    }

    @NonNull
    public StandingsDetails getStandingsDetailsAway(){
        return mStandingsDetailsAway;
    }

    public void setStandingsDetailsAway(@NonNull StandingsDetails standingsDetailsAway){
        mStandingsDetailsAway = standingsDetailsAway;
    }

}

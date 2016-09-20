
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Standings extends RealmObject {

    @SerializedName("position")
    private Integer position;

    @SerializedName("teamName")
    private String teamName;

    @SerializedName("crestURI")
    private String crestURI;

    @SerializedName("playedGames")
    private Integer playedGames;

    @SerializedName("points")
    private Integer points;

    @SerializedName("goals")
    private Integer goals;

    @SerializedName("goalsAgainst")
    private Integer goalsAgainst;

    @SerializedName("goalDifference")
    private Integer goalDifference;

    @SerializedName("wins")
    private Integer wins;

    @SerializedName("draws")
    private Integer draws;

    @SerializedName("losses")
    private Integer losses;

    @NonNull
    public Integer getPosition() {
        return position;
    }

    public void setPosition(@NonNull Integer position) {
        this.position = position;
    }

    @NonNull
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(@NonNull String teamName) {
        this.teamName = teamName;
    }

    @NonNull
    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(@NonNull String crestURI) {
        this.crestURI = crestURI;
    }

    @NonNull
    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(@NonNull Integer playedGames) {
        this.playedGames = playedGames;
    }

    @NonNull
    public Integer getPoints() {
        return points;
    }

    public void setPoints(@NonNull Integer points) {
        this.points = points;
    }

    @NonNull
    public Integer getGoals() {
        return goals;
    }

    public void setGoals(@NonNull Integer goals) {
        this.goals = goals;
    }

    @NonNull
    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(@NonNull Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    @NonNull
    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(@NonNull Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    @NonNull
    public Integer getWins() {
        return wins;
    }

    public void setWins(@NonNull Integer wins) {
        this.wins = wins;
    }

    @NonNull
    public Integer getDraws() {
        return draws;
    }

    public void setDraws(@NonNull Integer draws) {
        this.draws = draws;
    }

    @NonNull
    public Integer getLosses() {
        return losses;
    }

    public void setLosses(@NonNull Integer losses) {
        this.losses = losses;
    }

}

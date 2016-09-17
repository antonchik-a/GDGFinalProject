
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Standing extends RealmObject {

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

    /**
     * 
     * @return
     *     The position
     */
    @NonNull
    public Integer getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(@NonNull Integer position) {
        this.position = position;
    }

    /**
     * 
     * @return
     *     The teamName
     */
    @NonNull
    public String getTeamName() {
        return teamName;
    }

    /**
     * 
     * @param teamName
     *     The teamName
     */
    public void setTeamName(@NonNull String teamName) {
        this.teamName = teamName;
    }

    /**
     * 
     * @return
     *     The crestURI
     */
    @NonNull
    public String getCrestURI() {
        return crestURI;
    }

    /**
     * 
     * @param crestURI
     *     The crestURI
     */
    public void setCrestURI(@NonNull String crestURI) {
        this.crestURI = crestURI;
    }

    /**
     * 
     * @return
     *     The playedGames
     */
    @NonNull
    public Integer getPlayedGames() {
        return playedGames;
    }

    /**
     * 
     * @param playedGames
     *     The playedGames
     */
    public void setPlayedGames(@NonNull Integer playedGames) {
        this.playedGames = playedGames;
    }

    /**
     * 
     * @return
     *     The points
     */
    @NonNull
    public Integer getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    public void setPoints(@NonNull Integer points) {
        this.points = points;
    }

    /**
     * 
     * @return
     *     The goals
     */
    @NonNull
    public Integer getGoals() {
        return goals;
    }

    /**
     * 
     * @param goals
     *     The goals
     */
    public void setGoals(@NonNull Integer goals) {
        this.goals = goals;
    }

    /**
     * 
     * @return
     *     The goalsAgainst
     */
    @NonNull
    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * 
     * @param goalsAgainst
     *     The goalsAgainst
     */
    public void setGoalsAgainst(@NonNull Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    /**
     * 
     * @return
     *     The goalDifference
     */
    @NonNull
    public Integer getGoalDifference() {
        return goalDifference;
    }

    /**
     * 
     * @param goalDifference
     *     The goalDifference
     */
    public void setGoalDifference(@NonNull Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    /**
     * 
     * @return
     *     The wins
     */
    @NonNull
    public Integer getWins() {
        return wins;
    }

    /**
     * 
     * @param wins
     *     The wins
     */
    public void setWins(@NonNull Integer wins) {
        this.wins = wins;
    }

    /**
     * 
     * @return
     *     The draws
     */
    @NonNull
    public Integer getDraws() {
        return draws;
    }

    /**
     * 
     * @param draws
     *     The draws
     */
    public void setDraws(@NonNull Integer draws) {
        this.draws = draws;
    }

    /**
     * 
     * @return
     *     The losses
     */
    @NonNull
    public Integer getLosses() {
        return losses;
    }

    /**
     * 
     * @param losses
     *     The losses
     */
    public void setLosses(@NonNull Integer losses) {
        this.losses = losses;
    }

}


package ru.gdgkazan.footbalproject.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Result extends RealmObject {

    @SerializedName("goalsHomeTeam")
    @Expose
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Integer goalsAwayTeam;

    /**
     * 
     * @return
     *     The goalsHomeTeam
     */
    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    /**
     * 
     * @param goalsHomeTeam
     *     The goalsHomeTeam
     */
    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    /**
     * 
     * @return
     *     The goalsAwayTeam
     */
    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    /**
     * 
     * @param goalsAwayTeam
     *     The goalsAwayTeam
     */
    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}


package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Result extends RealmObject {

    @SerializedName("goalsHomeTeam")
    private Integer goalsHomeTeam;

    @SerializedName("goalsAwayTeam")
    private Integer goalsAwayTeam;

    /**
     * 
     * @return
     *     The goalsHomeTeam
     */
    @NonNull
    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    /**
     * 
     * @param goalsHomeTeam
     *     The goalsHomeTeam
     */
    public void setGoalsHomeTeam(@NonNull Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    /**
     * 
     * @return
     *     The goalsAwayTeam
     */
    @NonNull
    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    /**
     * 
     * @param goalsAwayTeam
     *     The goalsAwayTeam
     */
    public void setGoalsAwayTeam(@NonNull Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}


package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Result extends RealmObject {

    @SerializedName("goalsHomeTeam")
    private Integer mGoalsHomeTeam;

    @SerializedName("goalsAwayTeam")
    private Integer mGoalsAwayTeam;

    /**
     * 
     * @return
     *     The GoalsHomeTeam
     */
    @NonNull
    public Integer getGoalsHomeTeam() {
        return mGoalsHomeTeam;
    }

    /**
     * 
     * @param goalsHomeTeam
     *     The GoalsHomeTeam
     */
    public void setGoalsHomeTeam(@NonNull Integer goalsHomeTeam) {
        this.mGoalsHomeTeam = goalsHomeTeam;
    }

    /**
     * 
     * @return
     *     The GoalsAwayTeam
     */
    @NonNull
    public Integer getGoalsAwayTeam() {
        return mGoalsAwayTeam;
    }

    /**
     * 
     * @param goalsAwayTeam
     *     The GoalsAwayTeam
     */
    public void setGoalsAwayTeam(@NonNull Integer goalsAwayTeam) {
        this.mGoalsAwayTeam = goalsAwayTeam;
    }


    @Override
    public String toString() {
        if(getGoalsAwayTeam() != null && getGoalsHomeTeam() != null) {
            return String.valueOf(getGoalsHomeTeam()) + " : " + String.valueOf(getGoalsAwayTeam());
        }else {
            return "";
        }
    }
}


package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Team;

public class TeamsResponse {

    @SerializedName("teams")
    @NonNull
    private List<TeamResponse> teamResponseList = new ArrayList<>();

    /**
     * 
     * @return
     *     The teamResponse list
     */
    @NonNull
    public List<TeamResponse> getTeams() {
        return teamResponseList;
    }

    /**
     * 
     * @param teamResponseList
     *     The teamResponce List
     */
    public void setTeams(@NonNull List<TeamResponse> teamResponseList) {
        this.teamResponseList = teamResponseList;
    }

}

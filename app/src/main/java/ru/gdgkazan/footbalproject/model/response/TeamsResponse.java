
package ru.gdgkazan.footbalproject.model.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TeamsResponse {

    @SerializedName("count")
    private Integer count;

    @SerializedName("teams")
    private List<TeamResponse> teams = new ArrayList<TeamResponse>();

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The teams
     */
    public List<TeamResponse> getTeams() {
        return teams;
    }

    /**
     * 
     * @param teams
     *     The teams
     */
    public void setTeams(List<TeamResponse> teams) {
        this.teams = teams;
    }

}

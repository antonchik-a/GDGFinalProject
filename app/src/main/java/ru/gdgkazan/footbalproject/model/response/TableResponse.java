
package ru.gdgkazan.footbalproject.model.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Standing;

public class TableResponse {

    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("standing")
    @Expose
    private List<Standing> standing = new ArrayList<>();

    /**
     * 
     * @return
     *     The matchday
     */
    public Integer getMatchday() {
        return matchday;
    }

    /**
     * 
     * @param matchday
     *     The matchday
     */
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    /**
     * 
     * @return
     *     The standing
     */
    public List<Standing> getStanding() {
        return standing;
    }

    /**
     * 
     * @param standing
     *     The standing
     */
    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }

}

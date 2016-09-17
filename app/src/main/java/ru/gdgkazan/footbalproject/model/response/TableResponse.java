
package ru.gdgkazan.footbalproject.model.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Standing;

public class TableResponse {

    @SerializedName("standing")
    @Expose
    private List<Standing> standing = new ArrayList<>();

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

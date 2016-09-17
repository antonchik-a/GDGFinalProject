
package ru.gdgkazan.footbalproject.model.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Fixture;

public class FixturesListResponse {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = new ArrayList<>();

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
     *     The fixtures
     */
    public List<Fixture> getFixtures() {
        return fixtures;
    }

    /**
     * 
     * @param fixtures
     *     The fixtures
     */
    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}

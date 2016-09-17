
package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Fixture;

public class FixturesListResponse {

    @SerializedName("count")
    private Integer count;

    @SerializedName("fixtures")
    private List<Fixture> fixtures = new ArrayList<>();

    /**
     * 
     * @return
     *     The count
     */
    @NonNull
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(@NonNull Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The fixtures
     */
    @NonNull
    public List<Fixture> getFixtures() {
        return fixtures;
    }

    /**
     * 
     * @param fixtures
     *     The fixtures
     */
    public void setFixtures(@NonNull List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}


package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Standings;

public class StandingsListResponse {

    @SerializedName("leagueCaption")
    private String mLeagueCaption;

    @SerializedName("matchday")
    private Integer mMatchDay;

    @SerializedName("standing")
    private List<Standings> mStandingsList;

    @NonNull
    public String getLeagueCaption(){
        return mLeagueCaption;
    }

    @NonNull
    public Integer getMatchDay(){
        return mMatchDay;
    }

    @NonNull
    public List<Standings> getStandingsList() {
        if(mStandingsList == null){
            return new ArrayList<>();
        }
        return mStandingsList;
    }

}


package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import ru.gdgkazan.footbalproject.model.content.Standings;

public class StandingsResponse {

    @SerializedName("standing")
    private List<Standings> standings = new ArrayList<>();

    @NonNull
    public List<Standings> getStandings() {
        return standings;
    }

    public void setStandings(@NonNull List<Standings> standings) {
        this.standings = standings;
    }

}


package ru.gdgkazan.footbalproject.model.response;


import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ru.gdgkazan.footbalproject.model.content.Player;

public class PlayersResponse {

    @SerializedName("count")
    private Integer count;

    @SerializedName("players")
    private List<Player> players = new ArrayList<>();

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
     *     The players
     */
    @NonNull
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * 
     * @param players
     *     The players
     */
    public void setPlayers(@NonNull List<Player> players) {
        this.players = players;
    }

}

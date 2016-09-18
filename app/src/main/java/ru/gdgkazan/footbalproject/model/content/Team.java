package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.gdgkazan.footbalproject.model.response.TeamResponse;

/**
 * Created by Sergei Riabov
 */
public class Team extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String code;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;
    private RealmList<Player> players;

    public Team() {
    }

    public Team(int id, String name, String code, String shortName, String squadMarketName, String crestUrl) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.shortName = shortName;
        this.squadMarketValue = squadMarketName;
        this.crestUrl = crestUrl;
    }

    /**
     *
     * @return
     *     The team ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The team ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The name
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(@NonNull String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The code
     */
    @NonNull
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     *     The code
     */
    public void setCode(@NonNull String code) {
        this.code = code;
    }

    /**
     *
     * @return
     *     The shortName
     */
    @NonNull
    public String getShortName() {
        return shortName;
    }

    /**
     *
     * @param shortName
     *     The shortName
     */
    public void setShortName(@NonNull String shortName) {
        this.shortName = shortName;
    }

    /**
     *
     * @return
     *     The squadMarketValue
     */
    @NonNull
    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    /**
     *
     * @param squadMarketValue
     *     The squadMarketValue
     */
    public void setSquadMarketValue(@NonNull String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    /**
     *
     * @return
     *     The crestUrl
     */
    @NonNull
    public String getCrestUrl() {
        return crestUrl;
    }

    /**
     *
     * @param crestUrl
     *     The crestUrl
     */
    public void setCrestUrl(@NonNull String crestUrl) {
        this.crestUrl = crestUrl;
    }

    /**
     *
     * @return
     *     The team players
     */
    @Nullable
    public RealmList<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     *     The team players
     */
    public void setPlayers(@Nullable RealmList<Player> players) {
        this.players = players;
    }
}

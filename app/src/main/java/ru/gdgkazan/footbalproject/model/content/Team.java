package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sergei Riabov
 */
public class Team extends RealmObject {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";

    @PrimaryKey
    private int id;
    private String name;
    private String code;
    private String shortName;
    private String squadMarketValue;
    private String mCrestUrl;
    private RealmList<Player> mPlayers;

    public Team() {
    }

    public Team(int id, String name, String code, String shortName, String squadMarketName, String crestUrl) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.shortName = shortName;
        this.squadMarketValue = squadMarketName;
        this.mCrestUrl = crestUrl;
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
     *     The CrestUrl
     */
    @NonNull
    public String getCrestUrl() {
        return mCrestUrl;
    }

    /**
     *
     * @param crestUrl
     *     The CrestUrl
     */
    public void setCrestUrl(@NonNull String crestUrl) {
        this.mCrestUrl = crestUrl;
    }

    @NonNull
    public RealmList<Player> getPlayers() {
        return mPlayers;
    }

    public void setPlayers(@NonNull RealmList<Player> players) {
        mPlayers = players;
    }

}

package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sergei Riabov
 */
public class Team extends RealmObject {

    public static final String FIELD_ID = "mId";
    public static final String FIELD_NAME = "mName";

    @PrimaryKey
    private int mId;
    private String mName;
    private String mCode;
    private String mShortName;
    private String mSquadMarketValue;
    private String mCrestUrl;
    private RealmList<Player> mPlayers;

    public Team() {
    }

    public Team(int id, String name, String code, String shortName, String squadMarketName, String crestUrl) {
        this.mId = id;
        this.mName = name;
        this.mCode = code;
        this.mShortName = shortName;
        this.mSquadMarketValue = squadMarketName;
        this.mCrestUrl = crestUrl;
    }

    /**
     *
     * @return
     *     The team ID
     */
    public int getId() {
        return mId;
    }

    /**
     *
     * @param id
     *     The team ID
     */
    public void setId(int id) {
        this.mId = id;
    }

    /**
     *
     * @return
     *     The Name
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     *
     * @param name
     *     The Name
     */
    public void setName(@NonNull String name) {
        this.mName = name;
    }

    /**
     *
     * @return
     *     The Code
     */
    @NonNull
    public String getCode() {
        return mCode;
    }

    /**
     *
     * @param code
     *     The Code
     */
    public void setCode(@NonNull String code) {
        this.mCode = code;
    }

    /**
     *
     * @return
     *     The ShortName
     */
    @NonNull
    public String getShortName() {
        return mShortName;
    }

    /**
     *
     * @param shortName
     *     The ShortName
     */
    public void setShortName(@NonNull String shortName) {
        this.mShortName = shortName;
    }

    /**
     *
     * @return
     *     The SquadMarketValue
     */
    @NonNull
    public String getSquadMarketValue() {
        return mSquadMarketValue;
    }

    /**
     *
     * @param squadMarketValue
     *     The SquadMarketValue
     */
    public void setSquadMarketValue(@NonNull String squadMarketValue) {
        this.mSquadMarketValue = squadMarketValue;
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

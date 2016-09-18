
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Player extends RealmObject {

    public static final String FIELD_TEAM_ID = "teamId";

    private int teamId;

    @SerializedName("name")
    private String name;

    @SerializedName("position")
    private String position;

    @SerializedName("jerseyNumber")
    private Integer jerseyNumber;

    @SerializedName("dateOfBirth")
    private String dateOfBirth;

    @SerializedName("nationality")
    private String nationality;

    @SerializedName("contractUntil")
    private String contractUntil;

    @SerializedName("marketValue")
    private String marketValue;

    /**
     *
     * @return
     *     The team ID
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     *     The team ID
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
     *     The position
     */
    @NonNull
    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(@NonNull String position) {
        this.position = position;
    }

    /**
     * 
     * @return
     *     The jerseyNumber
     */
    @NonNull
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * 
     * @param jerseyNumber
     *     The jerseyNumber
     */
    public void setJerseyNumber(@NonNull Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * 
     * @return
     *     The dateOfBirth
     */
    @NonNull
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 
     * @param dateOfBirth
     *     The dateOfBirth
     */
    public void setDateOfBirth(@NonNull String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 
     * @return
     *     The nationality
     */
    @NonNull
    public String getNationality() {
        return nationality;
    }

    /**
     * 
     * @param nationality
     *     The nationality
     */
    public void setNationality(@NonNull String nationality) {
        this.nationality = nationality;
    }

    /**
     * 
     * @return
     *     The contractUntil
     */
    @NonNull
    public String getContractUntil() {
        return contractUntil;
    }

    /**
     * 
     * @param contractUntil
     *     The contractUntil
     */
    public void setContractUntil(@NonNull String contractUntil) {
        this.contractUntil = contractUntil;
    }

    /**
     * 
     * @return
     *     The marketValue
     */
    @NonNull
    public String getMarketValue() {
        return marketValue;
    }

    /**
     * 
     * @param marketValue
     *     The marketValue
     */
    public void setMarketValue(@NonNull String marketValue) {
        this.marketValue = marketValue;
    }

}

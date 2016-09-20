
package ru.gdgkazan.footbalproject.model.content;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Player extends RealmObject {

    @SerializedName("name")
    private String mName;

    @SerializedName("position")
    private String mPosition;

    @SerializedName("jerseyNumber")
    private Integer mJerseyNumber;

    @SerializedName("dateOfBirth")
    private String mDateOfBirth;

    @SerializedName("nationality")
    private String mNationality;

    @SerializedName("contractUntil")
    private String mContractUntil;

    @SerializedName("marketValue")
    private String mMarketValue;

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
     *     The Position
     */
    @NonNull
    public String getPosition() {
        return mPosition;
    }

    /**
     * 
     * @param position
     *     The Position
     */
    public void setPosition(@NonNull String position) {
        this.mPosition = position;
    }

    /**
     * 
     * @return
     *     The JerseyNumber
     */
    @NonNull
    public Integer getJerseyNumber() {
        return mJerseyNumber;
    }

    /**
     * 
     * @param jerseyNumber
     *     The JerseyNumber
     */
    public void setJerseyNumber(@NonNull Integer jerseyNumber) {
        this.mJerseyNumber = jerseyNumber;
    }

    /**
     * 
     * @return
     *     The DateOfBirth
     */
    @NonNull
    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    /**
     * 
     * @param dateOfBirth
     *     The DateOfBirth
     */
    public void setDateOfBirth(@NonNull String dateOfBirth) {
        this.mDateOfBirth = dateOfBirth;
    }

    /**
     * 
     * @return
     *     The Nationality
     */
    @NonNull
    public String getNationality() {
        return mNationality;
    }

    /**
     * 
     * @param nationality
     *     The Nationality
     */
    public void setNationality(@NonNull String nationality) {
        this.mNationality = nationality;
    }

    /**
     * 
     * @return
     *     The ContractUntil
     */
    @NonNull
    public String getContractUntil() {
        return mContractUntil;
    }

    /**
     * 
     * @param contractUntil
     *     The ContractUntil
     */
    public void setContractUntil(@NonNull String contractUntil) {
        this.mContractUntil = contractUntil;
    }

    /**
     * 
     * @return
     *     The MarketValue
     */
    @NonNull
    public String getMarketValue() {
        return mMarketValue;
    }

    /**
     * 
     * @param marketValue
     *     The MarketValue
     */
    public void setMarketValue(@NonNull String marketValue) {
        this.mMarketValue = marketValue;
    }

}

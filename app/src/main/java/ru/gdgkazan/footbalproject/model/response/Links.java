
package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    private LinkSelf self;

    /**
     * 
     * @return
     *     The self
     */
    @NonNull
    public LinkSelf getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(@NonNull LinkSelf self) {
        this.self = self;
    }

}

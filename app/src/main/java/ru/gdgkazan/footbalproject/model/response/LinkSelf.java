
package ru.gdgkazan.footbalproject.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LinkSelf {

    @SerializedName("href")
    private String href;

    /**
     * 
     * @return
     *     The href
     */
    @NonNull
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(@NonNull String href) {
        this.href = href;
    }

}

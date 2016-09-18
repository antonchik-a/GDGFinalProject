
package ru.gdgkazan.footbalproject.model.response;

import com.google.gson.annotations.SerializedName;

public class LinkSelf {

    @SerializedName("href")
    private String href;

    /**
     * 
     * @return
     *     The href
     */
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(String href) {
        this.href = href;
    }

}

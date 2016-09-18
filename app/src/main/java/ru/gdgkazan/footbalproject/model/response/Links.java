
package ru.gdgkazan.footbalproject.model.response;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    private LinkSelf self;

    /**
     * 
     * @return
     *     The self
     */
    public LinkSelf getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(LinkSelf self) {
        this.self = self;
    }

}

package com.mobidevtask.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Sprite implements Serializable {

    @SerializedName("front_default")
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}

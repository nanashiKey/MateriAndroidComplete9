package com.sampledev.project.materiandroidcomplete9.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * created by Irfan Assidiq
 * email : assidiq.irfan@gmail.com
 **/
class LoginModel implements Serializable {
    @SerializedName("id")
    public int id;

    @SerializedName("username")
    public String username;

    @SerializedName("email")
    public String email;

    @SerializedName("point")
    public int point;
}

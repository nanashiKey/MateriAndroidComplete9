package com.sampledev.project.materiandroidcomplete9.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * created by Irfan Assidiq
 * email : assidiq.irfan@gmail.com
 **/
public class RegisterResponse implements Serializable {
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String message;
}

package com.dacodes.venadostest.Views.Models.Players;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PlayerResponse {
    @SerializedName("sucess")
    private boolean succes;
    @SerializedName("data")
    private Data data;
    @SerializedName("code")
    private int code;

    public PlayerResponse() {
    }

    public PlayerResponse(boolean succes, Data data, int code) {
        this.succes = succes;
        this.data = data;
        this.code = code;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

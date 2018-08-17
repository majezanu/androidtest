package com.dacodes.venadostest.Views.Models.Games;

import com.dacodes.venadostest.Views.Models.Statistics.DataStatistics;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GamesResponse implements Serializable {
    @SerializedName("sucess")
    private boolean succes;
    @SerializedName("data")
    private DataGames data;
    @SerializedName("code")
    private int code;

    public GamesResponse() {
    }

    public GamesResponse(boolean succes, DataGames data, int code) {
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

    public DataGames getData() {
        return data;
    }

    public void setData(DataGames data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

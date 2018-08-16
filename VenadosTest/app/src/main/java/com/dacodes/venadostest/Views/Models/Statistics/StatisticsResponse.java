package com.dacodes.venadostest.Views.Models.Statistics;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StatisticsResponse implements Serializable {
    @SerializedName("sucess")
    private boolean succes;
    @SerializedName("data")
    private DataStatistics data;
    @SerializedName("code")
    private int code;

    public StatisticsResponse() {
    }

    public StatisticsResponse(boolean succes, DataStatistics data, int code) {
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

    public DataStatistics getData() {
        return data;
    }

    public void setData(DataStatistics data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

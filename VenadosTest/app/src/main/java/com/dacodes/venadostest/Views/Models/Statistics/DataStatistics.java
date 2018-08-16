package com.dacodes.venadostest.Views.Models.Statistics;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStatistics implements Serializable {
    @SerializedName("statistics")
    private ArrayList<Statistic> statistics = new ArrayList<>();

    public DataStatistics() {
    }

    public DataStatistics(ArrayList<Statistic> statistics) {
        this.statistics = statistics;
    }

    public ArrayList<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(ArrayList<Statistic> statistics) {
        this.statistics = statistics;
    }
}

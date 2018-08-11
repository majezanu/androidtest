package com.dacodes.venadostest.Views.Models.Players;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("team")
    private Team team;

    public Data() {
    }

    public Data(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

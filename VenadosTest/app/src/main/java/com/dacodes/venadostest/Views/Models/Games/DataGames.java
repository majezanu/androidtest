package com.dacodes.venadostest.Views.Models.Games;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DataGames implements Serializable{
    @SerializedName("games")
    ArrayList<Game> games;

    public DataGames() {
    }

    public DataGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}

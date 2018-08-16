package com.dacodes.venadostest.Views.Models.Statistics;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Statistic implements Serializable {
    @SerializedName("position")
    private int position;
    @SerializedName("image")
    private String urlImage;
    @SerializedName("team")
    private String team;
    @SerializedName("games")
    private int games;
    @SerializedName("win")
    private int win;
    @SerializedName("los")
    private int loss;
    @SerializedName("tie")
    private int tie;
    @SerializedName("f_goals")
    private int fGoals;
    @SerializedName("a_goals")
    private int aGoals;
    @SerializedName("score_diff")
    private int scoreDiff;
    @SerializedName("points")
    private int points;
    @SerializedName("efec")
    @Nullable
    private String efec;

    public Statistic() {
    }

    public Statistic(int position, String urlImage, String team, int games, int win, int loss, int tie, int fGoals, int aGoals, int scoreDiff, int points, String efec) {
        this.position = position;
        this.urlImage = urlImage;
        this.team = team;
        this.games = games;
        this.win = win;
        this.loss = loss;
        this.tie = tie;
        this.fGoals = fGoals;
        this.aGoals = aGoals;
        this.scoreDiff = scoreDiff;
        this.points = points;
        this.efec = efec;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getfGoals() {
        return fGoals;
    }

    public void setfGoals(int fGoals) {
        this.fGoals = fGoals;
    }

    public int getaGoals() {
        return aGoals;
    }

    public void setaGoals(int aGoals) {
        this.aGoals = aGoals;
    }

    public int getScoreDiff() {
        return scoreDiff;
    }

    public void setScoreDiff(int scoreDiff) {
        this.scoreDiff = scoreDiff;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getEfec() {
        return efec;
    }

    public void setEfec(String efec) {
        this.efec = efec;
    }
}

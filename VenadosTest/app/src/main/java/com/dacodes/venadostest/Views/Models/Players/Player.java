package com.dacodes.venadostest.Views.Models.Players;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player extends Person implements Serializable{
    @SerializedName("position")
    private String position;
    @SerializedName("number")
    private int number;
    @SerializedName("position_short")
    private String positionShort;
    @SerializedName("last_team")
    private String lastTeam;
    @SerializedName("image")
    private String urlImage;

    public Player() {
    }

    public Player(Player P) {
        super(P);
        this.position = P.getPosition();
        this.number = P.getNumber();
        this.positionShort = P.getPositionShort();
        this.lastTeam = P.getLastTeam();
        this.urlImage = P.getUrlImage();
    }

    public Player(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, double weight, double height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height);
        this.position = position;
        this.number = number;
        this.positionShort = positionShort;
        this.lastTeam = lastTeam;
        this.urlImage = urlImage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPositionShort() {
        return positionShort;
    }

    public void setPositionShort(String positionShort) {
        this.positionShort = positionShort;
    }

    public String getLastTeam() {
        return lastTeam;
    }

    public void setLastTeam(String lastTeam) {
        this.lastTeam = lastTeam;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}

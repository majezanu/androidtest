package com.dacodes.venadostest.Views.Models.Games;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Game implements Serializable{
    @SerializedName("local")
    private boolean isLocal;
    @SerializedName("opponent")
    private String opponent;
    @SerializedName("opponent_image")
    private String opponent_image;
    @SerializedName("datetime")
    private String date_time_s;
    @SerializedName("league")
    private String league;
    @SerializedName("image")
    private String image_url;
    @SerializedName("home_score")
    private int home_score;
    @SerializedName("away_score")
    private int away_score;

    private Date date;

    private SimpleDateFormat dateFormatFull =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS", Locale.getDefault());
    private DateFormat dateFormat =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.forLanguageTag("es-ES"));
    private DateFormat dateFormat2 =
            new SimpleDateFormat("dd", Locale.forLanguageTag("es-ES"));

    public Game() {
    }

    public Game(boolean isLocal, String opponent, String opponent_image, String date_time_s, String league, String image_url, int home_score, int away_score) {
        this.isLocal = isLocal;
        this.opponent = opponent;
        this.opponent_image = opponent_image;
        this.date_time_s = date_time_s;
        this.league = league;
        this.image_url = image_url;
        this.home_score = home_score;
        this.away_score = away_score;

    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent_image() {
        return opponent_image;
    }

    public void setOpponent_image(String opponent_image) {
        this.opponent_image = opponent_image;
    }

    public String getDate_time_s() {
        return date_time_s;
    }

    public void setDate_time_s(String date_time_s) {
        this.date_time_s = date_time_s;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public String getDateReformated() {
        try {
            setDate(dateFormatFull.parse(this.date_time_s));
            Log.d("Date", this.date_time_s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(date);
    }
    public String getDateDay() {
        try {
            setDate(dateFormatFull.parse(this.date_time_s));
            Log.d("Date", this.date_time_s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat2.format(date);
    }
    public Date getDate() {
        try {
            setDate(dateFormatFull.parse(this.date_time_s));
            Log.d("Date", this.date_time_s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

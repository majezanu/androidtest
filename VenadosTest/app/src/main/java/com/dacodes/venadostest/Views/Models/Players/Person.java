package com.dacodes.venadostest.Views.Models.Players;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person implements Serializable{
    @SerializedName("name")
    private String name;
    @SerializedName("first_surname")
    private String firstSurName;
    @SerializedName("second_surname")
    private String secondSurName;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("birth_place")
    private String birthPlace;
    @SerializedName("weight")
    private double weight;
    @SerializedName("height")
    private double height;

    private Date date;

    private SimpleDateFormat dateFormatFull =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS", Locale.getDefault());
    private DateFormat dateFormat =
            new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("es-ES"));

    public Person() {
    }
    public Person(Person P)
    {
        this.name = P.getName();
        this.firstSurName = P.getFirstSurName();
        this.secondSurName = P.getSecondSurName();
        this.birthday = P.getBirthday();
        this.birthPlace = P.getBirthPlace();
        this.weight = P.getWeight();
        this.height = P.getHeight();
    }
    public Person(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, double weight, double height) {
        this.name = name;
        this.firstSurName = firstSurName;
        this.secondSurName = secondSurName;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurName() {
        return firstSurName;
    }

    public void setFirstSurName(String firstSurName) {
        this.firstSurName = firstSurName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDateReformated() {
        try {
            setDate(dateFormatFull.parse(this.birthday));
            Log.d("Date", this.birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(date);
    }
    public Date getDate() {
        try {
            setDate(dateFormatFull.parse(this.birthday));
            Log.d("Date", this.birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}

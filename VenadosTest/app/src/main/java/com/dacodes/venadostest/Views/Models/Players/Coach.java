package com.dacodes.venadostest.Views.Models.Players;

import com.google.gson.annotations.SerializedName;

public class Coach extends Person {
    @SerializedName("role")
    private String role;
    @SerializedName("role_short")
    private String roleShort;
    @SerializedName("image")
    private String urlImage;

    public Coach() {
    }

    public Coach(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String role, String roleShort, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height);
        this.role = role;
        this.roleShort = roleShort;
        this.urlImage = urlImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleShort() {
        return roleShort;
    }

    public void setRoleShort(String roleShort) {
        this.roleShort = roleShort;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}

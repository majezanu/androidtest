package com.dacodes.venadostest.Views.Models.Players;

import java.io.Serializable;

public class Forward extends Player implements Serializable{
    public Forward() {
    }

    public Forward(Player p) {
        super(p);
    }

    public Forward(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height, position, number, positionShort, lastTeam, urlImage);
    }
}

package com.dacodes.venadostest.Views.Models.Players;

import java.io.Serializable;

public class Defense extends Player implements Serializable{
    public Defense(Player p) {
        super(p);
    }

    public Defense(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height, position, number, positionShort, lastTeam, urlImage);
    }
}

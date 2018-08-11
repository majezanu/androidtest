package com.dacodes.venadostest.Views.Models.Players;

public class Center extends Player {
    public Center(Player p) {
        super(p);
    }

    public Center(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height, position, number, positionShort, lastTeam, urlImage);
    }
}

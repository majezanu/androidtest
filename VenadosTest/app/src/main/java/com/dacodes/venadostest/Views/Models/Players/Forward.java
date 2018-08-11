package com.dacodes.venadostest.Views.Models.Players;

public class Forward extends Player {
    public Forward(Player p) {
        super(p);
    }

    public Forward(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height, position, number, positionShort, lastTeam, urlImage);
    }
}

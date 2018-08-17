package com.dacodes.venadostest.Views.Models.Players;

import java.io.Serializable;

public class GoalKeeper extends Player implements Serializable{
    public GoalKeeper() {
    }

    public GoalKeeper(Player p) {
        super(p);
    }

    public GoalKeeper(String name, String firstSurName, String secondSurName, String birthday, String birthPlace, float weight, float height, String position, int number, String positionShort, String lastTeam, String urlImage) {
        super(name, firstSurName, secondSurName, birthday, birthPlace, weight, height, position, number, positionShort, lastTeam, urlImage);
    }
}

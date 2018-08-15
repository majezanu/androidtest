package com.dacodes.venadostest.Views.Models.Players;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    @SerializedName("forwards")
    private ArrayList<Forward> forwards = new ArrayList<>();
    @SerializedName("centers")
    private ArrayList<Center> centers= new ArrayList<>();;
    @SerializedName("defenses")
    private ArrayList<Defense> defenses= new ArrayList<>();;
    @SerializedName("goalkeepers")
    private ArrayList<GoalKeeper> goalKeepers= new ArrayList<>();;
    @SerializedName("coaches")
    private ArrayList<Coach> coaches= new ArrayList<>();

    public Team() {
    }

    public Team(ArrayList<Forward> forwards, ArrayList<Center> centers, ArrayList<Defense> defenses, ArrayList<GoalKeeper> goalKeepers, ArrayList<Coach> coaches) {
        this.forwards = forwards;
        this.centers = centers;
        this.defenses = defenses;
        this.goalKeepers = goalKeepers;
        this.coaches = coaches;
    }

    public ArrayList<Person> getAllPeople()
    {
        ArrayList<Person> people = new ArrayList<>();
        people.addAll(forwards);
        people.addAll(centers);
        people.addAll(defenses);
        people.addAll(goalKeepers);
        people.addAll(coaches);
        return people;
    }
    public ArrayList<Player> getAllPlayers()
    {
        ArrayList<Player> players = new ArrayList<>();
        if(forwards.size()>0)
        {
            players.addAll(forwards);
        }
        if(centers.size()>0)
        {
            players.addAll(centers);
        }
        if(defenses.size()>0)
        {
            players.addAll(defenses);
        }
        if(goalKeepers.size()>0)
        {
            players.addAll(goalKeepers);
        }


        return players;
    }

    public ArrayList<Forward> getForwards() {
        return forwards;
    }

    public void setForwards(ArrayList<Forward> forwards) {
        this.forwards = forwards;
    }

    public ArrayList<Center> getCenters() {
        return centers;
    }

    public void setCenters(ArrayList<Center> centers) {
        this.centers = centers;
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }

    public void setDefenses(ArrayList<Defense> defenses) {
        this.defenses = defenses;
    }

    public ArrayList<GoalKeeper> getGoalKeepers() {
        return goalKeepers;
    }

    public void setGoalKeepers(ArrayList<GoalKeeper> goalKeepers) {
        this.goalKeepers = goalKeepers;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }
}

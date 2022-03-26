package me.wesleyh.teamtesting;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {
    public String name;
    public ArrayList<Player> members = new ArrayList<>();
    public int id;
    public Team(String name, ArrayList<Player> members) {
        this.name = name;
        this.members = members;
        addToManager();
    }
    public Team(String name){
        this.name=name;
        addToManager();
    }
    private void addToManager() {
        this.id = TeamManager.teams.size() - 1;
        TeamManager.teams.add(this);
    }

}

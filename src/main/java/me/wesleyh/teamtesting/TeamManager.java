package me.wesleyh.teamtesting;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Objects;

public class TeamManager {
    public static ArrayList<Team> teams = new ArrayList<>();
    public static boolean isATeam(String name){
        for (Team team : teams) {
            if (Objects.equals(team.name, name)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isATeam(Team t){
        return teams.contains(t);
    }
    public static String compileTeams(){
        String out = "";
        for(Team team: teams){
            out = out + team.name + ": ";
            for (Player p: team.members) {
                out = out + p.getName() + ", ";
            }
            out = out + ".";
        }
        return out;
    }
    public static void addPlayerToTeam(String name, Player p){
        for(Team team: teams){
            if (Objects.equals(team.name, name)) {
                team.members.add(p);
                return;
            }
        }
    }
    public static void addPlayerToTeam(Team t, Player p){
        for(Team team: teams){
            if (team.equals(t)){
                team.members.add(p);
            }
        }
    }
}

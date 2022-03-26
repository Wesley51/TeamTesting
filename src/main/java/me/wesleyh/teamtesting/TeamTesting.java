package me.wesleyh.teamtesting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeamTesting extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("team").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            switch (args[0]){
                case "create":
                    if (sender instanceof Player) {
                        Player p = (Player) sender;
                        Team newTeam = new Team(args[1]);
                        newTeam.members.add(p);
                        p.sendMessage(newTeam.name);
                        p.sendMessage(String.valueOf(newTeam.members));
                        p.sendMessage(TeamManager.teams.toString());
                        p.sendMessage(TeamManager.compileTeams());

                    }
                    else {
                        sender.sendMessage("stop it console man");
                    }
                    return true;
                case "check":
                    if (TeamManager.isATeam(args[1])){
                        sender.sendMessage("yes");
                    }
                    else {
                        sender.sendMessage("f no");
                    }
                    return true;
                case "join":
                    if (sender instanceof Player) {
                        Player p = (Player) sender;
                        if (TeamManager.isATeam(args[1])){
                            TeamManager.addPlayerToTeam(args[1], p);
                        }else {
                            sender.sendMessage("The team name you entered does not exist!");
                        }
                    }else sender.sendMessage("haha no");
                    return true;
            }
        } else {
            sender.sendMessage("Usage: /team <name>");
        }
        return true;
    }
}

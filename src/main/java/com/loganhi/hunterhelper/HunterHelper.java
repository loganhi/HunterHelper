package com.loganhi.hunterhelper;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;

public class HunterHelper extends JavaPlugin{
	ArrayList<String> playerLocations = new ArrayList<String>();
	
	
	@Override
    public void onEnable() {
		getLogger().info("onEnable has been invoked!");
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }
    
    public void findPlayers() {
    	getLogger().info("Entered findPlayer function");
    	Player target = Bukkit.getServer().getPlayer("FreakyPhonecase");
    	Bukkit.broadcastMessage("Looking for user " + target);
    }
    
    public void getLocation() {
    	
    }
    
    public void log() {
    	
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
    		// doSomething
    		findPlayers();
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the value of false will be returned.
    	return false; 
    }


}

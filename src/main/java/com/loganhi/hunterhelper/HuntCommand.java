package com.loganhi.hunterhelper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HuntCommand {
	Player hunter;
	Player hunted;
	
	public HuntCommand(Player hunter, Player hunted) {
		this.hunter = hunter;
		this.hunted = hunted;
		
	}

	public void setCompassOnPlayer() {
		//Bukkit.broadcastMessage("Setting the Compass on " + hunted.getName());
		hunter.setCompassTarget(hunted.getLocation());
	}

}

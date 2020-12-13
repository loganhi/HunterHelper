package com.loganhi.hunterhelper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class HunterHelper extends JavaPlugin{
	Thread compassThread;
	HuntCommand hunt;
	boolean running;
	//ArrayList<String> playerLocations = new ArrayList<String>();


	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
	
	public Player findPlayer(String player) {
		Player target = Bukkit.getServer().getPlayer(player);
		//Bukkit.broadcastMessage("Location of " + target.getDisplayName() + " is " + target.getLocation());
		return target;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("hunt")) {
			running = true;
			Bukkit.broadcastMessage("Started the hunt.");
			Player player = findPlayer(args[0]);
			Player comSender = findPlayer(sender.getName());
			hunt = new HuntCommand(comSender, player);
			
			//setCompassOnPlayer(comSender, player.getLocation());
			
			compassThread = new Thread(new Runnable() {
			    public void run() {
			    	while(running) {
			    		try {
				    		Bukkit.broadcastMessage("Running compass command. We are comming");
					    	hunt.setCompassOnPlayer();
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
			    }
			});
			compassThread.start();

			//player.getInventory().addItem(new ItemStack(Material.COMPASS));
			return true;
		} //If this has happened the function will return true. 
		if (cmd.getName().equalsIgnoreCase("stophunt")) {
			Bukkit.broadcastMessage("Stopping compass command.");
			running = false;
			return true;
		} 
		
		return false; 
	}


}

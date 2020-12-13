package com.loganhi.hunterhelper;

import org.bukkit.plugin.java.JavaPlugin;

public class HunterHelper extends JavaPlugin{
	
	@Override
    public void onEnable() {
		getLogger().info("onEnable has been invoked!");
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }


}

package github.Lucycraft.LucycraftModule.Kit;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import github.Lucycraft.LCCore.LCCore;
import github.Lucycraft.LucycraftModule.Kit.Includes.LCLogger;
import github.Lucycraft.LucycraftModule.Kit.Listeners.LCBlockListener;
import github.Lucycraft.LucycraftModule.Kit.Listeners.LCCommandListener;
import github.Lucycraft.LucycraftModule.Kit.Listeners.LCPlayerListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * LucycraftEconomy - Extend your minecraft experiance with an econmy system
 *
 * @authors Thisisboris and cskiwi
 */

public class LCModuleKit extends JavaPlugin {
	private final LCPlayerListener playerListener = new LCPlayerListener();
    private final LCBlockListener blockListener = new LCBlockListener();
    private final static LCCommandListener commandManager = new LCCommandListener();
    private Plugin LCCore;
	public static String name;
    public static String version;
    public static List<Player> Onlineplayerlist = new ArrayList<Player>();
    
    public void onEnable() {	
    	name = this.getDescription().getName();
        version = this.getDescription().getVersion();
    	
        // Logger
    	LCLogger.initialize(Logger.getLogger("Minecraft"));  	
    	
    	/*
         * Events
         */ 	
        PluginManager pm = getServer().getPluginManager();
        
        // get core
        LCCore = pm.getPlugin("LCCore");
        if (LCCore == null){
        	LCLogger.error("Can't find core plugin");
        	return;
        } else {
        	LCLogger.info("Linked to core");
        }
        
        // Block Events       
        pm.registerEvents(this.blockListener, this);
        // Player Events
        pm.registerEvents(this.playerListener, this);
        
        ((LCCore) LCCore).Activate(this);
        

        // If all fine 
        LCLogger.info(name + " version " + version + " is enabled!");
    }

    /*
     * This method runs when the plugin is disabling.
     */
    @Override
    public void onDisable() {
        //TDatabase.disable();

        // Block Events
    	HandlerList.unregisterAll(blockListener);
        // Player Events
    	HandlerList.unregisterAll(playerListener);
    	
    	/* 
    	 * TODO: Save everything! 
    	 */
    	
    	LCLogger.info(name + " has succesfully been disabled!");
    	
    }
    // just sending the commmands to the command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	return commandManager.onCommand(sender, command, label, args);
    }
    
    /* Getters and setters */
    public static LCCommandListener GetcommandManager(){
    	return commandManager;
    }
}
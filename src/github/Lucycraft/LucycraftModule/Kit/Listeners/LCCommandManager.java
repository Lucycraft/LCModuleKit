package github.Lucycraft.LucycraftModule.Kit.Listeners;

import java.util.ArrayList;

import github.Lucycraft.LCCore.Includes.LCDataHandeler;
import github.Lucycraft.LucycraftModule.Kit.Includes.LCLogger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @description Handles commands.
 * @authors Thisisboris and cskiwi
 */
public class LCCommandManager implements CommandExecutor {
	String prefix = colorizeText("[Lucycraft] ", ChatColor.GOLD);
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean handled = false;
        String message;
        if (is(label, "Kit")) {
        	
    		//------------------
			// Player
			//------------------
			if (isPlayer(sender)){
				if (args == null || args.length == 0){
		        	// list kits
		        	message = prefix + " Availible kits";
		        	sendMessage(sender, message);
	    			
	    			ArrayList<ArrayList<Object>> resultSet = LCDataHandeler.getData("SELECT * FROM kit");
	    			if (resultSet.isEmpty() == false) {  				
	    				
	    				String kits = "";
	    				for(int i = 0; i < resultSet.size(); i++) {
	    					kits += resultSet.get(i).get(2).toString();
	    					kits += i+1 != resultSet.size() ? ", " : "."; 
	    				}
	    				sendMessage(sender, kits);
	    			}
		        	
				} else {
					
					if (is(args[0],"Info")) {							
						ArrayList<ArrayList<Object>> resultSet = LCDataHandeler.getData("SELECT * FROM kit WHERE Alias = '" + args[1] + "' LIMIT 1;");
						if (resultSet == null || resultSet.size() == 0)
							sendMessage(sender, "That kit doesn't excists");
						else {
				        	sendMessage(sender, prefix + "info about " + resultSet.get(0).get(2).toString() + " (#" + resultSet.get(0).get(0) + ")");
				        	
				        	String author = LCDataHandeler.getData("SELECT Name FROM users WHERE Id = " +  resultSet.get(0).get(1) + " LIMIT 1;").get(0).get(0).toString();
				        	
				        	sendMessage(sender, "Author: " + author);
				        	sendMessage(sender, "Date: " + resultSet.get(0).get(3).toString());
				        	ArrayList<ArrayList<Object>> contents = LCDataHandeler.getData("SELECT * FROM kitcontents WHERE KitId = " + resultSet.get(0).get(0) + ";");
				        	if (contents == null || contents.size() == 0)
				        	sendMessage(sender, "Contents: no contents");
				        	else {
				        		sendMessage(sender, "Contents:");
				        		String Items = "";
			    				for(int i = 0; i < contents.size(); i++) {
			    					Items += contents.get(i).get(2).toString() + "x " + Material.values()[Integer.parseInt(contents.get(i).get(3).toString())];
			    					Items += i+1 != contents.size() ? ", " : "."; 
			    				}
			    				sendMessage(sender, Items);
			    				
			    				
				        	}
						}
					}
				}    			
    			handled = true;
    			
    		} else {
    		//-------------------
			// Terminal
			//-------------------
    			sendLog(sender, "Prepare for statistics dump!");
    			sendLog(sender, "Dump!");
    			sendLog(sender, "Dump!");
    			sendLog(sender, "Dump!");
    			sendLog(sender, "Dump!");
    			sendLog(sender, "Dump!");
    			sendLog(sender, "Holy shit that's a lot of dumps!");
    			handled = true;
    			
    		}
        }
        return handled;
    }

    // Simplifies and shortens the if statements for commands.
    private boolean is(String entered, String label) {
        return entered.equalsIgnoreCase(label);
    }

    // Checks if the current user is actually a player.
    private boolean isPlayer(CommandSender sender) {
        return sender != null && sender instanceof Player;
    }

    // Checks if the current user is actually a player and sends a message to that player.
    private boolean sendMessage(CommandSender sender, String message) {
        boolean sent = false;
        if (isPlayer(sender)) {
            Player player = (Player) sender;
            player.sendMessage(message);
            sent = true;
        }
        return sent;
    }
    
    public boolean sendMessageToPlayer(String message, Player player) {
    	boolean sent = false;
    	if (isPlayer(player)){
    		player.sendMessage(prefix + message);
    		sent = true;
    	}
    	return sent;
    }

    public boolean sendLog(CommandSender sender, String message) {
        boolean sent = false;
        if (!isPlayer(sender)) {
            LCLogger.info(message);
            sent = true;
        }
        return sent;
    }
    
    private String colorizeText(String text, ChatColor color) {
        return color + text + ChatColor.WHITE;
    }
}

package github.Lucycraft.LucycraftModule.Kit.Listeners;

import github.Lucycraft.LucycraftModule.Kit.LCModuleKit;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Handle events for all Player related events
 * @authors Thisisboris and cskiwi
 * 
 * 
 */

public class LCPlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getClickedBlock().getState() instanceof Sign) {
			// just testing around
			 Sign sign = (Sign)event.getClickedBlock().getState();
			
			LCModuleKit.GetcommandManager().sendMessageToPlayer(ChatColor.YELLOW + sign.getLine(2) + ChatColor.WHITE, event.getPlayer());
		}
	 }
	@EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
    	
    }
}

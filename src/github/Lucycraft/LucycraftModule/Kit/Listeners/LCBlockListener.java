package github.Lucycraft.LucycraftModule.Kit.Listeners;


import github.Lucycraft.LucycraftModule.Kit.LCModuleKit;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
/**
 * LucycraftCore block listener
 * @authors Thisisboris and cskiwi
 */


public class LCBlockListener implements Listener {
	@EventHandler
	public void onBlockBreak (BlockBreakEvent event) {
		if (event.isCancelled()) return;
		Block block = event.getBlock();
		Player player = event.getPlayer();
		event.setCancelled(CancelBreakBlock(player, block));
		// Location pos = player.getLocation();
	}
	private boolean CancelBreakBlock(Player player, Block block){
		boolean ReturnValue = false;
		
		
		if (block.getType() == Material.LOG) {
			
			
			LCModuleKit.GetcommandManager().sendMessageToPlayer(ChatColor.YELLOW + "" + ChatColor.WHITE, player);
			ReturnValue = true;
		}
		return ReturnValue;
	}

//
//    public void onBlockDamage(BlockDamageEvent event) {
//    }
//	
//	  public void onSignChange(SignChangeEvent event) {
//	      Player player = event.getPlayer();
//	  } 
//
//    public void onBlockCanBuild(BlockCanBuildEvent event) {
//    }
//
//    public void onBlockFromTo(BlockFromToEvent event) {
//    }
//    
//    public void onBlockFlow(BlockFromToEvent event) {
//    }
//
//    public void onBlockIgnite(BlockIgniteEvent event) {
//    }
//
//    public void onBlockPhysics(BlockPhysicsEvent event) {
//    }
//
//    public void onBlockRedstoneChange(BlockRedstoneEvent event) {
//    }
//
//    public void onLeavesDecay(LeavesDecayEvent event) {
//    }
//
//    public void onSignChange(SignChangeEvent event) {
//    }
//
//    public void onBlockBurn(BlockBurnEvent event) {
//    }
//
//    public void onBlockBreak(BlockBreakEvent event) {
//    }
//
//    public void onSnowForm(SnowFormEvent event) {
//    }
//
//    public void onBlockDispense(BlockDispenseEvent event) {
//    }
	
}

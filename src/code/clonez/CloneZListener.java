package code.clonez;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CloneZListener implements Listener {

	@EventHandler // DayZ chat.
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		List<Entity> nearby = p.getNearbyEntities(40, 40, 40); // will add this to the config so owners can edit the radius.
		Player s = null;
		for(Entity ent : nearby) {
			if(ent instanceof CraftPlayer) {
				s = (Player) ent;
				s.sendMessage(p.getName() + e.getMessage());
			}
		}
		if(p.getItemInHand().getType() == Material.EYE_OF_ENDER) {
			e.setCancelled(false);
		}
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
	}

}

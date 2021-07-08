package me.dennis.diamondfinder.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {
 boolean sound = true;
	int i = 0;
	int totalChecks=0;
	

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		if(e.getClickedBlock().getType().equals(Material.LEVER)) {
			sound = !sound;
		}
	}
	
	@EventHandler
	public void moveEvent(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Location loc = e.getPlayer().getLocation();
		World world = loc.getWorld();
		for (int x = -12; x <= 12; x++) {
            for (int z = -12; z <= 12; z++) {
                for (int y = -7; y <= 7; y++) {
                   Material material = player.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.DIAMOND_ORE || material == Material.ANCIENT_DEBRIS) {
                  //  if you want to reduce the spam noise  if (Math.floor(Math.random()*3) == 2) {
                   	 boolean lessThanFour = (Math.abs(loc.getX() - loc.add(x,y,z).getX()) < 4 && Math.abs(loc.getY() - loc.add(x,y,z).getY()) < 4 && Math.abs(loc.getZ() - loc.add(x,y,z).getZ()) < 4); 
                   	 boolean lessThanEight = (Math.abs(loc.getX() - loc.add(x,y,z).getX()) < 8 && Math.abs(loc.getY() - loc.add(x,y,z).getY()) < 8 && Math.abs(loc.getZ() - loc.add(x,y,z).getZ()) < 8);
                    	 if(lessThanFour && sound) {
                     		world.playSound(loc.add(x,y,z), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
                     		lessThanEight = false;
                     	 } else
                        	if(lessThanEight && sound) {
                        		world.playSound(loc.add(x,y,z), Sound.BLOCK_NOTE_BLOCK_HARP, 5, 1);
                        	
                        	} else
                        	if(sound) {  	
                        		world.playSound(loc.add(x,y,z), Sound.BLOCK_NOTE_BLOCK_BASS, 5, 1);
                    		}
                 //  } 	
                 } 
               }
            }
        }
	}
}
		

	

	

	



package xyz.baqel.zombieboss.zombieboss;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.potion.PotionEffectType.SPEED;

public class ZombieBoss extends JavaPlugin implements Listener {

    public void onEnable(){
        getLogger().info("ZombieBoss Plugin has been enabled");
    }

    public void onDisable(){

    }

    public void spawnZombie(Player player){
        Zombie zombie = (Zombie) player.getLocation().getWorld().spawn(player.getLocation(), Zombie.class);

        zombie.setCustomName(ChatColor.DARK_RED + "EvilKnight");
        zombie.setCustomNameVisible(true);
        zombie.setMaxHealth(2000);
        zombie.setHealth(2000);
        zombie.setBaby(true);
        zombie.getEquipment().setHelmet(new ItemStack(Material.GLASS));
        zombie.addPotionEffect(new PotionEffect(SPEED,2147483647, 12));
        //zombie.hasPotionEffect(PotionEffectType.SPEED);
        zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
        if (cmd.getName().equalsIgnoreCase("boss")) {
            Player player = (Player) sender;
            if (player.hasPermission("baqel.boss")) {
                spawnZombie(player);
                player.sendMessage(ChatColor.GREEN + "You have successfully spawned the boss!");
            }
        }
        return false;
    }
}

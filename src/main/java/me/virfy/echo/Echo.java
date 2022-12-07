package me.virfy.echo;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Echo extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Echo Loaded.");
        getServer().getPluginManager().registerEvents(this,this);
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            double damage = e.getFinalDamage();
            double RoundedDamage = Math.round(damage * 100.0) / 100.0;
            player.damage(damage);
            player.sendMessage(ChatColor.RED+"You dealt " + RoundedDamage  + " damage with melee, and in turn, you also recieved " + RoundedDamage + " damage.");
        }
    }
    @EventHandler
    public void onDamageByArrow(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getDamager();
            if (arrow.getShooter() instanceof LivingEntity) {
                LivingEntity player = (LivingEntity) arrow.getShooter();
                double BowDamage = event.getDamage();
                player.sendMessage(ChatColor.RED+"You dealt " + BowDamage + " damage with a bow, and in turn, you also recieved " + BowDamage + " damage.");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Echo Unloaded.");
    }
}

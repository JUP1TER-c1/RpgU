package me.udnek.rpgu.enchanting;

import me.udnek.itemscoreu.utils.SelfRegisteringListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EnchantmentTableListener extends SelfRegisteringListener {
    public EnchantmentTableListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerClicksEnchantmentTable(PlayerInteractEvent event){
        if (event.isCancelled()) return;
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) return;
        if (event.getClickedBlock() == null) return;
        if (event.getClickedBlock().getType() != Material.ENCHANTING_TABLE) return;
        event.setCancelled(true);
        new EnchantmentTableInventory().open(event.getPlayer());
    }

}
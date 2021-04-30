package me.lubek.battleroyalesky;

import me.lubek.battleroyalesky.libs.CooldownManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import me.lubek.battleroyalesky.libs.manager;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import me.lubek.battleroyalesky.libs.scoreboard;

public class events implements Listener {
    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent e) {
        manager.removelastKit(e.getPlayer().getUniqueId());
    }
    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e) {
        Location location = e.getPlayer().getLocation();

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        Block block = e.getPlayer().getWorld().getBlockAt(x,y-1,z);
        Material material = block.getType();
        World world = Bukkit.getWorld("sw1");
        Player p = e.getPlayer();
        if (material==Material.DIAMOND_BLOCK) {
            if(p.getWorld()==world) {
                Plugin plugin = Bukkit.getPluginManager().getPlugin("Battleroyalesky");
                int timeLeft = CooldownManager.getCooldown(p.getUniqueId());
                if (timeLeft == 0) {
                    manager.GiveRandomItem(p, 1);

                    CooldownManager.setCooldown(p.getUniqueId(), CooldownManager.DEFAULT_COOLDOWN);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            int timeLeft = CooldownManager.getCooldown(p.getUniqueId());
                            CooldownManager.setCooldown(p.getUniqueId(), --timeLeft);
                            scoreboard.ResetScoreboard(p);
                            if (timeLeft == 0) {
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 20, 20);
                }
            }
        }
        }
    }

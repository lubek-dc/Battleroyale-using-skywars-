package me.lubek.battleroyalesky.libs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class scoreboard {
    public static void ResetScoreboard(Player player) {
            ScoreboardManager m = Bukkit.getScoreboardManager();
            int timeLeft = CooldownManager.getCooldown(player.getUniqueId());
            Scoreboard b = m.getNewScoreboard();
            Objective o = b.registerNewObjective("Gold", "");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.setDisplayName(ChatColor.GREEN + "[LUBEK SERVER]");
            Score Przywitanie = o.getScore("Deathmatch");
            Score plr = o.getScore("Pozostałych graczy: ");
            String aksept = "";
            String zostalo = "";
            if (timeLeft==0) {
                aksept = ChatColor.GRAY+"["+ChatColor.GREEN+"✓"+ChatColor.GRAY+"]";
                player.sendMessage(ChatColor.GOLD+"[DeathMatch] "+ChatColor.GREEN+"Generator Gotowy!");
                player.sendTitle(ChatColor.GREEN+"Generator gotowy!",ChatColor.GOLD+"DeathMatch");
                player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE,10,1);
            }
            else {
                aksept = ChatColor.GRAY+"["+ChatColor.RED+"✗"+ChatColor.GRAY+"]";
                zostalo = ChatColor.GRAY+"["+ChatColor.RED+timeLeft+ChatColor.GRAY+"]";
            }
            Score zostaloczasu = o.getScore("Generator za: "+zostalo);
            Score cooldown = o.getScore("Generator: " + aksept);
            Przywitanie.setScore(9);
            plr.setScore(8);
            cooldown.setScore(7);
            zostaloczasu.setScore(6);
            player.setScoreboard(b);
    }
}

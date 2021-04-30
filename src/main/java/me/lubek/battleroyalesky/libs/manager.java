package me.lubek.battleroyalesky.libs;

import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class manager {
    private static final Map<UUID, Integer> lastkit = new HashMap<>();
    public static void setlastKit(UUID player, int kit){
        lastkit.put(player, kit);
    }
    public static void removelastKit(UUID player){
        lastkit.remove(player);
    }
    public static int getlastkit(UUID player){
        return lastkit.getOrDefault(player, 0);
    }
    public static void GiveRandomItem(Player player, int Tier){
        if(player.getWorld()==Bukkit.getWorld("sw1")){
            int Times = Tier * 3;
            Random rand = new Random();
            int ID = rand.nextInt(Times); //
            ID += 1;
            PlayerInventory pi = player.getInventory();
            pi.clear();
            if (Tier == 1) {
                if (ID == 1) { // ruby kit
                    if (manager.getlastkit(player.getUniqueId()) == 1) {
                        manager.GiveRandomItem(player, 1);
                        player.sendMessage("returned");
                    }
                    ItemStack ruby_head = ItemsAdder.getCustomItem("ruby_head");
                    pi.setHelmet(ruby_head);

                    ItemStack ruby_chest = ItemsAdder.getCustomItem("ruby_chest");
                    pi.setChestplate(ruby_chest);

                    ItemStack ruby_legs = ItemsAdder.getCustomItem("ruby_legs");
                    pi.setLeggings(ruby_legs);

                    ItemStack ruby_boots = ItemsAdder.getCustomItem("ruby_boots");
                    pi.setBoots(ruby_boots);

                    ItemStack ruby_sword = ItemsAdder.getCustomItem("ruby_sword");
                    pi.addItem(ruby_sword);

                    ItemStack blocks = new ItemStack(Material.DIRT, 64);
                    pi.addItem(blocks);
                    manager.setlastKit(player.getUniqueId(), 1);

                } else if (ID == 2) { // amethyst kit
                    if (manager.getlastkit(player.getUniqueId()) == 2) {
                        manager.GiveRandomItem(player, 1);
                        player.sendMessage("returned");
                    }
                    ItemStack amethyst_head = ItemsAdder.getCustomItem("amethyst_head");
                    ItemStack amethyst_chest = ItemsAdder.getCustomItem("amethyst_chest");
                    ItemStack amethyst_legs = ItemsAdder.getCustomItem("amethyst_legs");
                    ItemStack amethyst_boots = ItemsAdder.getCustomItem("amethyst_boots");
                    ItemStack amethyst_sword = ItemsAdder.getCustomItem("amethyst_sword");


                    pi.setHelmet(amethyst_head);
                    pi.setChestplate(amethyst_chest);
                    pi.setLeggings(amethyst_legs);
                    pi.setBoots(amethyst_boots);
                    ItemStack blocks = new ItemStack(Material.DIRT, 64);
                    pi.addItem(blocks);
                    pi.addItem(
                            amethyst_sword
                    );
                    manager.setlastKit(player.getUniqueId(), 2);
                } else if (ID == 3) {// archer kit
                    if (manager.getlastkit(player.getUniqueId()) == 3) {
                        manager.GiveRandomItem(player, 1);
                        player.sendMessage("returned");
                    }
                    ItemStack ruby_head = new ItemStack(Material.LEATHER_HELMET, 1);
                    pi.setHelmet(ruby_head);

                    ItemStack ruby_chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                    pi.setChestplate(ruby_chest);

                    ItemStack ruby_legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                    pi.setLeggings(ruby_legs);

                    ItemStack ruby_boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                    pi.setBoots(ruby_boots);

                    ItemStack ruby_sword = ItemsAdder.getCustomItem("amethyst_sword");
                    pi.addItem(ruby_sword);

                    ItemStack blocks = new ItemStack(Material.DIRT, 64);
                    ItemStack bow = new ItemStack(Material.BOW, 1);
                    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1);
                    ItemMeta bowmeta = bow.getItemMeta();
                    bowmeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
                    bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    bowmeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
                    bow.setItemMeta(bowmeta);
                    ItemStack arrow = new ItemStack(Material.ARROW, 10);

                    pi.addItem(
                            blocks,
                            bow,
                            arrow,
                            gapple
                    );
                    manager.setlastKit(player.getUniqueId(), 3);

                }
            }
        }
    }
}

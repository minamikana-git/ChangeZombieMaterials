package org.hotal.changezombiematerials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChangeZombieMaterials extends JavaPlugin implements Listener {

    private final Random random = new Random();

    private final List<Material> helmetMaterials = Arrays.asList(Material.DIAMOND_HELMET);
    private final List<Material> chestplateMaterials = Arrays.asList(Material.DIAMOND_CHESTPLATE);
    private final List<Material> leggingsMaterials = Arrays.asList(Material.DIAMOND_LEGGINGS);
    private final List<Material> bootsMaterials = Arrays.asList(Material.DIAMOND_BOOTS);
    private final List<Material> weaponMaterials = Arrays.asList(Material.DIAMOND_SWORD);

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (EntityType.ZOMBIE == event.getEntityType()) {
            ItemStack helmet = new ItemStack(helmetMaterials.get(random.nextInt(helmetMaterials.size())));
            helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            ItemMeta helmetMeta = helmet.getItemMeta();
            helmetMeta.setDisplayName("Zombie's Helmet");
            helmet.setItemMeta(helmetMeta);

            ItemStack chestplate = new ItemStack(chestplateMaterials.get(random.nextInt(chestplateMaterials.size())));
            chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            chestplateMeta.setDisplayName("Zombie's Chestplate");
            chestplate.setItemMeta(chestplateMeta);

            ItemStack leggings = new ItemStack(leggingsMaterials.get(random.nextInt(leggingsMaterials.size())));
            leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            ItemMeta leggingsMeta = leggings.getItemMeta();
            leggingsMeta.setDisplayName("Zombie's Leggings");
            leggings.setItemMeta(leggingsMeta);

            ItemStack boots = new ItemStack(bootsMaterials.get(random.nextInt(bootsMaterials.size())));
            boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            ItemMeta bootsMeta = boots.getItemMeta();
            bootsMeta.setDisplayName("Zombie's Boots");
            boots.setItemMeta(bootsMeta);

            ItemStack weapon = new ItemStack(weaponMaterials.get(random.nextInt(weaponMaterials.size())));
            weapon.addEnchantment(Enchantment.DAMAGE_ALL, 1);
            ItemMeta weaponMeta = weapon.getItemMeta();
            weaponMeta.setDisplayName("Zombie's Weapon");
            weapon.setItemMeta(weaponMeta);

            // Add the created items to the zombie's equipment
            event.getEntity().getEquipment().setHelmet(helmet);
            event.getEntity().getEquipment().setChestplate(chestplate);
            event.getEntity().getEquipment().setLeggings(leggings);
            event.getEntity().getEquipment().setBoots(boots);
            event.getEntity().getEquipment().setItemInHand(weapon);
        }
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

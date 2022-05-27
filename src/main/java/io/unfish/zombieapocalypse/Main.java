package io.unfish.zombieapocalypse;

import org.bukkit.*;
import org.bukkit.block.Chest;
import org.bukkit.block.data.type.TNT;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {
    private int taskid = -1;
    private Material block;
    public BossBar bmb;
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Plugin ZombieApocalypse has been running");
        this.saveDefaultConfig();
        block = Material.getMaterial(this.getConfig().getString("block:"));
        taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(this,
                new Runnable() {
                    @Override
                    public void run() {
                        if (Bukkit.getOnlinePlayers().size() > 0)
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                for (Entity entity : player.getChunk().getEntities()) {
                                    if (entity.getType().equals(EntityType.ZOMBIE)) {
                                        Zombie zombie = (Zombie) entity;
                                        zombie.setTarget(player);
                                        World world = player.getWorld();
                                        for (Entity entity2 : world.getEntities()) {
                                            if (entity2.getType().equals(EntityType.ZOMBIE)) {
                                                Zombie zombies = (Zombie) entity2;
                                                zombies.setTarget(player);
                                                int playerY = player.getLocation().getBlockY();
                                                int playerX = player.getLocation().getBlockX();
                                                int playerz = player.getLocation().getBlockZ();
                                                int zombieY = zombie.getLocation().getBlockY();
                                                int zombieX = zombie.getLocation().getBlockX();
                                                int zombieZ = zombie.getLocation().getBlockZ();
                                                // playerY > zombieY
                                                    if (playerY - zombieY >= 1 && playerY - zombieY <= 22) {
                                                        if (playerX == zombieX && playerz == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean(""))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }

                                                        }
                                                        if (playerX == zombieX && playerz - 1 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX == zombieX && playerz + 1 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block")){
                                                                if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX - 1 == zombieX && playerz == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX + 1 == zombieX && playerz - 1 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                    zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX == zombieX && playerz - 2 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX == zombieX && playerz + 2 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX - 2 == zombieX && playerz == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX + 2 == zombieX && playerz - 1 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        //3
                                                        if (playerX == zombieX && playerz - 3 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX == zombieX && playerz + 3 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX - 3 == zombieX && playerz == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if (!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                        if (playerX + 3 == zombieX && playerz - 1 == zombieZ) {
                                                            long random = Math.round(Math.random() * 100 + 1);
                                                            if (random <= 40) {
                                                                Location loc12 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY + 1, zombieZ).getLocation();
                                                                if(getConfig().getBoolean("place_block"))
                                                                {if(!(loc12.getBlock().getType().equals(block)))
                                                                    loc12.getBlock().setType(Material.AIR);
                                                                zombie.teleport(loc12);
                                                                Location loc13 = zombie.getWorld().getBlockAt(zombieX,
                                                                        zombieY - 1, zombieZ).getLocation();
                                                                loc13.getBlock().setType(Material.COBBLESTONE);}
                                                            }
                                                        }
                                                    }
                                            // playerY < zombieY
                                                if(getConfig().getBoolean("break_block"))
                                                {if (zombieY - playerY >= 2 && zombieY - playerY <= 12) {
                                                    if (zombieX == playerX && zombieZ == playerz) {
                                                        Location loc1 = player.getWorld().getBlockAt(
                                                                playerX, zombieY - 1, playerz
                                                        ).getLocation();
                                                        if(!(loc1.getBlock().getType().equals(block)))
                                                        player.getWorld().getBlockAt(loc1).setType(Material.AIR);
                                                    }
                                                    if (zombieX - 1 == playerX && zombieZ == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);

                                                    }
                                                    if (zombieX + 1 == playerX && zombieZ == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX == playerX || zombieZ + 1 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX == playerX || zombieZ - 1 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX - 2 == playerX && zombieZ == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX + 2 == playerX && zombieZ == playerz) {

                                                    }
                                                    if (zombieX == playerX || zombieZ + 2 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX == playerX || zombieZ - 2 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX - 3 == playerX && zombieZ == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX + 3 == playerX && zombieZ == playerz) {

                                                    }
                                                    if (zombieX == playerX || zombieZ + 3 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX == playerX || zombieZ - 3 == playerz) {
                                                        Location loc14 = zombie.getWorld().getBlockAt(
                                                                zombieX, zombieY - 1, zombieZ
                                                        ).getLocation();
                                                        if(!(loc14.getBlock().getType().equals(block)))
                                                        loc14.getBlock().setType(Material.AIR);
                                                    }
                                                }}if(getConfig().getBoolean("place_block"))
                                                {if (zombieY - playerY == 1) {
                                                    if (zombieX - 1 == playerX && playerz == zombieZ) {
                                                        Location loc11 = player.getWorld().getBlockAt(
                                                                playerX, playerY + 1, playerz
                                                        ).getLocation();
                                                        player.getWorld().getBlockAt(loc11).setType(Material.COBBLESTONE);
                                                    }
                                                    if (zombieX + 1 == playerX && zombieZ == playerz) {
                                                        Location loc11 = player.getWorld().getBlockAt(
                                                                playerX, playerY + 1, playerz
                                                        ).getLocation();
                                                        player.getWorld().getBlockAt(loc11).setType(Material.COBBLESTONE);
                                                    }
                                                    if (zombieZ - 1 == playerz && zombieX == playerX) {
                                                        Location loc11 = player.getWorld().getBlockAt(
                                                                playerX, playerY + 1, playerz
                                                        ).getLocation();
                                                        player.getWorld().getBlockAt(loc11).setType(Material.COBBLESTONE);
                                                    }
                                                    if (zombieZ + 1 == playerz && playerX == zombieX) {
                                                        Location loc11 = player.getWorld().getBlockAt(
                                                                playerX, playerY + 1, playerz
                                                        ).getLocation();
                                                        player.getWorld().getBlockAt(loc11).setType(Material.COBBLESTONE);
                                                    }
                                                }}
                                                if(getConfig().getBoolean("break_block"))
                                                {if (zombieY == playerY || zombieY - playerY == 1 ||
                                                        playerY - zombieY == 1) {
                                                    //zombieX - 2  = PlayerX
                                                    if (zombieX - 2 == playerX && zombieZ == playerz) {
                                                        Location loc2 = player.getWorld().getBlockAt(
                                                                playerX + 1, zombieY, playerz
                                                        ).getLocation();
                                                        Location loc3 = player.getWorld().getBlockAt(
                                                                playerX + 1, zombieY + 1, playerz
                                                        ).getLocation();
                                                        if(!(loc2.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc2).setType(Material.AIR);
                                                        if(!(loc3.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc3).setType(Material.AIR);
                                                    }
                                                    // zombieZ - 2 = PlayerZ
                                                    if (zombieZ - 2 == playerz && zombieX == playerX) {
                                                        Location loc4 = player.getWorld().getBlockAt(
                                                                playerX, zombieY, playerz + 1
                                                        ).getLocation();
                                                        Location loc5 = player.getWorld().getBlockAt(
                                                                playerX, zombieY + 1, playerz + 1
                                                        ).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc4).setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc5).setType(Material.AIR);
                                                    }
                                                    if (zombieX + 2 == playerz && zombieZ == playerz) {
                                                        Location loc7 = player.getWorld().getBlockAt(
                                                                playerX - 1, zombieY, playerz
                                                        ).getLocation();
                                                        Location loc8 = player.getWorld().getBlockAt(
                                                                playerX - 1, zombieY + 1, playerz
                                                        ).getLocation();
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc7).setType(Material.AIR);
                                                        if(!(loc8.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc8).setType(Material.AIR);
                                                    }
                                                    if (zombieZ + 2 == playerz && zombieX == playerX) {
                                                        Location loc9 = player.getWorld().getBlockAt(
                                                                playerX, zombieY, playerz - 1
                                                        ).getLocation();
                                                        Location loc10 = player.getWorld().getBlockAt(
                                                                playerX, zombieY + 1, playerz - 1
                                                        ).getLocation();
                                                        if(!(loc9.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc9).setType(Material.AIR);
                                                        if(!(loc10.getBlock().getType().equals(block)))
                                                        world.getBlockAt(loc10).setType(Material.AIR);
                                                    }
                                                    if (zombieX - 3 == playerX && zombieZ == playerz) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX - 1,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX - 2,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX - 1,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX - 2,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);


                                                    }
                                                    if (zombieZ - 3 == playerz && zombieX == playerX) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ - 1).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ - 2).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ - 1).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ - 2).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX + 3 == playerz && zombieZ == playerz) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX + 1,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX + 2,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX + 1,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX + 2,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieZ + 3 == playerz && zombieX == playerX) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ + 1).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ + 2).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ + 1).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ + 2).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX - 4 == playerX && zombieZ == playerz) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX - 1,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX - 2,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX - 1,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX - 2,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc8 = zombie.getWorld().getBlockAt(zombieX - 3,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc9 = zombie.getWorld().getBlockAt(zombieX - 3,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                        if(!(loc8.getBlock().getType().equals(block)))
                                                        loc8.getBlock().setType(Material.AIR);
                                                        if(!(loc9.getBlock().getType().equals(block)))
                                                        loc9.getBlock().setType(Material.AIR);
                                                    }
                                                    // zombieZ - 2 = PlayerZ
                                                    if (zombieZ - 4 == playerz && zombieX == playerX) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ - 1).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ - 2).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ - 2).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ - 1).getLocation();
                                                        Location loc8 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ - 3).getLocation();
                                                        Location loc9 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ - 3).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                        if(!(loc8.getBlock().getType().equals(block)))
                                                        loc8.getBlock().setType(Material.AIR);
                                                        if(!(loc9.getBlock().getType().equals(block)))
                                                        loc9.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieX + 4 == playerz && zombieZ == playerz) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX + 1,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX + 2,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX + 1,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX + 2,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        Location loc8 = zombie.getWorld().getBlockAt(zombieX + 3,
                                                                zombieY, zombieZ).getLocation();
                                                        Location loc9 = zombie.getWorld().getBlockAt(zombieX + 3,
                                                                zombieY + 1, zombieZ).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                        if(!(loc8.getBlock().getType().equals(block)))
                                                        loc8.getBlock().setType(Material.AIR);
                                                        if(!(loc9.getBlock().getType().equals(block)))
                                                        loc9.getBlock().setType(Material.AIR);
                                                    }
                                                    if (zombieZ + 4 == playerz && zombieX == playerX) {
                                                        Location loc4 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ + 2).getLocation();
                                                        Location loc5 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ + 1).getLocation();
                                                        Location loc6 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ + 2).getLocation();
                                                        Location loc7 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ + 1).getLocation();
                                                        Location loc8 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY, zombieZ + 3).getLocation();
                                                        Location loc9 = zombie.getWorld().getBlockAt(zombieX,
                                                                zombieY + 1, zombieZ + 3).getLocation();
                                                        if(!(loc4.getBlock().getType().equals(block)))
                                                        loc4.getBlock().setType(Material.AIR);
                                                        if(!(loc5.getBlock().getType().equals(block)))
                                                        loc5.getBlock().setType(Material.AIR);
                                                        if(!(loc6.getBlock().getType().equals(block)))
                                                        loc6.getBlock().setType(Material.AIR);
                                                        if(!(loc7.getBlock().getType().equals(block)))
                                                        loc7.getBlock().setType(Material.AIR);
                                                        if(!(loc8.getBlock().getType().equals(block)))
                                                        loc8.getBlock().setType(Material.AIR);
                                                        if(!(loc9.getBlock().getType().equals(block)))
                                                        loc9.getBlock().setType(Material.AIR);
                                                    }
                                                }}
                                            }
                                        }
                                    }
                                }
                            }
                    }
                }, 0, 60);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin turned off");
        getbar().removeAll();
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @EventHandler
    public void ZombieCantBeBurntInDayAndMore(EntitySpawnEvent event) {
        if (event.getEntity().getType().equals(EntityType.ZOMBIE)) {
            Zombie zombie = (Zombie) event.getEntity();
            if(this.getConfig().getBoolean("not_burn_in_day")){
                zombie.setShouldBurnInDay(false);
            }
                if(this.getConfig().getBoolean("run_faster")){
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                            27000, 1));
                }

            long random = Math.round(Math.random() * 100 + 1);
            if(this.getConfig().getBoolean("pickup_all_items")){
                zombie.setCanPickupItems(true);
            }

        }
    }

    @EventHandler
    public void ZombieDamageIncrease(EntityDamageByEntityEvent event) {
        if (event.getEntity().getType().equals(EntityType.PLAYER)) {
            Player player = (Player) event.getEntity();
            if(this.getConfig().getBoolean("attack_stronger"))
            {if (event.getDamager().getType().equals(EntityType.ZOMBIE)) {
                Zombie zombie = (Zombie) event.getDamager();
                player.setHealth(player.getHealth() - player.getHealth() / 5);
                long random = Math.round(Math.random() * 100 + 1);
                if (random >= 50) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                            15, 1));
                }
                if (random == 10) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                            10, 1));
                }
                if (random <= 30) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                            120, 2));
                }
                if (random <= 20) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                            120, 2));
                }
            }}
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()){
            if(label.equalsIgnoreCase("bloodmoon")){
                createbar();
                try{
                    if(bmb.getPlayers().size() == 0){
                        if(Bukkit.getOnlinePlayers().size() > 0){
                            for(Player player: Bukkit.getOnlinePlayers()){ ;
                                addbar(player);
                            }
                        }
                    }else if(bmb.getPlayers().size() > 0){
                        bmb.removeAll();
                        if(Bukkit.getPluginManager().getPlugins().length > 1){
                            for(Plugin plugin: Bukkit.getPluginManager().getPlugins()){
                                if(plugin.getName().equalsIgnoreCase("plugmanx")){
                                    this.getServer().dispatchCommand(this.getServer().getConsoleSender(),
                                            "plugman reload ZombieApocalypse");
                                    return true;
                                }
                            }
                        }

                    }


                }catch(Exception e){
                    sender.sendMessage(format("&4Generated an error while the plugin was creating event"));
                    return true;
                }
            }
        }
        return super.onCommand(sender, command, label, args);
    }
    public void createbar(){
        bmb = Bukkit.createBossBar(format("&cBlood&bMoon"),BarColor.RED,
                BarStyle.SOLID,BarFlag.DARKEN_SKY);
        cast();
    }
    public BossBar getbar(){
            return bmb;
    }
    public boolean cast(){
        int i;
        i = Bukkit.getScheduler().scheduleSyncRepeatingTask(this,
                new Runnable() {
            double progress = 1.0;
            double time = 1.0/10;
                    @Override
                    public void run() {
                        bmb.setProgress(progress);
                        progress = progress - time;
                        try{
                          for(Player player: Bukkit.getOnlinePlayers()){
                              Chunk chunk = player.getChunk();
                              Entity[] entities = chunk.getEntities();
                              for(Entity entity: entities){
                                  if(entity.getType().equals(EntityType.ZOMBIE)){
                                      Zombie zombie = (Zombie)entity;
                                      zombie.addPotionEffect(new PotionEffect(
                                              PotionEffectType.INCREASE_DAMAGE,
                                              27000,2
                                      ));
                                  }if(entity.getType().equals(EntityType.SKELETON)){
                                      Skeleton ske = (Skeleton)entity;
                                      ske.setCustomName(format(getConfig().getString("skeleton_cname")));
                                      ske.addPotionEffect(new PotionEffect(PotionEffectType.
                                              SPEED,27000,2));
                                  }
                                  if(entity.getType().equals(EntityType.CREEPER)){
                                      Creeper creeper = (Creeper)entity;
                                      creeper.setExplosionRadius(getConfig().getInt(
                                              "creeper_ex_radi"
                                      ));
                                  }
                                  if(getConfig().getBoolean("harmful_eff_plr")){
                                      player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                              450,2));
                                      player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
                                              900,2));
                                      player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                                              900,2));
                                      player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                              450,3));
                                  }

                              }
                          }
                        }catch(Exception e){

                        }
                        if(progress >= 0){
                            bmb.removeAll();
                            bmb.setProgress(1.0);
                        }
                    }
                },0,1800);
        return true;
    }
    public void addbar(Player player){
        bmb.addPlayer(player);
    }
}



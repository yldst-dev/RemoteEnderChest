package com.example.chestplugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChestPlugin extends JavaPlugin implements Listener {
    private final Set<UUID> remoteEnderChestViewers = new HashSet<>();

    @Override
    public void onEnable() {
        if (getCommand("chest") == null) {
            throw new IllegalStateException("Command chest is not defined in plugin.yml");
        }

        getCommand("chest").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }

        remoteEnderChestViewers.remove(player.getUniqueId());

        if (player.openInventory(player.getEnderChest()) == null) {
            player.sendMessage("엔드상자를 열 수 없습니다.");
            return true;
        }

        remoteEnderChestViewers.add(player.getUniqueId());
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
        return true;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player player)) {
            return;
        }

        if (event.getView().getTopInventory() != player.getEnderChest()) {
            return;
        }

        if (!remoteEnderChestViewers.remove(player.getUniqueId())) {
            return;
        }

        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        remoteEnderChestViewers.remove(event.getPlayer().getUniqueId());
    }
}

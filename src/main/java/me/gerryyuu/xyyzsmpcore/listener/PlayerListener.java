package me.gerryyuu.xyyzsmpcore.listener;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import me.gerryyuu.xyyzsmpcore.util.ColorUtil;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public final class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (String line : SMPCore.getMessageOnJoinLists()) {
            event.getPlayer().sendMessage(ColorUtil.parseColor(line));
        }
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 0F);
        try {
            if (!SMPCore.getPlayerDataManager().getFile(event.getPlayer().getUniqueId().toString()).exists()) {
                SMPCore.getPlayerDataManager().getFile(event.getPlayer().getUniqueId().toString()).createNewFile();
                SMPCore.getPlayerDataManager().getConfig(event.getPlayer().getUniqueId().toString()).set("name", event.getPlayer().getName());
                SMPCore.getPlayerDataManager().getConfig(event.getPlayer().getUniqueId().toString()).set("uuid", event.getPlayer().getUniqueId().toString());
                SMPCore.getPlayerDataManager().saveConfig(event.getPlayer().getUniqueId().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
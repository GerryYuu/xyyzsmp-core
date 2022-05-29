package me.gerryyuu.xyyzsmpcore.listener;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import me.gerryyuu.xyyzsmpcore.util.ColorUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public final class ServerListener implements Listener {
    @EventHandler
    public void onServerPing(ServerListPingEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : SMPCore.getMotdLists()) {
            stringBuilder.append(line).append("\n");
        }
        event.setMotd(ColorUtil.parseColor(stringBuilder.toString()));
    }
}

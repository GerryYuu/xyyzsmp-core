package me.gerryyuu.xyyzsmpcore.listener;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import me.gerryyuu.xyyzsmpcore.manager.PluginDataManager;
import me.gerryyuu.xyyzsmpcore.util.ColorUtil;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public final class EntityListener implements Listener {
    @EventHandler
    public void CreeperExplode(EntityExplodeEvent event) {
        if (!((Boolean) ((PluginDataManager) SMPCore.getPluginDataManager()).getDefaultConfigEntry("misc.doCreepersBreakBlock"))) {
            if (event.getEntityType().equals(EntityType.CREEPER)) {
                event.blockList().clear();
                Firework firework = event.getEntity().getWorld().spawn(event.getEntity().getLocation(), Firework.class);
                FireworkMeta fireworkMeta = firework.getFireworkMeta();
                Random random = new Random();
                int randomTypeInt = random.nextInt(5) + 1;
                FireworkEffect.Type type;
                switch (randomTypeInt) {
                    default -> {
                        type = FireworkEffect.Type.BALL;
                    }
                    case 2 -> {
                        type = FireworkEffect.Type.BALL_LARGE;
                    }
                    case 3 -> {
                        type = FireworkEffect.Type.BURST;
                    }
                    case 4 -> {
                        type = FireworkEffect.Type.CREEPER;
                    }
                    case 5 -> {
                        type = FireworkEffect.Type.STAR;
                    }
                }
                int colorID1 = random.nextInt(17) + 1;
                int colorID2 = random.nextInt(17) + 1;
                Color color1 = ColorUtil.getColor(colorID1);
                Color color2 = ColorUtil.getColor(colorID2);
                FireworkEffect effect = FireworkEffect.builder().flicker(random.nextBoolean()).withColor(color1).withFade(color2).with(type).trail(random.nextBoolean()).build();
                fireworkMeta.addEffect(effect);
                fireworkMeta.setPower(1);
                firework.setFireworkMeta(fireworkMeta);
            }
        }
    }
}

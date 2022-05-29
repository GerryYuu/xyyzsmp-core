package me.gerryyuu.xyyzsmpcore.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;

public final class ColorUtil {
    private ColorUtil() {
    }

    public static String parseColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Color getColor(int c) {
        switch (c) {
            default: {
                return Color.AQUA;
            }
            case 2: {
                return Color.BLACK;
            }
            case 3: {
                return Color.BLUE;
            }
            case 4: {
                return Color.FUCHSIA;
            }
            case 5: {
                return Color.GRAY;
            }
            case 6: {
                return Color.GREEN;
            }
            case 7: {
                return Color.LIME;
            }
            case 8: {
                return Color.MAROON;
            }
            case 9: {
                return Color.NAVY;
            }
            case 10: {
                return Color.OLIVE;
            }
            case 11: {
                return Color.ORANGE;
            }
            case 12: {
                return Color.PURPLE;
            }
            case 13: {
                return Color.RED;
            }
            case 14: {
                return Color.SILVER;
            }
            case 15: {
                return Color.TEAL;
            }
            case 16: {
                return Color.WHITE;
            }
            case 17:
        }
        return Color.BLUE;
    }
}

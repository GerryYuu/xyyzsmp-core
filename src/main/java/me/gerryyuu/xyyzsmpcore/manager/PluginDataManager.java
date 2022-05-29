package me.gerryyuu.xyyzsmpcore.manager;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;

public final class PluginDataManager extends DataFileManager {
    public PluginDataManager() {
        super(SMPCore.getPlugin().getDataFolder());
    }

    public FileConfiguration getDefaultConfig() {
        return getConfig("config.yml");
    }

    public void reloadDefaultConfig() throws IOException, InvalidConfigurationException {
        reloadConfig("config.yml");
    }

    public void saveDefaultConfigToFile() throws IOException {
        saveConfig("config.yml");
    }

    public Object getDefaultConfigEntry(String key) {
        return getConfig("config.yml").get(key);
    }
}

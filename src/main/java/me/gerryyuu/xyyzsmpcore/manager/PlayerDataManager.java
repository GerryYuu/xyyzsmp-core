package me.gerryyuu.xyyzsmpcore.manager;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class PlayerDataManager extends DataFileManager {
    public PlayerDataManager(File dataFolder) {
        super(dataFolder);
    }

    public File getPlayerDataFile(UUID uuid) {
        return getFile(uuid.toString() + ".yml");
    }

    public FileConfiguration getPlayerData(UUID uuid) {
        return getConfig(uuid.toString() + ".yml");
    }

    public void savePlayerDataFile(UUID uuid) throws IOException {
        saveConfig(uuid.toString() + ".yml");
    }
}

package me.gerryyuu.xyyzsmpcore.manager;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class DataFileManager {
    private final File dataFolder;

    private final Map<String, FileConfiguration> configMap;

    public DataFileManager(File dataFolder) {
        this.dataFolder = dataFolder;
        configMap = new HashMap<>();
    }

    public File getDataFolder() {
        return dataFolder;
    }

    public File getFile(String name) {
        return new File(dataFolder, name);
    }

    public FileConfiguration getConfig(String name) {
        String fileName = name;
        if (!name.endsWith(".yml")) fileName = name + ".yml";
        if (configMap.containsKey(fileName)) return configMap.get(fileName);
        FileConfiguration config = YamlConfiguration.loadConfiguration(getFile(fileName));
        configMap.put(fileName, config);
        return config;
    }

    public void saveConfig(String name) throws IOException {
        getConfig(name).save(getFile(name));
    }

    public void reloadConfig(String name) throws IOException, InvalidConfigurationException {
        getConfig(name).load(getFile(name));
    }
}
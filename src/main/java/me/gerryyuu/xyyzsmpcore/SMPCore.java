package me.gerryyuu.xyyzsmpcore;

import me.gerryyuu.xyyzsmpcore.command.CoreCommand;
import me.gerryyuu.xyyzsmpcore.command.RuleCommand;
import me.gerryyuu.xyyzsmpcore.listener.EntityListener;
import me.gerryyuu.xyyzsmpcore.listener.PlayerListener;
import me.gerryyuu.xyyzsmpcore.listener.ServerListener;
import me.gerryyuu.xyyzsmpcore.manager.DataFileManager;
import me.gerryyuu.xyyzsmpcore.manager.PlayerDataManager;
import me.gerryyuu.xyyzsmpcore.manager.PluginDataManager;
import me.gerryyuu.xyyzsmpcore.util.FileUtil;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class SMPCore extends JavaPlugin {
    private static Plugin plugin;
    private static File playerDataFolder;
    private static DataFileManager playerDataManager;

    private static File pluginDataFolder;

    private static DataFileManager pluginDataManager;

    private static List<String> motdLists;

    private static List<String> messageOnJoinLists;

    private static List<String> ruleLists;

    public static Plugin getPlugin() {
        return plugin;
    }

    public static File getPlayerDataFolder() {
        return playerDataFolder;
    }

    public static DataFileManager getPlayerDataManager() {
        return playerDataManager;
    }

    public static File getPluginDataFolder() {
        return pluginDataFolder;
    }

    public static DataFileManager getPluginDataManager() {
        return pluginDataManager;
    }

    public static List<String> getMotdLists() {
        return motdLists;
    }

    public static List<String> getMessageOnJoinLists() {
        return messageOnJoinLists;
    }

    public static List<String> getRuleLists() {
        return ruleLists;
    }

    public static void initPluginFiles() {
        SMPCore.getPlugin().saveDefaultConfig();
        playerDataFolder = new File(SMPCore.getPlugin().getDataFolder().getAbsolutePath() + File.separator + "playerData" + File.separator);
        pluginDataFolder = SMPCore.getPlugin().getDataFolder();
        if (!pluginDataFolder.exists()) pluginDataFolder.mkdirs();
        if (!playerDataFolder.exists()) playerDataFolder.mkdirs();
        playerDataManager = new PlayerDataManager(playerDataFolder);
        pluginDataManager = new PluginDataManager();
        if (!getPluginDataManager().getFile("config.yml").exists()) SMPCore.getPlugin().saveDefaultConfig();
        if (!getPluginDataManager().getFile("messageOnJoin.txt").exists())
            SMPCore.getPlugin().saveResource("messageOnJoin.txt", false);
        if (!getPluginDataManager().getFile("motd.txt").exists()) SMPCore.getPlugin().saveResource("motd.txt", false);
        if (!getPluginDataManager().getFile("rule.txt").exists()) SMPCore.getPlugin().saveResource("rule.txt", false);
        try {
            motdLists = FileUtil.readLinesFromTxtFile(pluginDataManager.getFile("motd.txt"));
            messageOnJoinLists = FileUtil.readLinesFromTxtFile(pluginDataManager.getFile("messageOnJoin.txt"));
            ruleLists = FileUtil.readLinesFromTxtFile(pluginDataManager.getFile("rule.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        plugin = this;
        initPluginFiles();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new ServerListener(), this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getServer().getPluginCommand("smpcore").setExecutor(new CoreCommand());
        getServer().getPluginCommand("smpcore").setTabCompleter(new CoreCommand());
        getServer().getPluginCommand("rule").setExecutor(new RuleCommand());
    }
}

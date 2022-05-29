package me.gerryyuu.xyyzsmpcore.command;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import me.gerryyuu.xyyzsmpcore.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public final class CoreCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equals("smpcore") && args.length >= 1 && args[0].equalsIgnoreCase("reload")) {
            SMPCore.initPluginFiles();
            sender.sendMessage("重新加载成功。");
            return true;
        }
        sender.sendMessage(ColorUtil.parseColor("&c命令有误。"));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1) {
            tab.add("reload");
        }
        return tab;
    }
}

package me.gerryyuu.xyyzsmpcore.command;

import me.gerryyuu.xyyzsmpcore.SMPCore;
import me.gerryyuu.xyyzsmpcore.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class RuleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (String s : SMPCore.getRuleLists()) {
            sender.sendMessage(ColorUtil.parseColor(s));
        }
        return true;
    }
}

package me.robnoo02.prefixtitle;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;

public enum ChatMessage {

	HELP("§8§m-----------------------------------------------------", "§6PrefixTitle Help", "§8~~~~~~~~~~~",
			"§c/prefixtitle open§8: §eOpen Title-menu.", "§c/prefixtitle set <title>§8: §eSet a title.",
			"§c/prefixtitle (set) none§8: §eRemove your title.",
			"§c/prefixtitle info§8: §eList info about this plugin.", "§c/prefixtitle help§8: §eOpen this help menu.",
			"§c/prefixtitle reload§8: §eReload config.",
			"§8§m-----------------------------------------------------"),
	INFO("§8§m-----------------------------------------------------", "§6PrefixTitle Info", "§8~~~~~~~~~~~",
			"§cDeveloper§8: §eRobnoo02", "§cVersion§8: §e" + Main.getInstance().getDescription().getVersion(),
			"§cDescription§8: §e" + Main.getInstance().getDescription().getDescription(),
			"§8§m-----------------------------------------------------"),
	SPECIFY_TITLE("§cPlease enter a title! /prefixtitle set <title>"), TITLE_NOT_EXIST("§cThis title doesn't exist!"),
	TITLE_REMOVED("§aYour title has been removed!"), SET_TITLE("§aYour title has been set to: §f%var%"),
	CANT_EQUIP("§cYou can't equip this title!"),
	NO_PERM("§cYou don't have enough permissions to do this!"),
	NOT_ADDED_YET("§cOops! This plugin is still in development. You'll be able to use this command once it's finished."),
	CONFIG_RELOADED("§aThe config file has been reloaded!");

	private List<String> lines;

	private ChatMessage(String... lines) {
		this.lines = Arrays.asList(lines);
	}

	public boolean send(Player p) {
		for (String line : lines)
			p.sendMessage(line);
		return true;
	}

	public boolean send(Player p, String var) {
		for (String line : lines)
			p.sendMessage(line.replaceAll("%var%", var));
		return true;
	}

}

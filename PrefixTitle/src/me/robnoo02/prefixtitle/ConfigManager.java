package me.robnoo02.prefixtitle;

import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * This class gets and sets data in the config.yml file.
 * Static methods are used to prevent unnecessary instantiation.
 * 
 * @author Robnoo02
 *
 */
public class ConfigManager {
	
	private static final String PLACEHOLDER_PATH = "player-placeholder";
	private static final String TITLE_PREFIX = "title-prefix";
	private static final String PLAYER_DATA = "player-data";
	
	public static String getPlaceHolder() {
		FileConfiguration config = Main.getInstance().getConfig();
		if(!config.contains(PLACEHOLDER_PATH))
			return "";
		return config.getString(PLACEHOLDER_PATH);
	}
	
	public static String getPrefix(String titleName) {
		FileConfiguration config = Main.getInstance().getConfig();
		if(!config.getConfigurationSection(TITLE_PREFIX).getKeys(false).contains(titleName))
			return null;
		return config.getString(TITLE_PREFIX + "." + titleName);
	}
	
	public static String getPlayerTitle(Player p) {
		FileConfiguration config = Main.getInstance().getConfig();
		if(!config.getConfigurationSection(PLAYER_DATA).getKeys(false).contains(p.getUniqueId().toString()))
			return null;
		return config.getString(PLAYER_DATA + "." + p.getUniqueId().toString());
	}
	
	public static boolean isTitle(String title) {
		return Main.getInstance().getConfig().getConfigurationSection(TITLE_PREFIX).getKeys(false).contains(title);
	}
	
	public static void setTitle(Player p, String title) {
		Main.getInstance().getConfig().set(PLAYER_DATA + "." + p.getUniqueId().toString(), title);
		Main.getInstance().saveConfig();
	}
	
	public static void removeTitle(Player p) {
		setTitle(p, null);
	}
	
	public static Set<String> getPrefixes(){
		return Main.getInstance().getConfig().getConfigurationSection(TITLE_PREFIX).getKeys(false);
	}
}

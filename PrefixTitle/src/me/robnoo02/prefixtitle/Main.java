package me.robnoo02.prefixtitle;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
		getCommand("prefixtitle").setExecutor(new PrefixTitleCmd());
	}
	
	public static Main getInstance() {
		return JavaPlugin.getPlugin(Main.class);
	}
	
}

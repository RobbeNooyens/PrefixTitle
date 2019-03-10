package me.robnoo02.prefixtitle;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class TitleManager {

	private static final TitleManager INSTANCE = new TitleManager();
	
	private HashMap<String, Title> titles = new HashMap<>();
	
	private TitleManager() {
	}
	
	public static TitleManager getInstance() {
		return INSTANCE;
	}
	
	public Title getTitle(String titleName) {
		if(titles.containsKey(titleName))
			return titles.get(titleName);
		String prefix = ConfigManager.getPrefix(titleName);
		if(prefix == null)
			return null;
		Title title = Title.create(titleName, prefix);
		titles.put(titleName, title);
		return title;
	}
	
	public Title getTitle(Player p) {
		String titleName = ConfigManager.getPlayerTitle(p);
		if(titles.containsKey(titleName))
			return titles.get(titleName);
		String prefix = ConfigManager.getPrefix(titleName);
		if(prefix == null)
			return null;
		Title title = Title.create(titleName, prefix);
		titles.put(titleName, title);
		return title;
	}
	
	public boolean isTitle(String title) {
		return ConfigManager.isTitle(title);
	}
	
	public void setTitle(Player p, String title) {
		if(!isTitle(title))
			return;
		ConfigManager.setTitle(p, title);
		
	}
}

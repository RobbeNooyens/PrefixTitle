package me.robnoo02.prefixtitle;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

	/**
	 * Handles chat event.
	 * Adds a prefix before a playername.
	 */
	@EventHandler(priority = EventPriority.HIGH)
	public void onChat(AsyncPlayerChatEvent e) {
		String format = e.getFormat();
		String placeHolder = ConfigManager.getPlaceHolder();
		if(!format.contains(placeHolder))
			placeHolder = e.getPlayer().getDisplayName();
		if(!format.contains(placeHolder))
			placeHolder = e.getPlayer().getName();
		Title title = TitleManager.getInstance().getTitle(e.getPlayer());
		if(title == null)
			return;
		String prefix = title.getPrefix();
		if (placeHolder.length() == 0)
			return;
		String latestColor = ChatColor.getLastColors(e.getFormat().substring(0, e.getFormat().indexOf(placeHolder)));
		String part1 = format.substring(0, format.indexOf(placeHolder));
		String part2 = format.substring(format.indexOf(placeHolder), format.length());
		if(latestColor.equals(""))
			latestColor = "§r";
		e.setFormat(part1 + prefix + latestColor + part2);
	}

}

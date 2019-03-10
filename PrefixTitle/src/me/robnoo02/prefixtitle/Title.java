package me.robnoo02.prefixtitle;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;

public final class Title {

	private final String name, prefix; // Defines title name + prefix
	private Set<UUID> equipped = new HashSet<>(); // Lists all players who equipped this title
	
	/**
	 * Constructor
	 * Private for static factory method instance creation
	 * @param name The name of title, used as a key in the Config file.
	 * @param prefix The prefix that should be placed before the player name.
	 */
	private Title(String name, String prefix) {
		this.prefix = prefix;
		this.name = name;
	}
	
	/**
	 * Static factory method to obtain an instance
	 * @param name Title name
	 * @param prefix Title prefix
	 * @return instance of Title
	 */
	public static Title create(String name, String prefix) {
		return new Title(name, prefix);
	}
	
	/**
	 * Adds a player to equipped Set
	 * @param p Player who selected this title
	 */
	public void apply(OfflinePlayer p) {
		equipped.add(p.getUniqueId());
	}
	
	/**
	 * Removes player from equipped Set
	 * @param p Player to be removed
	 */
	public void remove(OfflinePlayer p) {
		equipped.remove(p.getUniqueId());
	}
	
	/**
	 * @return Title prefix
	 */
	public String getPrefix() {
		return ChatColor.translateAlternateColorCodes('&', prefix);
	}
	
	/**
	 * @return Title name
	 */
	public String getName() {
		return name;
	}
}

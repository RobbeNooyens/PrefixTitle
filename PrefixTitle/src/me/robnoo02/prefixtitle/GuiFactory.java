package me.robnoo02.prefixtitle;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.robnoo02.prefixtitle.GuiUtil.Gui;
import me.robnoo02.prefixtitle.GuiUtil.GuiItem;

/**
 * This class returns Gui instances.
 * Current infrastructure isn't the best one.
 * It'll be updated and improved soon.
 * 
 * @author Robnoo02
 *
 */
public class GuiFactory {

	/**
	 * @return PrefixGui containing glass panes which represents titles.
	 */
	public static Gui getPrefixGui(Player p) {
		Gui gui = new Gui.Builder(p).title("&8Choose your own prefix!").size(54).fillSlots(0, 45, 1, getItems(p))
				.build();

		return gui;
	}

	/**
	 * @return Glass panes you can click to set your prefixtitle.
	 */
	public static GuiItem[] getItems(Player p) {
		Set<String> titles = ConfigManager.getPrefixes();
		GuiItem[] items = new GuiItem[titles.size()];
		boolean even = false;
		int i = 0;
		for (String title : titles) {
			GuiItem item = new GuiItem.Builder().material(Material.STAINED_GLASS_PANE).data(even ? 10 : 2).hideFlags()
					.name("&d" + title).click(() -> Bukkit.dispatchCommand(p, "prefixtitle set " + title)).build();
			items[i++] = item;
			even = !even;
		}
		return items;
	}
	
	/**
	 * @return Barrier to close inventory.
	 */
	public static GuiItem getClose(Player p) {
		return new GuiItem.Builder().material(Material.BARRIER).name("&4Exit").click(() -> p.closeInventory()).hideFlags().build();
	}

}

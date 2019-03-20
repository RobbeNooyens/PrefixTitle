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

	private static GuiItem pinkPane = null;
	private static GuiItem grayPane = null;

	/**
	 * @return PrefixGui containing nether stars which represents titles.
	 */
	public static Gui getPrefixGui(Player p, int page) {
		Gui gui = new Gui.Builder(p).title("&8Choose a title").size(54).fillSlots(9, 44, page, getItems(p)).build();
		for (int i = 0; i < 9; i++)
			if (i % 2 == 0)
				gui.setItem(i, pinkPane);
			else
				gui.setItem(i, grayPane);
		for (int i = 45; i < 54; i++)
			if (i % 2 == 0)
				gui.setItem(i, grayPane);
			else
				gui.setItem(i, pinkPane);
		gui.setItem(49, getCloseItem(p));
		if(gui.getPage() < gui.getTotalPages())
			gui.setItem(53, getNext(p, gui));
		if(gui.getPage() > 1)
			gui.setItem(45, getPrevious(p, gui));
		return gui;
	}

	public static GuiItem getNext(Player p, Gui gui) {
		return new GuiItem.Builder().material(Material.NAME_TAG).name("&7Next Page").click(() -> getPrefixGui(p, gui.getPage() + 1).open()).hideFlags().build();
	}
	
	public static GuiItem getPrevious(Player p, Gui gui) {
		return new GuiItem.Builder().material(Material.NAME_TAG).name("&7Previous Page").click(() -> getPrefixGui(p, gui.getPage() - 1).open()).hideFlags().build();
	}
	
	public static void setDefaultItems() {
		if (pinkPane == null)
			pinkPane = new GuiItem.Builder().material(Material.STAINED_GLASS_PANE).data(10).hideFlags().name(" ").build();
		if (grayPane == null)
			grayPane = new GuiItem.Builder().material(Material.STAINED_GLASS_PANE).data(7).hideFlags().name(" ").build();
	}
	
	public static GuiItem getCloseItem(Player p) {
		return new GuiItem.Builder().material(Material.BARRIER).name("&cExit").click(() -> p.closeInventory())
		.hideFlags().build();
	}

	/**
	 * @return Glass panes you can click to set your prefixtitle.
	 */
	public static GuiItem[] getItems(Player p) {
		Set<String> titles = ConfigManager.getPrefixes();
		GuiItem[] items = new GuiItem[titles.size()];
		int i = 0;
		for (String title : titles) {
			GuiItem item = new GuiItem.Builder().material(Material.NETHER_STAR).hideFlags().name("&d" + title)
					.click(() -> Bukkit.dispatchCommand(p, "prefixtitle set " + title)).build();
			items[i++] = item;
		}
		return items;
	}

}

package net.runelite.client.plugins.avorkath;


import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;

public enum PrayerRestoreType
{
	PRAYER_POTION(ItemID.PRAYER_POTION1, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION4),
	SUPER_RESTORE(ItemID.SUPER_RESTORE1, ItemID.SUPER_RESTORE2, ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE4,
			ItemID.BLIGHTED_SUPER_RESTORE1, ItemID.BLIGHTED_SUPER_RESTORE2, ItemID.BLIGHTED_SUPER_RESTORE3,
			ItemID.BLIGHTED_SUPER_RESTORE4),
	RANGED(ItemID.BASTION_POTION1, ItemID.BASTION_POTION2, ItemID.BASTION_POTION3, ItemID.BASTION_POTION4,ItemID.RANGING_POTION1, ItemID.RANGING_POTION2, ItemID.RANGING_POTION3, ItemID.RANGING_POTION4),
	ANTIFIRE(ItemID.ANTIFIRE_POTION1, ItemID.ANTIFIRE_POTION2, ItemID.ANTIFIRE_POTION3, ItemID.ANTIFIRE_POTION4,ItemID.EXTENDED_SUPER_ANTIFIRE1,ItemID.EXTENDED_SUPER_ANTIFIRE2, ItemID.EXTENDED_SUPER_ANTIFIRE3, ItemID.EXTENDED_SUPER_ANTIFIRE4),
	ANTIVENOM(ItemID.ANTIDOTE1_5958, ItemID.ANTIDOTE2_5956, ItemID.ANTIDOTE3_5954, ItemID.ANTIDOTE4_5952, ItemID.ANTIVENOM1_12919 ,ItemID.ANTIVENOM2_12917,ItemID.ANTIVENOM3_12915, ItemID.ANTIVENOM4_12913),
	SANFEW_SERUM(ItemID.SANFEW_SERUM1, ItemID.SANFEW_SERUM2, ItemID.SANFEW_SERUM3, ItemID.SANFEW_SERUM4),
	COMBAT(ItemID.SUPER_COMBAT_POTION1, ItemID.SUPER_COMBAT_POTION2, ItemID.SUPER_COMBAT_POTION3, ItemID.SUPER_COMBAT_POTION4, ItemID.COMBAT_POTION1, ItemID.COMBAT_POTION2, ItemID.COMBAT_POTION3, ItemID.COMBAT_POTION4);

	public int[] ItemIDs;

	PrayerRestoreType(int... ids)
	{
		this.ItemIDs = ids;
	}

	public boolean containsId(int id)
	{
		return Arrays.stream(this.ItemIDs).anyMatch(x -> x == id);
	}

	public WidgetItem getItemFromInventory(Client client)
	{
		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		if (inventoryWidget == null)
		{
			return null;
		}

		for (WidgetItem item : inventoryWidget.getWidgetItems())
		{
			if (Arrays.stream(ItemIDs).anyMatch(i -> i == item.getId()))
			{
				return item;
			}
		}

		return null;
	}
}

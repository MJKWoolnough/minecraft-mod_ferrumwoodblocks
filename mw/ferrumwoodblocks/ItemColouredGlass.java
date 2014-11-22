package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemCloth;
import net.minecraft.util.Icon;

public class ItemColouredGlass extends ItemCloth {

	public ItemColouredGlass(int itemId) {
		super(itemId);
	}

	public Icon getIconFromDamage(int damage) {
		return Block.blocksList[this.getBlockID()].getIcon(2, damage);
	}
}

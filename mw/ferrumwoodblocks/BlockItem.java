package mw.ferrumwoodblocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockItem extends ItemBlock {

	public BlockItem(int itemId) {
		super(itemId);
		this.setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata) {
	      return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return super.getUnlocalizedName() + "_" + String.format("%X", itemstack.getItemDamage());
	}

}

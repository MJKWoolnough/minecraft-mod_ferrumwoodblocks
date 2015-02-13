package mw.ferrumwoodblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;


public class LightBlock extends InvisibleBlock {
	public LightBlock(int blockId) {
		super(blockId);
		this.setUnlocalizedName("lightBlock")
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setLightValue(1)
		.setLightOpacity(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		list.add(new ItemStack(blockId, 1, 0));
	}
}

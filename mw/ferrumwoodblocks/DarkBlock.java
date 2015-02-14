package mw.ferrumwoodblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class DarkBlock extends InvisibleBlock {
	public DarkBlock(int blockId) {
		super(blockId);
		this.setUnlocalizedName("darkBlock")
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setLightValue(0)
		.setLightOpacity(15);
	}

	public int getLightOpacity(World world, int x, int y, int z) {
		return 15 - world.getBlockMetadata(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		for (int i = 0; i < 15; i++) {
			list.add(new ItemStack(blockId, 1, i));
		}
	}
}

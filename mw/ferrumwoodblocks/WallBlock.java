package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WallBlock extends BlockWall {

	private Icon[]	icons	= new Icon[16];

	public WallBlock(int blockId) {
		super(blockId, Block.cobblestone);
		this.setUnlocalizedName("wall");
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (int i = 0; i < 16; i++) {
			this.icons[i] = iconRegister.registerIcon(FenceBlock.textures[i]);
		}
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return this.icons[metadata];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		for (int i = 0; i < 16; i++) {
			list.add(new ItemStack(blockId, 1, i));
		}
	}

}

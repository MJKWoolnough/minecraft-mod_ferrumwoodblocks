package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class StainedGlass extends BlockGlass {

	private Icon[]	icons;

	public StainedGlass(int blockId) {
		super(blockId, Material.glass, false);
		this.setHardness(0.3F).setStepSound(soundGlassFootstep).setUnlocalizedName("stained_glass").setTextureName(ModFerrumwoodBlocks.getModId() + ":glass_");
		// ItemDye.dyeItemNames[~metadata & 15];
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public int getRenderType() {
		return StainedGlassRenderer.renderId;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return world.getBlockId(x, y, z) != this.blockID;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.icons = new Icon[16];
		for (int i = 0; i < 16; i++) {
			this.icons[i] = iconRegister.registerIcon(this.getTextureName() + ItemDye.dyeItemNames[~i & 15]);
		}
	}

	@Override
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		for (int i = 0; i < 16; i++) {
			list.add(new ItemStack(blockId, 1, i));
		}
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return this.icons[metadata];
	}

}

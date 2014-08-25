package mw.ferrumwoodblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class FenceBlock extends BlockFence implements MultiTextureRender.TextureRenderer {
	
	private Icon[] icons = new Icon[16];
	private int metadataOverride = -1;
	public final static String[] textures = new String[]{ "planks_oak", "planks_spruce", "planks_birch", "planks_jungle", "log_oak", "log_spruce", "log_birch", "log_jungle", "stone", "cobblestone", "sandstone_normal", "iron_block", "brick", "obsidian", "stonebrick", "coal_block" };

	public FenceBlock(int blockId) {
		super(blockId, "", Material.wood);
		this.setUnlocalizedName("fence")
		.setHardness(2.0F)
		.setResistance(5.0F)
		.setStepSound(soundWoodFootstep);
	}
	
	@Override
    public int getRenderType() {
		if (this.metadataOverride == -1) {
			return MultiTextureRender.renderId;
		}
		return super.getRenderType();
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (int i = 0; i < 16; i++) {
			this.icons[i] = iconRegister.registerIcon(this.textures[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
		if (this.metadataOverride == -1) {
			return this.icons[metadata];
		}
		return this.icons[this.metadataOverride];
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
        for (int i = 0; i < 16; i++) {
            list.add(new ItemStack(blockId, 1, i));
        }
    }
	
	public void override(int metadata) {
		this.metadataOverride = metadata;
	}
	
	public void override(IBlockAccess world, int x, int y, int z) {
		this.metadataOverride = world.getBlockMetadata(x, y, z);
	}

}

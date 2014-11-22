package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RoadSlab extends Block {
	
	protected final int blockShift;
	private Icon[] icons;
	private Icon sideIcon;
	
	public RoadSlab(int blockId, boolean first) {
		super(blockId, Material.rock);
		if (first) {
			this.blockShift = 0;
		} else {
			this.blockShift = 16;
		}
		this.setLightOpacity(0)
		.setResistance(10)
		.setHardness(1.5F)
		.setStepSound(Block.soundStoneFootstep)
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":roadslab")
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		if (first) {
			this.setUnlocalizedName("roadSlab1");
		} else {
			this.setUnlocalizedName("roadSlab2");
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return side == 1 || super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
        if (side == 1) {
        	return this.icons[metadata];
        }
        return this.sideIcon;
    }
	
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.sideIcon = par1IconRegister.registerIcon(this.getTextureName());
        this.icons = new Icon[16];
        for (int i = 0; i < 16; ++i) {
            this.icons[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + String.format("%02X", i + this.blockShift));
        }
    }
	
	@Override
	public int damageDropped(int metadata) {
        return metadata;
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
        for (int i = 0; i < 16; i++) {
            list.add(new ItemStack(blockId, 1, i));
        }
    }
}

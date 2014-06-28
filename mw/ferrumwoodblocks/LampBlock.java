package mw.ferrumwoodblocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class LampBlock extends Block {

	private final boolean powered;
	protected static int unpoweredId;
	protected static int poweredId;
	
	private Icon[] icons;
	
	public LampBlock(int blockId, boolean powered) {
		super(blockId, Material.redstoneLight);
		this.setStepSound(Block.soundGlassFootstep)
		.setHardness(0.3F);
		if (powered) {
			this.setUnlocalizedName("lampBlockOn")
			.setLightValue(1.0F)
			.setTextureName("lampBlockOn");
		} else {
			this.setUnlocalizedName("lampBlockOff")
			.setCreativeTab(CreativeTabs.tabRedstone)
			.setTextureName("lampBlockOff");
		}
		this.powered = powered;
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		if (!world.isRemote) {
            if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            } else if (!this.powered && world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.setBlock(x, y, z, this.poweredId, world.getBlockMetadata(x, y, z), 2);
            }
        }
    }
	
    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
    	this.onBlockAdded(world, x, y, z);
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote && this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
        	world.setBlock(x, y, z, this.unpoweredId, world.getBlockMetadata(x, y, z), 2);
        }
    }
    
    @Override
	public Icon getIcon(int side, int metadata) {
        return this.icons[metadata];
    }
	
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
        this.icons = new Icon[16];
        for (int i = 0; i < 16; ++i) {
            this.icons[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + String.format("%X", i));
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

package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RoadSlope extends Block {
	
	protected Icon icon;
	protected Icon icon_wl;
	protected Icon icon_wr;
	protected Icon icon_wt;
	protected Icon icon_wb;
	
	public RoadSlope(int blockId) {
		super(blockId, Material.rock);
		this.setLightOpacity(0)
		.setResistance(10)
		.setHardness(1.5F)
		.setStepSound(Block.soundStoneFootstep)
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":roadslab")
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setUnlocalizedName("roadSlope")
		.setBlockBounds(0f, 0f, 0f, 1f, 0.25f, 1f);
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
    public int getRenderType() {
        return SlopeRender.renderId;
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.icon = iconRegister.registerIcon(this.getTextureName());
		this.icon_wl = iconRegister.registerIcon(this.getTextureName() + "_14");
		this.icon_wr = iconRegister.registerIcon(this.getTextureName() + "_15");
		this.icon_wt = iconRegister.registerIcon(this.getTextureName() + "_16");
		this.icon_wb = iconRegister.registerIcon(this.getTextureName() + "_17");
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
        return this.icon;
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0, 0, 0, 1, (float)((world.getBlockMetadata(x, y, z) & 3) + 1) / 4, 1);
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		/*this.setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);*/
		int metadata = world.getBlockMetadata(x, y, z);
		double height = metadata & 3;
		int direction = (metadata >> 2) & 3;
		
		this.maxY = height / 4;
		
		switch (direction) {
		case 0:
			this.maxZ = 0.5;
			break;
		case 1:
			this.maxX = 0.5;
			break;
		case 2:
			this.minZ = 0.5;
			break;
		case 3:
			this.minX = 0.5;
			break;
		}
		
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
		
		this.maxY = (height + 1) / 4;
		
		switch (direction) {
		case 0:
			this.minZ = 0.5;
			this.maxZ = 1;
			break;
		case 1:
			this.minX = 0.5;
			this.maxX = 1;
			break;
		case 2:
			this.minZ = 0;
			this.maxZ = 0.5;
			break;
		case 3:
			this.minX = 0;
			this.maxX = 0.5;
			break;
		}
		
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
		
		switch (direction) {
		case 0:
			this.minZ = 0;
			break;
		case 1:
			this.minX = 0;
			break;
		case 2:
			this.maxZ = 1;
			break;
		case 3:
			this.maxX = 1;
			break;
		}
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	public Icon topIcon(IBlockAccess world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		switch (metadata >> 2) {
		case 0:
		case 2:
			if (world.getBlockId(x - 1, y, z) != this.blockID || world.getBlockMetadata(x - 1, y, z) != metadata) {
				return this.icon_wr;
			} else if (world.getBlockId(x + 1, y, z) != this.blockID || world.getBlockMetadata(x + 1, y, z) != metadata) {
				return this.icon_wl;
			}
			break;
		case 1:
		case 3:
			if (world.getBlockId(x, y, z - 1) != this.blockID || world.getBlockMetadata(x, y, z - 1) != metadata) {
				return this.icon_wb;
			} else if (world.getBlockId(x, y, z + 1) != this.blockID || world.getBlockMetadata(x, y, z + 1) != metadata) {
				return this.icon_wt;
			}
			break;
		}
		return this.icon;
	}

}

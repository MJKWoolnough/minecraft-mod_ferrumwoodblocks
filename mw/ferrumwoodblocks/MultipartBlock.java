package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultipartBlock extends Block implements IMultipart {

	private final BlockPart[][]	bps;
	private Icon			icon;
	private boolean			overrideState;
	private int			stateOverride;

	public MultipartBlock(int blockId, BlockPart[][] bp) {
		super(blockId, Material.iron);
		this.setLightOpacity(0).setResistance(10).setHardness(1.5F);
		this.bps = bp;
		this.resetBox();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return MultipartRender.renderId;
	}

	@Override
	public boolean RenderMore(int metadata, int state) {
		if (state < this.bps[metadata].length) {
			this.setBlockBoundsBasedOnState(metadata, state);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (BlockPart[] bs : this.bps) {
			for (BlockPart b : bs) {
				b.icon = iconRegister.registerIcon(b.iconStr);
			}
		}
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return this.icon;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		if (this.overrideState) {
			int metadata = world.getBlockMetadata(x, y, z);
			this.setBlockBoundsBasedOnState(metadata, this.stateOverride);
		} else {
			this.resetBox();
		}
	}

	public void setBlockBoundsBasedOnState(int metadata, int state) {
		this.minX = this.bps[metadata][state].minX;
		this.minY = this.bps[metadata][state].minY;
		this.minZ = this.bps[metadata][state].minZ;
		this.maxX = this.bps[metadata][state].maxX;
		this.maxY = this.bps[metadata][state].maxY;
		this.maxZ = this.bps[metadata][state].maxZ;
		this.icon = this.bps[metadata][state].icon;
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		int metadata = world.getBlockMetadata(x, y, z);
		for (int i = 0; i < this.bps[metadata].length; i++) {
			this.setBlockBoundsBasedOnState(metadata, i);
			super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
		}
	}

	public void resetBox() {
		this.minX = 0;
		this.minY = 0;
		this.minZ = 0;
		this.maxX = 1;
		this.maxY = 1;
		this.maxZ = 1;
	}

	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec) {
		int metadata = world.getBlockMetadata(x, y, z);
		MovingObjectPosition toRet = null;
		double distance = Double.MAX_VALUE;
		for (int state = 0; state < this.bps[metadata].length; state++) {
			this.overrideState = true;
			this.stateOverride = state;
			MovingObjectPosition t = super.collisionRayTrace(world, x, y, z, startVec, endVec);
			if (t != null) {
				if (toRet == null) {
					double tDistance = t.hitVec.distanceTo(startVec);
					if (tDistance < distance) {
						toRet = t;
						distance = tDistance;
					}
				} else {
					toRet = t;
					distance = t.hitVec.distanceTo(startVec);
				}
			}
		}
		this.overrideState = false;
		this.resetBox();
		return toRet;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		this.minX = 1;
		this.minY = 1;
		this.minZ = 1;
		this.maxX = 0;
		this.maxY = 0;
		this.maxZ = 0;
		for (BlockPart b : this.bps[metadata]) {
			if (b.minX < this.minX) {
				this.minX = b.minX;
			}
			if (b.minY < this.minY) {
				this.minY = b.minY;
			}
			if (b.minZ < this.minZ) {
				this.minZ = b.minZ;
			}
			if (b.maxX > this.maxX) {
				this.maxX = b.maxX;
			}
			if (b.maxY > this.maxY) {
				this.maxY = b.maxY;
			}
			if (b.maxZ > this.maxZ) {
				this.maxZ = b.maxZ;
			}
		}
		AxisAlignedBB aabb = super.getSelectedBoundingBoxFromPool(world, x, y, z);
		this.resetBox();
		return aabb;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		for (int i = 0; i < this.bps.length; i++) {
			list.add(new ItemStack(blockId, 1, i));
		}
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
}

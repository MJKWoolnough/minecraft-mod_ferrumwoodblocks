package mw.ferrumwoodblocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DoorBlock extends BlockDoor implements ITileEntityProvider {

	protected static int	masks;
	protected static int	textures;

	private Icon[][]	topIcons;
	private Icon[][]	bottomIcons;

	private Icon		clear;

	private int		lastDamage	= 0;

	protected DoorBlock(int blockId) {
		super(blockId, Material.wood);
		this.setHardness(3.0F).setUnlocalizedName("door").setTextureName(ModFerrumwoodBlocks.getModId() + ":door").setCreativeTab(CreativeTabs.tabDecorations);
	}

	protected static int[] convertMetadata(int metadata) {
		int mask = metadata >> 8;
		int texture = metadata & 255;
		if (mask < 0 || mask >= masks) {
			mask = 0;
		}
		if (texture < 0 || texture >= textures) {
			texture = 0;
		}
		return new int[] { mask, texture };
	}

	private void setIcons(int metadata) {
		int[] md = convertMetadata(metadata);
		this.field_111044_a[0] = this.topIcons[md[0]][md[1]];
		this.field_111043_b[0] = this.bottomIcons[md[0]][md[1]];
		this.field_111044_a[1] = new IconFlipped(this.field_111044_a[0], true, false);
		this.field_111043_b[1] = new IconFlipped(this.field_111043_b[0], true, false);
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		this.setIcons(metadata);
		return super.getIcon(side, metadata);
	}

	private DoorTileEntity getDoorTileEntity(IBlockAccess blockAccess, int x, int y, int z) {
		if ((blockAccess.getBlockMetadata(x, y, z) & 8) == 0) {
			return (DoorTileEntity) blockAccess.getBlockTileEntity(x, y, z);
		}
		return (DoorTileEntity) blockAccess.getBlockTileEntity(x, y - 1, z);
	}

	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if ((blockAccess.getBlockMetadata(x, y, z) & 8) == 0) {
			if (side == 1) {
				return this.clear;
			}
		} else if (side == 0) {
			return this.clear;
		}
		this.setIcons(this.getDoorTileEntity(blockAccess, x, y, z).metadata);
		return super.getBlockTexture(blockAccess, x, y, z, side);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.field_111044_a = new Icon[2];
		this.field_111043_b = new Icon[2];
		this.topIcons = new Icon[this.masks][this.textures];
		this.bottomIcons = new Icon[this.masks][this.textures];
		for (int mask = 0; mask < this.masks; mask++) {
			for (int texture = 0; texture < this.textures; texture++) {
				this.topIcons[mask][texture] = iconRegister.registerIcon(String.format("%s_%02X_%02X_top", this.getTextureName(), mask, texture));
				this.bottomIcons[mask][texture] = iconRegister.registerIcon(String.format("%s_%02X_%02X_bottom", this.getTextureName(), mask, texture));
			}
		}
		this.clear = iconRegister.registerIcon(ModFerrumwoodBlocks.getModId() + ":clear");
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return (metadata & 8) == 0;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new DoorTileEntity();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
		for (int i = 0; i < this.masks; i++) {
			for (int j = 0; j < this.textures; j++) {
				list.add(new ItemStack(blockId, 1, (i << 8) | j));
			}
		}
	}

	@Override
	public int idPicked(World world, int x, int y, int z) {
		return this.blockID;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		DoorTileEntity dte = this.getDoorTileEntity(world, x, y, z);
		if (dte != null) {
			return dte.metadata;
		}
		return this.lastDamage;
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> toRet = new ArrayList<ItemStack>();
		if ((metadata & 8) == 0) {
			toRet.add(new ItemStack(this.blockID, 1, this.getDamageValue(world, x, y, z)));
		}
		return toRet;
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int metadata, EntityPlayer player) {
		this.lastDamage = this.getDamageValue(world, x, y, z);
		super.onBlockHarvested(world, x, y, z, metadata, player);
	}
}

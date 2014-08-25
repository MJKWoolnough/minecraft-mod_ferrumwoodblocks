package mw.ferrumwoodblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DoorBlock extends BlockDoor implements ITileEntityProvider {

	protected static int masks;
	protected static int textures;
	
	private Icon[][] topIcons;
	private Icon[][] bottomIcons;
	
	private Icon clear;
	
	protected DoorBlock(int blockId) {
		super(blockId, Material.wood);
		this.setHardness(3.0F)
		.setUnlocalizedName("door")
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":door")
		.setCreativeTab(CreativeTabs.tabDecorations);
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
		return super.getIcon(side,  metadata);
	}
	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
		DoorTileEntity dte;
		if ((blockAccess.getBlockMetadata(x, y, z) & 8) == 0) {
			if (side == 1) {
				return this.clear;
			}
			dte = (DoorTileEntity) blockAccess.getBlockTileEntity(x, y, z);
		} else {
			if (side == 0) {
				return this.clear;
			}
			dte = (DoorTileEntity) blockAccess.getBlockTileEntity(x, y-1, z);
		}
		this.setIcons(dte.metadata);
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
}

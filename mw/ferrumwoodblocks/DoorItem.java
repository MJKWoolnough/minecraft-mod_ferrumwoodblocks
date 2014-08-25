package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DoorItem extends ItemBlock {
	
	private Icon[][] icons;
	
	public DoorItem(int itemId) {
		super(itemId);
		this.setHasSubtypes(true)
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":door");
	}
	
	@Override
	public int getMetadata(int metadata) {
	      return metadata;
	}
	
	@Override
	public int getSpriteNumber() {
		return 1;
	}
	
	@Override
	public Icon getIconFromDamage(int metadata) {
		int[] md = DoorBlock.convertMetadata(metadata);
		return this.icons[md[0]][md[1]];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.icons = new Icon[DoorBlock.masks][DoorBlock.textures];
		for (int mask = 0; mask < DoorBlock.masks; mask++) {
			for (int texture = 0; texture < DoorBlock.textures; texture++) {
				this.icons[mask][texture] = iconRegister.registerIcon(String.format("%s_%02X_%02X", this.getIconString(), mask, texture));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		int[] md = DoorBlock.convertMetadata(itemStack.getItemDamage());
		return super.getUnlocalizedName() + "_" + String.format("%02X_%02X", md[0], md[1]);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		y++;
		Block door = Block.blocksList[this.getBlockID()];
		if (side == 1 && player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y+1, z, side, itemStack) && door.canPlaceBlockAt(world, x, y, z)) {
			int facing = MathHelper.floor_float(1.5F + player.rotationYaw / 90F) & 3;
			ItemDoor.placeDoorBlock(world, x, y, z, facing, door);
			TileEntity te = world.getBlockTileEntity(x, y, z);
			((DoorTileEntity) te).metadata = itemStack.getItemDamage();
			world.setBlockTileEntity(x, y, z, te);
			itemStack.stackSize--;
			return true;
		}
		return false;
		
	}
}

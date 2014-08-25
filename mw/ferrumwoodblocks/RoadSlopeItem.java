package mw.ferrumwoodblocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RoadSlopeItem extends ItemBlock {

	public RoadSlopeItem(int itemId) {
		super(itemId);
	}
	
	@Override
	public int getMetadata(int itemDamage) {
		return ((itemDamage ^ 1) & 3) << 2;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.getBlockId(x, y, z) == this.blockID && !player.isSneaking()) {
			int md = world.getBlockMetadata(x, y, z);
			world.setBlockMetadataWithNotify(x, y, z, ((md + 1) & 3) | (md & 12), 2);
			stack.stackSize--;
			return true;
		}
		stack.setItemDamage(MathHelper.floor_float(1.5F + player.rotationYaw / 90F) & 3);
		boolean toRet = super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
		stack.setItemDamage(0);
		return toRet;
	}
}

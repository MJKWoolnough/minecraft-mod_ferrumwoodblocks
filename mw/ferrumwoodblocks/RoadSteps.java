package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RoadSteps extends BlockStairs {

	private Icon topIcon;
	private Icon bottomIcon;
	private boolean renderTopIcon = false;
	
	public RoadSteps(int blockId) {
		super(blockId, Block.stone, 0);
		this.setLightOpacity(0)
		.setResistance(10)
		.setHardness(1.5F)
		.setStepSound(Block.soundStoneFootstep)
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":roadslab")
		.setUnlocalizedName("roadStep");
	}
	
	@Override
	public Icon getIcon(int side, int metadata) {
        if (this.renderTopIcon) {
        	return this.topIcon;
        }
        return this.bottomIcon;
    }
	
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
        this.topIcon = par1IconRegister.registerIcon("stone");
        this.bottomIcon = par1IconRegister.registerIcon(this.getTextureName());
    }
	
	@Override
	public void func_82541_d(IBlockAccess blockAccess, int x, int y, int z) {
		this.renderTopIcon = false;
		super.func_82541_d(blockAccess, x, y, z);
	}
	
	@Override
	public boolean func_82542_g(IBlockAccess blockAccess, int x, int y, int z) {
		this.renderTopIcon = true;
		return super.func_82542_g(blockAccess, x, y, z);
	}
}

package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class StainedGlassPaneRenderer implements ISimpleBlockRenderingHandler {

	protected static int	renderId;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks rb) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks rb) {
		GL11.glDisable(GL11.GL_CULL_FACE);
		rb.renderBlockPane((BlockPane) block, x, y, z);
		GL11.glEnable(GL11.GL_CULL_FACE);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return this.renderId;
	}

}

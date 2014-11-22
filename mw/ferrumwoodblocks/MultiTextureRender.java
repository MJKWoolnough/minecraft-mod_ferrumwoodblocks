package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class MultiTextureRender implements ISimpleBlockRenderingHandler {

	public interface TextureRenderer {

		public void override(int metadata);

		public void override(IBlockAccess world, int x, int y, int z);
	}

	static int	renderId;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks rb) {
		TextureRenderer tr = (TextureRenderer) block;
		tr.override(metadata);
		rb.renderBlockAsItem(block, metadata, 1);
		tr.override(-1);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks rb) {
		TextureRenderer tr = (TextureRenderer) block;
		tr.override(world, x, y, z);
		boolean a = rb.renderBlockByRenderType(block, x, y, z);
		tr.override(-1);
		return a;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return this.renderId;
	}

}

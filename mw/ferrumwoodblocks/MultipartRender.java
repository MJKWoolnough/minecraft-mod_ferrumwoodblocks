package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class MultipartRender implements ISimpleBlockRenderingHandler {
	
	static int renderId;
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks rb) {
		IMultipart imp = (IMultipart) block;
		if (imp == null) {
			return;
		}
		Tessellator tessellator = Tessellator.instance;
		for (int state = 0; imp.RenderMore(metadata, state); state++) {
			rb.setRenderBoundsFromBlock(block);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);
            rb.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            rb.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            rb.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 2));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            rb.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 3));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            rb.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            rb.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, rb.getBlockIconFromSide(block, 5));
            tessellator.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}
		imp.resetBox();
		return;
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks rb) {
		IMultipart imp = (IMultipart) block;
		if (imp == null) {
			return false;
		}
		int metadata = world.getBlockMetadata(x, y, z);
		for (int state = 0; imp.RenderMore(metadata, state); state++) {
			rb.setRenderBoundsFromBlock(block);
			rb.renderStandardBlock(block, x, y, z);
		}
		imp.resetBox();
		return true;
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
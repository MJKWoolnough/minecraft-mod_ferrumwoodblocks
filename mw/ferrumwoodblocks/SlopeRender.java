package mw.ferrumwoodblocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class SlopeRender implements ISimpleBlockRenderingHandler {

	private class coords {
		private double x;
		private double y;
		private double z;
		
		private double texX;
		private double texY;
		
		private coords(double x, double y, double z, double texX, double texY) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.texX = texX;
			this.texY = texY;
		}
		
		private void addVertex() {
			Tessellator.instance.addVertexWithUV(this.x, this.y, this.z, this.texX, this.texY);
		}
	}
	
	protected static int renderId;
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks rb) {
		RoadSlope rBlock = (RoadSlope) block;
		GL11.glTranslatef(-0.5F, 0, -0.5F);
		Tessellator.instance.startDrawingQuads();
		this.render(rBlock, 0, 0, 0, 8, rBlock.icon, rBlock.icon);
		Tessellator.instance.draw();
		GL11.glTranslatef(0.5F, 0, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks rb) {
		Tessellator.instance.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		Tessellator.instance.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		RoadSlope rBlock = (RoadSlope) block;
		Icon topIcon = rBlock.topIcon(world, x, y, z);
		if (topIcon == null) {
			topIcon = rBlock.icon;
		}
		return this.render(rBlock, x, y, z, world.getBlockMetadata(x, y, z), rBlock.icon, topIcon);
	}
	
	private boolean render(RoadSlope rBlock, int x, int y, int z, int metadata, Icon sideIcon, Icon topIcon) {
		double iconMinX = sideIcon.getMinU();
		double iconMaxX = sideIcon.getMaxU();
		double iconMinY = sideIcon.getMinV();
		double iconMaxY = sideIcon.getMaxV();
		
		double topIconMinX = topIcon.getMinU();
		double topIconMaxX = topIcon.getMaxU();
		double topIconMinY = topIcon.getMinV();
		double topIconMaxY = topIcon.getMaxV();
		
		double height = (double)(metadata & 3);
		int direction = (metadata >> 2) & 3; //&3 in case of weirdness - shouldn't happen, but...eh?
		
		double iconLowHeight  = iconMinY + (height * (iconMaxY - iconMinY)) / 4;
		double iconHighHeight = iconMinY + (height + 1) * (iconMaxY - iconMinY) / 4;
		
		double coordLowHeight  = y + height / 4;
		double coordHighHeight = y + (height + 1) / 4;
		
		coords[][] squares = new coords[][] {
			{ //front
				new coords(x + 1, y, z, iconMaxX, iconMinY),
				new coords(x, y, z, iconMinX, iconMinY),
				new coords(x, direction == 2 ? coordHighHeight : coordLowHeight, z, iconMinX, direction == 2 ? iconHighHeight : iconLowHeight),
				new coords(x + 1, direction == 2 ? coordHighHeight : coordLowHeight, z, iconMaxX, direction == 2 ? iconHighHeight : iconLowHeight),
				null
			},
			{ //left
				new coords(x, y, z, iconMaxX, iconMinY),
				new coords(x, y, z + 1, iconMinX, iconMinY),
				new coords(x, direction == 3 ? coordHighHeight : coordLowHeight, z + 1, iconMinX, direction == 3 ? iconHighHeight : iconLowHeight),
				new coords(x, direction == 3 ? coordHighHeight : coordLowHeight, z, iconMaxX, direction == 3 ? iconHighHeight : iconLowHeight),
				null
			},
			{ //back
				new coords(x, y, z + 1, iconMaxX, iconMinY),
				new coords(x + 1, y, z + 1, iconMinX, iconMinY),
				new coords(x + 1, direction == 0 ? coordHighHeight : coordLowHeight, z + 1, iconMinX, direction == 0 ? iconHighHeight : iconLowHeight),
				new coords(x, direction == 0 ? coordHighHeight : coordLowHeight, z + 1, iconMaxX, direction == 0 ? iconHighHeight : iconLowHeight),
				null
			},
			{ //right
				new coords(x + 1, y, z + 1, iconMaxX, iconMinY),
				new coords(x + 1, y, z, iconMinX, iconMinY),
				new coords(x + 1, direction == 1 ? coordHighHeight : coordLowHeight, z, iconMinX, direction == 1 ? iconHighHeight : iconLowHeight),
				new coords(x + 1, direction == 1 ? coordHighHeight : coordLowHeight, z + 1, iconMaxX, direction == 1 ? iconHighHeight : iconLowHeight),
				null
			},
			{ //bottom
				new coords(x + 1, y, z + 1, iconMaxX, iconMinY),
				new coords(x, y, z + 1, iconMinX, iconMinY),
				new coords(x, y, z, iconMinX, iconMaxY),
				new coords(x + 1, y, z, iconMaxX, iconMaxY),
				null
			},
			{} //top - set below
		};
		
		switch (direction) {
		case 0: //Sloping Up North
			squares[1][4] = new coords(x, coordHighHeight, z + 1, iconMinX, iconHighHeight);
			squares[3][4] = new coords(x + 1, coordHighHeight, z + 1, iconMaxX, iconHighHeight);
			squares[5] = new coords[] {
				new coords(x + 1, coordLowHeight, z, topIconMaxX, topIconMinY),
				new coords(x, coordLowHeight, z, topIconMinX, topIconMinY),
				new coords(x, coordHighHeight, z + 1, topIconMinX, topIconMaxY),
				new coords(x + 1, coordHighHeight, z + 1, topIconMaxX, topIconMaxY),
				null
			};
			break;
		case 1: //Sloping Up East
			squares[0][4] = new coords(x + 1, coordHighHeight, z, iconMaxX, iconHighHeight);
			squares[2][4] = new coords(x + 1, coordHighHeight, z + 1, iconMinX, iconHighHeight);
			squares[5] = new coords[] {
				new coords(x + 1, coordHighHeight, z, topIconMaxX, topIconMinY),
				new coords(x, coordLowHeight, z, topIconMinX, topIconMinY),
				new coords(x, coordLowHeight, z + 1, topIconMinX, topIconMaxY),
				new coords(x + 1, coordHighHeight, z + 1, topIconMaxX, topIconMaxY),
				null
			};
			break;
		case 2: //Sloping Up South
			squares[1][4] = new coords(x, coordHighHeight, z, iconMaxX, iconHighHeight);
			squares[3][4] = new coords(x + 1, coordHighHeight, z, iconMinX, iconHighHeight);
			squares[5] = new coords[] {
				new coords(x + 1, coordHighHeight, z, topIconMaxX, topIconMinY),
				new coords(x, coordHighHeight, z, topIconMinX, topIconMinY),
				new coords(x, coordLowHeight, z + 1, topIconMinX, topIconMaxY),
				new coords(x + 1, coordLowHeight, z + 1, topIconMaxX, topIconMaxY),
				null
			};
			break;
		case 3: //Sloping Up West
			squares[0][4] = new coords(x, coordHighHeight, z, iconMinX, iconHighHeight);
			squares[2][4] = new coords(x, coordHighHeight, z + 1, iconMaxX, iconHighHeight);
			squares[5] = new coords[] {
				new coords(x + 1, coordLowHeight, z, topIconMaxX, topIconMinY),
				new coords(x, coordHighHeight, z, topIconMinX, topIconMinY),
				new coords(x, coordHighHeight, z + 1, topIconMinX, topIconMaxY),
				new coords(x + 1, coordLowHeight, z + 1, topIconMaxX, topIconMaxY),
				null
			};
			break;
		}
		
		for (coords[] square : squares) {
			square[0].addVertex();
			square[1].addVertex();
			square[2].addVertex();
			square[3].addVertex();
			if (square[4] != null) {
				square[3].addVertex();
				square[2].addVertex();
				square[4].addVertex();
				square[4].addVertex();
			}
		}
		
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

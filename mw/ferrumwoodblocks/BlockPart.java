package mw.ferrumwoodblocks;

import net.minecraft.util.Icon;

public class BlockPart {
	double minX;
	double maxX;
	double minY;
	double maxY;
	double minZ;
	double maxZ;
	String iconStr;
	Icon icon;
	
	public BlockPart(double x1, double y1, double z1, double x2, double y2, double z2, String icon) {
		this.minX = x1;
		this.maxX = x2;
		this.minY = y1;
		this.maxY = y2;
		this.minZ = z1;
		this.maxZ = z2;
		this.iconStr = icon;
	}
}
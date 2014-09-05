package mw.ferrumwoodblocks;

import mw.library.Blocks;
import mw.library.IBlockManipulator;

public class RoadBlockYellowManipulator implements IBlockManipulator {

	private static final int ROAD = 0;
	private static final int BACKSLASH = 1;
	private static final int SE = 2;
	private static final int NW = 3;
	private static final int SLASH = 4;
	private static final int SW = 5;
	private static final int NE = 6;
	private static final int EAST = 7;
	private static final int WEST = 8;
	private static final int FULL = 9;
	private static final int NORTH = 10;
	private static final int SOUTH = 11;
	private static final int NOTNW = 12;
	private static final int NOTNE = 13;
	private static final int NOTSW = 14;
	private static final int NOTSE = 15;
	
	@Override
	public Blocks rotate90(Blocks block) {
		switch (block.metadata) {
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SE:
			block.metadata = SW;
			break;
		case NW:
			block.metadata = NE;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case SW:
			block.metadata = NW;
			break;
		case NE:
			block.metadata = SE;
			break;
		case EAST:
			block.metadata = SOUTH;
			break;
		case WEST:
			block.metadata = NORTH;
			break;
		case NORTH:
			block.metadata = EAST;
			break;
		case SOUTH:
			block.metadata = WEST;
			break;
		case NOTNW:
			block.metadata = NOTNE;
			break;
		case NOTNE:
			block.metadata = NOTSE;
			break;
		case NOTSW:
			block.metadata = NOTNW;
			break;
		case NOTSE:
			block.metadata = NOTSW;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate180(Blocks block) {
		switch (block.metadata) {
		case SE:
			block.metadata = NW;
			break;
		case NW:
			block.metadata = SE;
			break;
		case SW:
			block.metadata = NE;
			break;
		case NE:
			block.metadata = SW;
			break;
		case EAST:
			block.metadata = WEST;
			break;
		case WEST:
			block.metadata = EAST;
			break;
		case NORTH:
			block.metadata = SOUTH;
			break;
		case SOUTH:
			block.metadata = NORTH;
			break;
		case NOTNW:
			block.metadata = NOTSE;
			break;
		case NOTNE:
			block.metadata = NOTSW;
			break;
		case NOTSW:
			block.metadata = NOTNE;
			break;
		case NOTSE:
			block.metadata = NOTNW;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate270(Blocks block) {
		switch (block.metadata) {
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SE:
			block.metadata = NE;
			break;
		case NW:
			block.metadata = SW;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case SW:
			block.metadata = SE;
			break;
		case NE:
			block.metadata = NW;
			break;
		case EAST:
			block.metadata = NORTH;
			break;
		case WEST:
			block.metadata = SOUTH;
			break;
		case NORTH:
			block.metadata = WEST;
			break;
		case SOUTH:
			block.metadata = EAST;
			break;
		case NOTNW:
			block.metadata = NOTSW;
			break;
		case NOTNE:
			block.metadata = NOTNW;
			break;
		case NOTSW:
			block.metadata = NOTSE;
			break;
		case NOTSE:
			block.metadata = NOTNE;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorX(Blocks block) {
		switch (block.metadata) {
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SE:
			block.metadata = SW;
			break;
		case NW:
			block.metadata = NE;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case SW:
			block.metadata = SE;
			break;
		case NE:
			block.metadata = NW;
			break;
		case EAST:
			block.metadata = WEST;
			break;
		case WEST:
			block.metadata = EAST;
			break;
		case NOTNW:
			block.metadata = NOTNE;
			break;
		case NOTNE:
			block.metadata = NOTNW;
			break;
		case NOTSW:
			block.metadata = NOTSE;
			break;
		case NOTSE:
			block.metadata = NOTSW;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorZ(Blocks block) {
		switch (block.metadata) {
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SE:
			block.metadata = NE;
			break;
		case NW:
			block.metadata = SW;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case SW:
			block.metadata = NW;
			break;
		case NE:
			block.metadata = SE;
			break;
		case NORTH:
			block.metadata = SOUTH;
			break;
		case SOUTH:
			block.metadata = NORTH;
			break;
		case NOTNW:
			block.metadata = NOTSW;
			break;
		case NOTNE:
			block.metadata = NOTSE;
			break;
		case NOTSW:
			block.metadata = NOTNW;
			break;
		case NOTSE:
			block.metadata = NOTNE;
			break;
		}
		return block;
	}
}

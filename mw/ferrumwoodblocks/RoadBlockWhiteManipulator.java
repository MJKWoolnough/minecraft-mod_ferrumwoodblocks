package mw.ferrumwoodblocks;

import mw.library.Blocks;
import mw.library.IBlockManipulator;

public class RoadBlockWhiteManipulator implements IBlockManipulator {
	
	private static final int NW = 0;
	private static final int NE = 1;
	private static final int SW = 2;
	private static final int SE = 3;
	private static final int WEST = 4;
	private static final int EAST = 5;
	private static final int NORTH = 6;
	private static final int SOUTH = 7;
	private static final int BACKSLASH = 8;
	private static final int SLASH = 9;
	private static final int NNW = 10;
	private static final int NNE = 11;
	private static final int NSW = 12;
	private static final int NSE = 13;
	private static final int FULL = 14;
	private static final int ROAD = 15;
	

	@Override
	public Blocks rotate90(Blocks block) {
		switch (block.metadata) {
		case NW:
			block.metadata = NE;
			break;
		case NE:
			block.metadata = SE;
			break;
		case SW:
			block.metadata = NW;
			break;
		case SE:
			block.metadata = SW;
			break;
		case WEST:
			block.metadata = NORTH;
			break;
		case EAST:
			block.metadata = SOUTH;
			break;
		case NORTH:
			block.metadata = EAST;
			break;
		case SOUTH:
			block.metadata = WEST;
			break;
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case NNW:
			block.metadata = NNE;
			break;
		case NNE:
			block.metadata = NSE;
			break;
		case NSW:
			block.metadata = NNW;
			break;
		case NSE:
			block.metadata = NSW;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate180(Blocks block) {
		switch (block.metadata) {
		case NW:
			block.metadata = SE;
			break;
		case NE:
			block.metadata = SW;
			break;
		case SW:
			block.metadata = NE;
			break;
		case SE:
			block.metadata = NW;
			break;
		case WEST:
			block.metadata = EAST;
			break;
		case EAST:
			block.metadata = WEST;
			break;
		case NORTH:
			block.metadata = SOUTH;
			break;
		case SOUTH:
			block.metadata = NORTH;
			break;
		case NNW:
			block.metadata = NSE;
			break;
		case NNE:
			block.metadata = NSW;
			break;
		case NSW:
			block.metadata = NNE;
			break;
		case NSE:
			block.metadata = NNW;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate270(Blocks block) {
		switch (block.metadata) {
		case NW:
			block.metadata = SW;
			break;
		case NE:
			block.metadata = NW;
			break;
		case SW:
			block.metadata = SE;
			break;
		case SE:
			block.metadata = NE;
			break;
		case WEST:
			block.metadata = SOUTH;
			break;
		case EAST:
			block.metadata = NORTH;
			break;
		case NORTH:
			block.metadata = WEST;
			break;
		case SOUTH:
			block.metadata = EAST;
			break;
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case NNW:
			block.metadata = NSW;
			break;
		case NNE:
			block.metadata = NNW;
			break;
		case NSW:
			block.metadata = NSE;
			break;
		case NSE:
			block.metadata = NNE;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorX(Blocks block) {
		switch (block.metadata) {
		case NW:
			block.metadata = NE;
			break;
		case NE:
			block.metadata = NW;
			break;
		case SW:
			block.metadata = SE;
			break;
		case SE:
			block.metadata = SW;
			break;
		case WEST:
			block.metadata = EAST;
			break;
		case EAST:
			block.metadata = WEST;
			break;
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case NNW:
			block.metadata = NNE;
			break;
		case NNE:
			block.metadata = NNW;
			break;
		case NSW:
			block.metadata = NSE;
			break;
		case NSE:
			block.metadata = NSW;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorZ(Blocks block) {
		switch (block.metadata) {
		case NW:
			block.metadata = SW;
			break;
		case NE:
			block.metadata = SE;
			break;
		case SW:
			block.metadata = NW;
			break;
		case SE:
			block.metadata = NE;
			break;
		case NORTH:
			block.metadata = SOUTH;
			break;
		case SOUTH:
			block.metadata = NORTH;
			break;
		case BACKSLASH:
			block.metadata = SLASH;
			break;
		case SLASH:
			block.metadata = BACKSLASH;
			break;
		case NNW:
			block.metadata = NSW;
			break;
		case NNE:
			block.metadata = NSE;
			break;
		case NSW:
			block.metadata = NNW;
			break;
		case NSE:
			block.metadata = NNE;
			break;
		}
		return block;
	}
}

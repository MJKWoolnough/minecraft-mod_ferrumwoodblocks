package mw.ferrumwoodblocks;

import mw.library.Blocks;
import mw.library.IBlockManipulator;

public class RoadBlockWhiteManipulator implements IBlockManipulator {

	private static final byte	NW		= 0;
	private static final byte	NE		= 1;
	private static final byte	SW		= 2;
	private static final byte	SE		= 3;
	private static final byte	WEST		= 4;
	private static final byte	EAST		= 5;
	private static final byte	NORTH		= 6;
	private static final byte	SOUTH		= 7;
	private static final byte	BACKSLASH	= 8;
	private static final byte	SLASH		= 9;
	private static final byte	NNW		= 10;
	private static final byte	NNE		= 11;
	private static final byte	NSW		= 12;
	private static final byte	NSE		= 13;
	private static final byte	FULL		= 14;
	private static final byte	ROAD		= 15;

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

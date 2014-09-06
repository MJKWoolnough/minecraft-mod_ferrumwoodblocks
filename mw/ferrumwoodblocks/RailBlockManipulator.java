package mw.ferrumwoodblocks;

import mw.library.Blocks;
import mw.library.IBlockManipulator;

public class RailBlockManipulator implements IBlockManipulator {
	private static final byte RAILNSWEST = 0;
	private static final byte RAILNSEAST = 1;
	private static final byte RAILNSSLEEPERNW = 2;
	private static final byte RAILNSSLEEPERNE = 3;
	private static final byte RAILNSSLEEPERSW = 4;
	private static final byte RAILNSSLEEPERSE = 5;
	private static final byte RAILNSSLEEPERN = 6;
	private static final byte RAILNSSLEEPERS = 7;
	
	private static final byte RAILEWSOUTH = 8;
	private static final byte RAILEWNORTH = 9;
	private static final byte RAILEWSLEEPERNW = 10;
	private static final byte RAILEWSLEEPERSW = 11;
	private static final byte RAILEWSLEEPERNE = 12;
	private static final byte RAILEWSLEEPERSE = 13;
	private static final byte RAILEWSLEEPERW = 14;
	private static final byte RAILEWSLEEPERE = 15;
	

	@Override
	public Blocks rotate90(Blocks block) {
		switch (block.metadata) {
		case RAILNSWEST:
			block.metadata = RAILEWSOUTH;
			break;
		case RAILNSEAST:
			block.metadata = RAILEWNORTH;
			break;
		case RAILNSSLEEPERNW:
			block.metadata = RAILEWSLEEPERNE;
			break;
		case RAILNSSLEEPERNE:
			block.metadata = RAILEWSLEEPERSE;
			break;
		case RAILNSSLEEPERSW:
			block.metadata = RAILEWSLEEPERNW;
			break;
		case RAILNSSLEEPERSE:
			block.metadata = RAILEWSLEEPERSW;
			break;
		case RAILNSSLEEPERN:
			block.metadata = RAILEWSLEEPERE;
			break;
		case RAILNSSLEEPERS:
			block.metadata = RAILEWSLEEPERW;
			break;
		case RAILEWSOUTH:
			block.metadata = RAILNSEAST;
			break;
		case RAILEWNORTH:
			block.metadata = RAILNSWEST;
			break;
		case RAILEWSLEEPERNW:
			block.metadata = RAILNSSLEEPERNE;
			break;
		case RAILEWSLEEPERSW:
			block.metadata = RAILNSSLEEPERNW;
			break;
		case RAILEWSLEEPERNE:
			block.metadata = RAILNSSLEEPERSE;
			break;
		case RAILEWSLEEPERSE:
			block.metadata = RAILNSSLEEPERSW;
			break;
		case RAILEWSLEEPERW:
			block.metadata = RAILNSSLEEPERN;
			break;
		case RAILEWSLEEPERE:
			block.metadata = RAILNSSLEEPERS;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate180(Blocks block) {
		switch (block.metadata) {
		case RAILNSWEST:
			block.metadata = RAILNSEAST;
			break;
		case RAILNSEAST:
			block.metadata = RAILNSWEST;
			break;
		case RAILNSSLEEPERNW:
			block.metadata = RAILNSSLEEPERSE;
			break;
		case RAILNSSLEEPERNE:
			block.metadata = RAILNSSLEEPERSW;
			break;
		case RAILNSSLEEPERSW:
			block.metadata = RAILNSSLEEPERNE;
			break;
		case RAILNSSLEEPERSE:
			block.metadata = RAILNSSLEEPERNW;
			break;
		case RAILNSSLEEPERN:
			block.metadata = RAILNSSLEEPERS;
			break;
		case RAILNSSLEEPERS:
			block.metadata = RAILNSSLEEPERN;
			break;
		case RAILEWSOUTH:
			block.metadata = RAILEWNORTH;
			break;
		case RAILEWNORTH:
			block.metadata = RAILEWSOUTH;
			break;
		case RAILEWSLEEPERNW:
			block.metadata = RAILEWSLEEPERSE;
			break;
		case RAILEWSLEEPERSW:
			block.metadata = RAILEWSLEEPERNE;
			break;
		case RAILEWSLEEPERNE:
			block.metadata = RAILEWSLEEPERSW;
			break;
		case RAILEWSLEEPERSE:
			block.metadata = RAILEWSLEEPERNW;
			break;
		case RAILEWSLEEPERW:
			block.metadata = RAILEWSLEEPERE;
			break;
		case RAILEWSLEEPERE:
			block.metadata = RAILEWSLEEPERW;
			break;
		}
		return block;
	}

	@Override
	public Blocks rotate270(Blocks block) {
		switch (block.metadata) {
		case RAILNSWEST:
			block.metadata = RAILEWNORTH;
			break;
		case RAILNSEAST:
			block.metadata = RAILEWSOUTH;
			break;
		case RAILNSSLEEPERNW:
			block.metadata = RAILEWSLEEPERSW;
			break;
		case RAILNSSLEEPERNE:
			block.metadata = RAILEWSLEEPERNW;
			break;
		case RAILNSSLEEPERSW:
			block.metadata = RAILEWSLEEPERSE;
			break;
		case RAILNSSLEEPERSE:
			block.metadata = RAILEWSLEEPERNE;
			break;
		case RAILNSSLEEPERN:
			block.metadata = RAILEWSLEEPERW;
			break;
		case RAILNSSLEEPERS:
			block.metadata = RAILEWSLEEPERE;
			break;
		case RAILEWSOUTH:
			block.metadata = RAILNSWEST;
			break;
		case RAILEWNORTH:
			block.metadata = RAILNSEAST;
			break;
		case RAILEWSLEEPERNW:
			block.metadata = RAILNSSLEEPERSW;
			break;
		case RAILEWSLEEPERSW:
			block.metadata = RAILNSSLEEPERSE;
			break;
		case RAILEWSLEEPERNE:
			block.metadata = RAILNSSLEEPERNW;
			break;
		case RAILEWSLEEPERSE:
			block.metadata = RAILNSSLEEPERNE;
			break;
		case RAILEWSLEEPERW:
			block.metadata = RAILNSSLEEPERS;
			break;
		case RAILEWSLEEPERE:
			block.metadata = RAILNSSLEEPERN;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorX(Blocks block) {
		switch (block.metadata) {
		case RAILNSWEST:
			block.metadata = RAILNSEAST;
			break;
		case RAILNSEAST:
			block.metadata = RAILNSWEST;
			break;
		case RAILNSSLEEPERNW:
			block.metadata = RAILNSSLEEPERNE;
			break;
		case RAILNSSLEEPERNE:
			block.metadata = RAILNSSLEEPERNW;
			break;
		case RAILNSSLEEPERSW:
			block.metadata = RAILNSSLEEPERSE;
			break;
		case RAILNSSLEEPERSE:
			block.metadata = RAILNSSLEEPERSW;
			break;
		case RAILEWSLEEPERNW:
			block.metadata = RAILEWSLEEPERNE;
			break;
		case RAILEWSLEEPERSW:
			block.metadata = RAILEWSLEEPERSE;
			break;
		case RAILEWSLEEPERNE:
			block.metadata = RAILEWSLEEPERNW;
			break;
		case RAILEWSLEEPERSE:
			block.metadata = RAILEWSLEEPERSW;
			break;
		case RAILEWSLEEPERW:
			block.metadata = RAILEWSLEEPERE;
			break;
		case RAILEWSLEEPERE:
			block.metadata = RAILEWSLEEPERW;
			break;
		}
		return block;
	}

	@Override
	public Blocks mirrorZ(Blocks block) {
		switch (block.metadata) {
		case RAILNSSLEEPERNW:
			block.metadata = RAILNSSLEEPERSW;
			break;
		case RAILNSSLEEPERNE:
			block.metadata = RAILNSSLEEPERSE;
			break;
		case RAILNSSLEEPERSW:
			block.metadata = RAILNSSLEEPERNW;
			break;
		case RAILNSSLEEPERSE:
			block.metadata = RAILNSSLEEPERNE;
			break;
		case RAILNSSLEEPERN:
			block.metadata = RAILNSSLEEPERS;
			break;
		case RAILNSSLEEPERS:
			block.metadata = RAILNSSLEEPERN;
			break;
		case RAILEWSOUTH:
			block.metadata = RAILEWNORTH;
			break;
		case RAILEWNORTH:
			block.metadata = RAILEWSOUTH;
			break;
		case RAILEWSLEEPERNW:
			block.metadata = RAILEWSLEEPERSW;
			break;
		case RAILEWSLEEPERSW:
			block.metadata = RAILEWSLEEPERNW;
			break;
		case RAILEWSLEEPERNE:
			block.metadata = RAILEWSLEEPERSE;
			break;
		case RAILEWSLEEPERSE:
			block.metadata = RAILEWSLEEPERNE;
			break;
		}
		return block;
	}

}

package mw.ferrumwoodblocks;

import java.io.File;

import mw.library.BlockManipulator;
import mw.library.DefaultManipulators;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="ferrumwoodblocks", name="FerrumwoodBlocks", version="1.6.0", dependencies = "required-after:MWLibrary")
public class ModFerrumwoodBlocks {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	Configuration Config = new Configuration(event.getSuggestedConfigurationFile());
    	Config.load();
    	int roadBlockYellowId = Config.get("BlockIds", "RoadBlockYellow", 4000).getInt();
    	int roadBlockWhiteId = Config.get("BlockIds", "RoadBlockWhite", 4001).getInt();
    	int roadBlockStepsId = Config.get("BlockIds", "RoadBlockSteps", 4002).getInt();
    	int railBlockId = Config.get("BlockIds", "RailBlock", 4003).getInt();
    	int miscBlockId = Config.get("BlockIds", "MiscBlock", 4004).getInt();
    	int fenceBlockId = Config.get("BlockIds", "FenceBlock", 4005).getInt();
    	int wallBlockId = Config.get("BlockIds", "WallBlock", 4006).getInt();
    	int doorId = Config.get("BlockIds", "DoorBlock", 4007).getInt();
    	int roadSlopeId = Config.get("BlockIds", "SlopeBlock", 4008).getInt();
    	
    	Config.save();
    	
    	GameRegistry.registerBlock(new RoadSlab(roadBlockYellowId, true), BlockItem.class, "roadSlab1");
    	BlockManipulator.registerManipulator(roadBlockYellowId, new RoadBlockYellowManipulator());
    	
    	GameRegistry.registerBlock(new RoadSlab(roadBlockWhiteId, false), BlockItem.class, "roadSlab2");
    	BlockManipulator.registerManipulator(roadBlockWhiteId, new RoadBlockWhiteManipulator());
    	
    	GameRegistry.registerBlock(new RoadSteps(roadBlockStepsId), "roadStep");
    	BlockManipulator.registerManipulator(roadBlockStepsId, BlockManipulator.getManipulator(Block.stairsWoodOak.blockID));
    	
    	GameRegistry.registerBlock(new FenceBlock(fenceBlockId), BlockItem.class, "fenceBlock");
    	GameRegistry.registerBlock(new WallBlock(wallBlockId), BlockItem.class, "wallBlock");
    	
    	GameRegistry.registerTileEntity(DoorTileEntity.class, "ferrumwooddoors");
    	GameRegistry.registerBlock(new DoorBlock(doorId), DoorItem.class, "doorBlocks");
    	BlockManipulator.registerManipulator(doorId, BlockManipulator.getManipulator(Block.doorWood.blockID));
    	
    	GameRegistry.registerBlock(new RoadSlope(roadSlopeId), RoadSlopeItem.class, "roadSlope");
    	BlockManipulator.registerManipulator(roadSlopeId, new DefaultManipulators.Bits(12, 8, 4, 0, 12));
    	
    	Block.blocksList[95] = null;
    	Block.lightValue[95] = 0;
    	Item.itemsList[95] = null;
    	GameRegistry.registerBlock(new StainedGlass(95), ItemColouredGlass.class, "stainedGlass");
    	GameRegistry.registerBlock(new StainedGlassPane(160), ItemColouredGlass.class, "stainedGlassPane");
    	
    	MultipartBlock rp = (MultipartBlock) new MultipartBlock(railBlockId, new BlockPart[][] {
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v")
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v")
    			},
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v"),
    				new BlockPart(0, 0, 0, 0.875, 0.2, 0.25, ModFerrumwoodBlocks.getModId() + ":sleepers_v"),
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v"),
    				new BlockPart(0.125, 0, 0, 1, 0.2, 0.25, ModFerrumwoodBlocks.getModId() + ":sleepers_v"),
    			},
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v"),
    				new BlockPart(0, 0, 0.75, 0.875, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_v"),
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_v"),
    				new BlockPart(0.125, 0, 0.75, 1, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_v"),
    			},
    			
    			{
    				new BlockPart(0, 0, 0, 1, 0.2, 0.25, ModFerrumwoodBlocks.getModId() + ":sleepers_v")
    			},
    			{
    				new BlockPart(0, 0, 0.75, 1, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_v")
    			},
    			
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_h")
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, ModFerrumwoodBlocks.getModId() + ":rail_h")
    			},
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_h"),
    				new BlockPart(0, 0, 0, 0.25, 0.2, 0.875, ModFerrumwoodBlocks.getModId() + ":sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, ModFerrumwoodBlocks.getModId() + ":rail_h"),
    				new BlockPart(0, 0, 0.125, 0.25, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, ModFerrumwoodBlocks.getModId() + ":rail_h"),
    				new BlockPart(0.75, 0, 0, 1, 0.2, 0.875, ModFerrumwoodBlocks.getModId() + ":sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, ModFerrumwoodBlocks.getModId() + ":rail_h"),
    				new BlockPart(0.75, 0, 0.125, 1, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_h"),
    			},
    			
    			{
    				new BlockPart(0, 0, 0, 0.25, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_h")
    			},
    			{
    				new BlockPart(0.75, 0, 0, 1, 0.2, 1, ModFerrumwoodBlocks.getModId() + ":sleepers_h")
    			}
    			
    	})
		.setStepSound(Block.soundMetalFootstep)
		.setCreativeTab(CreativeTabs.tabTransport)
		.setUnlocalizedName("railPiece");
    	
    	BlockManipulator.registerManipulator(railBlockId, new RailBlockManipulator());
    	
    	MultipartBlock rb = (MultipartBlock) new MultipartBlock(miscBlockId, new BlockPart[][] {
    		{
    			new BlockPart(0, 0, 0, 0.5, 0.5, 1, "stonebrick"),
    			new BlockPart(0.5, 0.5, 0, 1, 1, 1, "stonebrick")
    		},
    		{
    			new BlockPart(0.5, 0, 0, 1, 0.5, 1, "stonebrick"),
    			new BlockPart(0, 0.5, 0, 0.5, 1, 1, "stonebrick")
    		},
    		{
    			new BlockPart(0, 0.5, 0, 1, 1, 1, "stonebrick")
    		},
    		{
    			new BlockPart(0, 0.5, 0, 1, 1, 0.5, "stonebrick")
    		},
    		{
    			new BlockPart(0, 0.5, 0.5, 1, 1, 1, "stonebrick")
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 0.5, 1, "stonebrick"),
    			new BlockPart(0, 0.5, 0, 1, 1, 1, "stone")
    		},
    		{
    			new BlockPart(0, 0.875, 0, 1, 1, 1, "stonebrick")
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 1, 0.5, "stone"),
    			new BlockPart(0, 0, 0.5, 1, 1, 1, ModFerrumwoodBlocks.getModId() + ":yellow_line"),
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 1, 0.5, ModFerrumwoodBlocks.getModId() + ":yellow_line"),
    			new BlockPart(0, 0, 0.5, 1, 1, 1, "stone"),
    		},
    		{
    			new BlockPart(0, 0, 0, 0.5, 1, 1, "stone"),
    			new BlockPart(0.5, 0, 0, 1, 1, 1, ModFerrumwoodBlocks.getModId() + ":yellow_line"),
    		},
    		{
    			new BlockPart(0, 0, 0, 0.5, 1, 1, ModFerrumwoodBlocks.getModId() + ":yellow_line"),
    			new BlockPart(0.5, 0, 0, 1, 1, 1, "stone"),
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 0.5, 0.5, "dirt")
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 0.5, 0.5, "cobblestone_mossy")
    		},
    		{
    			new BlockPart(0, 0.5, 0, 1, 1, 0.5, "stone")
    		}
    		
    	})
		.setStepSound(Block.soundStoneFootstep)
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setUnlocalizedName("railBlock");
    	GameRegistry.registerBlock(rp, BlockItem.class, "railPieces");
    	GameRegistry.registerBlock(rb, BlockItem.class, "railBlocks");
    	
    	BlockManipulator.registerManipulator(miscBlockId, new DefaultManipulators.Bits(15, 8, 9, 7, 10));
    	
    	if (event.getSide().isClient()) {
    		MultipartRender.renderId = RenderingRegistry.getNextAvailableRenderId();
    		MultiTextureRender.renderId = RenderingRegistry.getNextAvailableRenderId();
    		SlopeRender.renderId = RenderingRegistry.getNextAvailableRenderId();
    		StainedGlassRenderer.renderId = RenderingRegistry.getNextAvailableRenderId();
    		StainedGlassPaneRenderer.renderId = RenderingRegistry.getNextAvailableRenderId();
    		RenderingRegistry.registerBlockHandler(MultipartRender.renderId, new MultipartRender());
    		RenderingRegistry.registerBlockHandler(MultiTextureRender.renderId, new MultiTextureRender());
    		RenderingRegistry.registerBlockHandler(SlopeRender.renderId, new SlopeRender());
    		RenderingRegistry.registerBlockHandler(StainedGlassRenderer.renderId, new StainedGlassRenderer());
    		RenderingRegistry.registerBlockHandler(StainedGlassPaneRenderer.renderId, new StainedGlassPaneRenderer());
    		
    		int doorMasks = Config.get("DoorPart", "masks", 13).getInt();
        	int doorTextures = Config.get("DoorPart", "textures", 6).getInt();
        	
        	if (doorMasks < 0) {
        		doorMasks = 0;
        	} else if (doorMasks > 255) {
        		doorMasks = 255;
        	}
        	if (doorTextures < 0) {
        		doorTextures = 0;
        	} else if (doorTextures > 255) {
        		doorTextures = 255;
        	}
        	
        	DoorBlock.masks = doorMasks;
        	DoorBlock.textures = doorTextures;
    	}
    	
    	//Cheat-y Light fixes
    	
    	Block.stoneSingleSlab.setLightOpacity(0);
    	Block.woodSingleSlab.setLightOpacity(0);
    }

	public static String getModId() {
		return "ferrumwoodblocks";
	}
}
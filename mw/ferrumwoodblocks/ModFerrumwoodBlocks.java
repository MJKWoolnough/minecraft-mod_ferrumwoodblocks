package mw.ferrumwoodblocks;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="FerrumWoodBlocks", name="FerrumWoodBlocks", version="1.0.0")
public class ModFerrumwoodBlocks {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	Configuration Config = new Configuration(new File("config/FerrumwoodBlocksMod.cfg"));
    	Config.load();
    	int roadBlockYellowId = Config.get("BlockIds", "RoadBlockYellow", 4000).getInt();
    	int roadBlockWhiteId = Config.get("BlockIds", "RoadBlockWhite", 4001).getInt();
    	int roadBlockStepsId = Config.get("BlockIds", "RoadBlockSteps", 4002).getInt();
    	int railBlockId = Config.get("BlockIds", "RailBlock", 4003).getInt();
    	int miscBlockId = Config.get("BlockIds", "MiscBlock", 4004).getInt();
    	int lampBlockOffId = Config.get("BlockIds", "LampBlockOff", 4005).getInt();
    	int lampBlockOnId = Config.get("BlockIds", "LampBlockOn", 4006).getInt();
    	Config.save();
    	
    	LampBlock.unpoweredId = lampBlockOffId;
    	LampBlock.poweredId = lampBlockOnId;
    	
    	GameRegistry.registerBlock(new RoadSlab(roadBlockYellowId, true), BlockItem.class, "roadSlab1");
    	GameRegistry.registerBlock(new RoadSlab(roadBlockWhiteId, false), BlockItem.class, "roadSlab2");
    	GameRegistry.registerBlock(new RoadSteps(roadBlockStepsId), "roadStep");
    	GameRegistry.registerBlock(new LampBlock(lampBlockOffId, false), BlockItem.class, "lampBlockOff");
    	GameRegistry.registerBlock(new LampBlock(lampBlockOnId, true), "lampBlockOn");
    	
    	MultipartBlock rp = (MultipartBlock) new MultipartBlock(railBlockId, new BlockPart[][] {
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, "rail_v")
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, "rail_v")
    			},
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, "rail_v"),
    				new BlockPart(0, 0, 0, 0.875, 0.2, 0.25, "sleepers_v"),
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, "rail_v"),
    				new BlockPart(0.125, 0, 0, 1, 0.2, 0.25, "sleepers_v"),
    			},
    			{
    				new BlockPart(0.875, 0, 0, 1, 0.4, 1, "rail_v"),
    				new BlockPart(0, 0, 0.75, 0.875, 0.2, 1, "sleepers_v"),
    			},
    			{
    				new BlockPart(0, 0, 0, 0.125, 0.4, 1, "rail_v"),
    				new BlockPart(0.125, 0, 0.75, 1, 0.2, 1, "sleepers_v"),
    			},
    			
    			{
    				new BlockPart(0, 0, 0, 1, 0.2, 0.25, "sleepers_v")
    			},
    			{
    				new BlockPart(0, 0, 0.75, 1, 0.2, 1, "sleepers_v")
    			},
    			
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, "rail_h")
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, "rail_h")
    			},
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, "rail_h"),
    				new BlockPart(0, 0, 0, 0.25, 0.2, 0.875, "sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, "rail_h"),
    				new BlockPart(0, 0, 0.125, 0.25, 0.2, 1, "sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0.875, 1, 0.4, 1, "rail_h"),
    				new BlockPart(0.75, 0, 0, 1, 0.2, 0.875, "sleepers_h"),
    			},
    			{
    				new BlockPart(0, 0, 0, 1, 0.4, 0.125, "rail_h"),
    				new BlockPart(0.75, 0, 0.125, 1, 0.2, 1, "sleepers_h"),
    			},
    			
    			{
    				new BlockPart(0, 0, 0, 0.25, 0.2, 1, "sleepers_h")
    			},
    			{
    				new BlockPart(0.75, 0, 0, 1, 0.2, 1, "sleepers_h")
    			}
    			
    	})
		.setStepSound(Block.soundMetalFootstep)
		.setCreativeTab(CreativeTabs.tabTransport)
		.setUnlocalizedName("railPiece");
    	
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
    			new BlockPart(0, 0, 0.5, 1, 1, 1, "yellow_line"),
    		},
    		{
    			new BlockPart(0, 0, 0, 1, 1, 0.5, "yellow_line"),
    			new BlockPart(0, 0, 0.5, 1, 1, 1, "stone"),
    		},
    		{
    			new BlockPart(0, 0, 0, 0.5, 1, 1, "stone"),
    			new BlockPart(0.5, 0, 0, 1, 1, 1, "yellow_line"),
    		},
    		{
    			new BlockPart(0, 0, 0, 0.5, 1, 1, "yellow_line"),
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
    		},
    		{
    			new BlockPart(0.875, 0, 0, 1.125, 0.4, 2, "rail_v"),
    			new BlockPart(1.125, 0, 0.75, 3.875, 0.2, 1.25, "sleepers_v"),
    			new BlockPart(3.875, 0, 0, 4.125, 0.4, 2, "rail_v")
    		},
    		{
    			new BlockPart(0, 0, 0.875, 2, 0.4, 1.125, "rail_h"),
    			new BlockPart(0.75, 0, 1.125, 1.25, 0.2, 3.875, "sleepers_h"),
    			new BlockPart(0, 0, 3.875, 2, 0.4, 4.125, "rail_h")
    		}
    		
    	})
		.setStepSound(Block.soundStoneFootstep)
		.setCreativeTab(CreativeTabs.tabDecorations)
		.setUnlocalizedName("railBlock");
    	GameRegistry.registerBlock(rp, BlockItem.class, "railPieces");
    	GameRegistry.registerBlock(rb, BlockItem.class, "railBlocks");
    	
    	if (event.getSide().isClient()) {
    		MultipartRender.renderId = RenderingRegistry.getNextAvailableRenderId();
    		RenderingRegistry.registerBlockHandler(MultipartRender.renderId, new MultipartRender());
    	}
    }
}
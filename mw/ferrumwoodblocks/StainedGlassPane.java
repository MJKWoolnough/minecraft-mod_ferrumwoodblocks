package mw.ferrumwoodblocks;

import java.util.List;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class StainedGlassPane extends BlockPane {

	private Icon[] sideIcons;
	private Icon[] topIcons;
	
	protected StainedGlassPane(int blockId) {
		super(blockId, "glass", "glass_pane_top", Material.glass, false);
		this.setHardness(0.3F)
		.setStepSound(soundGlassFootstep)
		.setUnlocalizedName("thinGlass")
		.setTextureName(ModFerrumwoodBlocks.getModId() + ":glass_");
	}
	
	@Override
	public int getRenderBlockPass() {
        return 1;
    }
	
	@Override
    public int getRenderType() {
        return StainedGlassPaneRenderer.renderId;
    }
	
	@Override
	public Icon getIcon(int side, int metadata) {
		this.theIcon = this.topIcons[metadata];
        return this.sideIcons[metadata];
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister){
        this.sideIcons = new Icon[16];
        this.topIcons = new Icon[16];
		for (int i = 0; i < 16; i++) {
			this.sideIcons[i] = iconRegister.registerIcon(this.getTextureName() + ItemDye.dyeItemNames[~i & 15]);
			this.topIcons[i] = iconRegister.registerIcon(this.getTextureName() + "pane_top_" + ItemDye.dyeItemNames[~i & 15]);
		}
    }
	
	@Override
	public void getSubBlocks(int blockId, CreativeTabs cTabs, List list) {
        for (int i = 0; i < 16; i++) {
            list.add(new ItemStack(blockId, 1, i));
        }
    }
	
	@Override
	public int damageDropped(int metadata) {
        return metadata;
    }
	
	@Override
	public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir) {
		return world.getBlockId(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ) == 95 || super.canPaneConnectTo(world, x, y, z, dir);
    }

}

package mw.ferrumwoodblocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class DoorTileEntity extends TileEntity {

	private static final String nbtDataName = "metadata";
	
	public int metadata;
	
	public DoorTileEntity() {}
	
	public DoorTileEntity(int metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.metadata = compound.getInteger(nbtDataName);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger(nbtDataName, this.metadata);
	}
	
	@Override
	public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger(nbtDataName, this.metadata);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, compound);
    }

	@Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		this.metadata = packet.data.getInteger(nbtDataName);
    }
}

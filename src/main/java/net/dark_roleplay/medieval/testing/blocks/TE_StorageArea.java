package net.dark_roleplay.medieval.testing.blocks;

public class TE_StorageArea{}/*  extends TileEntity {

	private MultiStackHandler inventoryMain = new MultiStackHandler(4) {
		@Override
		protected void onContentsChanged(int slot) {
			TE_StorageArea.this.markDirty();
	        IBlockState state = TE_StorageArea.this.world.getBlockState(TE_StorageArea.this.getPos());
			TE_StorageArea.this.world.notifyBlockUpdate(TE_StorageArea.this.getPos(), state, state, 2);
		}
	};

	@Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

//        this.inventoryMain = new ItemStackHandler() {
//			@Override
//		    protected void onContentsChanged(int slot){
//				DynamicStorageTileEntity.this.markDirty();
//		    }
//		};

        if(compound.hasKey("inventoryMain"))
        	this.inventoryMain.deserializeNBT((NBTTagCompound) compound.getTag("inventoryMain"));
    }

    @Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound comp = super.writeToNBT(compound);

        NBTTagCompound inventory = this.inventoryMain.serializeNBT();
        comp.setTag("inventoryMain", inventory);

        return comp;
    }

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
    	return super.hasCapability(capability, facing);
	}

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.inventoryMain;
    	return super.getCapability(capability, facing);
	}
}*/

package net.dark_roleplay.medieval.testing.building_scanner;

public class TE_BuildingScanner{}/*  extends TileEntity implements ITickable{

	public List<BlockPos> containedArea = new ArrayList<BlockPos>();
	public List<Long> scannedBlocks = new ArrayList<Long>();
	public List<BlockPos> scheduledBlocks = new ArrayList<BlockPos>();

	public void activate() {
		this.scheduledBlocks.add(this.pos.up());
		this.scheduledBlocks.add(this.pos.north());
		this.scheduledBlocks.add(this.pos.east());
		this.scheduledBlocks.add(this.pos.south());
		this.scheduledBlocks.add(this.pos.west());
		this.scheduledBlocks.add(this.pos.down());
	}

	@Override
	public void update() {
		if(this.scheduledBlocks.size() > 0) {
			BlockPos pos = this.scheduledBlocks.get(0);
			this.scheduledBlocks.remove(0);
			if(this.scannedBlocks.contains(pos.toLong())) return;

			if(this.world.isAirBlock(pos)) {
				this.containedArea.add(pos);
				if(!this.scannedBlocks.contains(pos.up().toLong())) 	this.scheduledBlocks.add(pos.up());
				if(!this.scannedBlocks.contains(pos.north().toLong())) 	this.scheduledBlocks.add(pos.north());
				if(!this.scannedBlocks.contains(pos.east().toLong()))	this.scheduledBlocks.add(pos.east());
				if(!this.scannedBlocks.contains(pos.south().toLong()))	this.scheduledBlocks.add(pos.south());
				if(!this.scannedBlocks.contains(pos.west().toLong())) 	this.scheduledBlocks.add(pos.west());
				if(!this.scannedBlocks.contains(pos.down().toLong())) 	this.scheduledBlocks.add(pos.down());
			}

			this.scannedBlocks.add(pos.toLong());
		}
	}

}*/

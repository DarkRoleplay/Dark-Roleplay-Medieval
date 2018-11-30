package net.dark_roleplay.medieval.common.objects.tile_entities.old;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityFirepit extends TileEntity implements ITickable {

	Random rnd = new Random();
	float flicker = 0F;
	int wait = 3;

	@Override
	public void update() {
		wait--;
		if(wait < 0){
			this.flicker = rnd.nextFloat() / 5F;
			wait = rnd.nextInt(3);
		}
	}
}

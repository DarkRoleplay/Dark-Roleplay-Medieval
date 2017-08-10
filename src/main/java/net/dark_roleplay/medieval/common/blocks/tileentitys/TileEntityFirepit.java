package net.dark_roleplay.medieval.common.blocks.tileentitys;

import java.util.Random;

import elucent.albedo.lighting.ILightProvider;
import elucent.albedo.lighting.Light;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface="elucent.albedo.lighting.ILightProvider", modid="albedo")
public class TileEntityFirepit extends TileEntity implements ILightProvider, ITickable {

	Random rnd = new Random();
	float flicker = 0F;
	int wait = 3;
	
	@Optional.Method(modid="albedo")
	@Override
	public Light provideLight() {
		update();
		return Light.builder()
				.pos(this.getPos())
				.color(0.8F + this.flicker, 0.6F + this.flicker, 0F)
				.radius(6 + (rnd.nextFloat()/2))
				.build();
	}

	@Override
	public void update() {
		wait--;
		if(wait < 0){
			this.flicker = rnd.nextFloat() / 5F;
			wait = rnd.nextInt(3);
		}
	}
}

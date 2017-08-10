package net.dark_roleplay.medieval.common.music;

import java.text.DecimalFormat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class InstrumentSounds {

	private SoundEvent[] sounds = new SoundEvent[12];
	
	public InstrumentSounds(String modid, String instrument){

		DecimalFormat df = new DecimalFormat("00.##"); 
		
		for(int i = 0; i < 12; i++){
			ResourceLocation loc = new ResourceLocation(modid, "instrument_" + instrument + "_" + df.format(i + 1));
			this.sounds[i] = new SoundEvent(loc).setRegistryName(loc);
		}
	}
	
	public void register(IForgeRegistry<SoundEvent> reg){
		for(int i = 0; i < this.sounds.length; i++){
			reg.register(this.sounds[i]);
		}
	}
	
	public void playInstrument(World world, EntityPlayer player, BlockPos pos, int sound){
		world.playSound(player, pos, this.sounds[sound], SoundCategory.RECORDS, 5F, 1.0f);
	}
	
}

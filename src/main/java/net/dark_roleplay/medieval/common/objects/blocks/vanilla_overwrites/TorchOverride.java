package net.dark_roleplay.medieval.common.objects.blocks.vanilla_overwrites;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TorchOverride extends BlockTorch{

	public TorchOverride() {
		super();
		this.setRegistryName(new ResourceLocation("minecraft", "torch"));
		this.setTranslationKey("torch");
		this.setHardness(0.0F);
		this.setLightLevel(0.9375F);
		this.setSoundType(SoundType.WOOD);
	}

	@Override
    public void fillWithRain(World world, BlockPos pos){
		world.destroyBlock(pos, false);
		System.out.println("Rain");
    }
}

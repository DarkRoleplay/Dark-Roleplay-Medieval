package net.dark_roleplay.medieval.common.objects.blocks.building;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.entities.rope_slide.RopeSlider;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PackedIceBricks extends Block{

	public PackedIceBricks(String registryName) {
	    super(Material.PACKED_ICE);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(0.5F);
	    this.setSoundType(SoundType.GLASS);
        this.slipperiness = 0.98F;
    }
	
	@Override
    public int quantityDropped(Random random){
        return 0;
    }

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		RopeSlider t = new RopeSlider(world, pos, pos.add(10, 10, 10));
		world.spawnEntity(t);
		playerIn.startRiding(t);
        return true;
    }
	
	
}

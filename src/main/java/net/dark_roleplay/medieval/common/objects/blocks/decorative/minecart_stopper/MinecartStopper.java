package net.dark_roleplay.medieval.common.objects.blocks.decorative.minecart_stopper;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.objects.blocks.templates.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MinecartStopper extends FacedBlock{

	public MinecartStopper(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(3F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	protected static void addCollisionBoxToList(BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable AxisAlignedBB blockBox){
        if (blockBox != NULL_AABB){
            AxisAlignedBB axisalignedbb = blockBox.offset(pos);

            if (entityBox.intersects(axisalignedbb)){
                collidingBoxes.add(axisalignedbb);
            }
        }
    }
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collisionBoxes, @Nullable Entity entity, boolean stuff){
		Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, FULL_BLOCK_AABB);;
		
		if(entity instanceof EntityMinecart){
			Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, new AxisAlignedBB(-0.3F, 0F, -0.25F, 1.3F, 1F, 1.3F));
		}
	}
}

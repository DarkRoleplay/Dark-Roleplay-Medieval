package net.dark_roleplay.medieval.common.blocks;

import javax.annotation.Nullable;

import net.dark_roleplay.drpcore.common.DarkRoleplayCore;
import net.dark_roleplay.drpcore.common.handler.DRPCoreGuis;
import net.dark_roleplay.medieval.common.blocks.templates.DRPMedievalMaterials;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityMortar;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Upstream extends Block{

	public Upstream(String registryName) {
		super(Material.GLASS);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(0F);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos){
        return NULL_AABB;
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity){
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			if(player.isElytraFlying() && player.getPitchYaw().x < 60 && player.getPitchYaw().x > -60){
				entity.motionY += 0.1 * Math.pow(Math.E, -entity.motionY - 1.0);
				System.out.println(entity.motionY);

			}
		}
    }
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.INVISIBLE;
	}
	
	// -------------------------------------------------- Block Placement --------------------------------------------------

	// -------------------------------------------------- Block Events --------------------------------------------------

}

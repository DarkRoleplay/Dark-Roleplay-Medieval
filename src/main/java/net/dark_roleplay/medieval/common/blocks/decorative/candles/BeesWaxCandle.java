package net.dark_roleplay.medieval.common.blocks.decorative.candles;

import java.util.Random;

import elucent.albedo.lighting.ILightProvider;
import elucent.albedo.lighting.Light;
import net.dark_roleplay.medieval.common.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BeesWaxCandle extends Block{
	
	public BeesWaxCandle(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setSoundType(SoundType.CLOTH);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand){
		if(!state.getValue(BlockProperties.LIT))
			return;

		double d0 = pos.getX() + 0.5D;
		double d1 = pos.getY() + 0.65D;
		double d2 = pos.getZ() + 0.5D;

		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0095D, 0.0D);
		world.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean lit = state.getValue(BlockProperties.LIT);
			if(!lit && player.getHeldItem(hand).getItem() == Items.FLINT_AND_STEEL){
				world.setBlockState(pos, state.withProperty(BlockProperties.LIT, true));
				player.getHeldItem(hand).damageItem(1, player);
				return true;
			}else if(lit && player.getHeldItem(hand).isEmpty() && player.isSneaking()){
				world.setBlockState(pos, state.withProperty(BlockProperties.LIT, false));
				return true;
			}
		}
		if(player.getHeldItem(hand).getItem() == Items.FLINT_AND_STEEL){
			return true;
		}
		return true;
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 0.5F, 0.625F);
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
    public int getLightValue(IBlockState state){
		return state.getValue(BlockProperties.LIT) ? 15 : 0;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockProperties.LIT, meta == 1 ? true : false);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockProperties.LIT) ? 1 : 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockProperties.LIT});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(BlockProperties.LIT, false);
    }
}
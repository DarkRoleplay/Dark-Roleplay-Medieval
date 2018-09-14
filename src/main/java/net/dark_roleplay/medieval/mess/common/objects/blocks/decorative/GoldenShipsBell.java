package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalSounds;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GoldenShipsBell extends Block {

	public GoldenShipsBell(String registryName) {
		super(Material.IRON);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(2F);
		this.setSoundType(SoundType.ANVIL);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.25F, 0.4375F, 0.25F, 0.75F, 1F, 0.75F);
    }

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){
		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		if(!world.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN, true)) return Blocks.AIR.getDefaultState();
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		worldIn.playSound(player, pos, DRPMedievalSounds.SHIPS_BELL, SoundCategory.BLOCKS, 1F, 1.1F);
		return true;
	}
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity){
		worldIn.playSound(null, pos, DRPMedievalSounds.SHIPS_BELL, SoundCategory.BLOCKS, 1F, 1.1F);
	}

}


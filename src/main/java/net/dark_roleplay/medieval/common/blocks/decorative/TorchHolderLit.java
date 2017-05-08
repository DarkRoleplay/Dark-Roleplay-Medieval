package net.dark_roleplay.medieval.common.blocks.decorative;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.util.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TorchHolderLit extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static PropertyBool AddonLighter = PropertyBool.create("addonlighter");
	public static PropertyBool AddonTrap = PropertyBool.create("addontrap");
	public static final PropertyBool POWERED = PropertyBool.create("powered");

	public TorchHolderLit(String registryName) {
		super(Material.IRON);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);	
		this.setLightLevel(1F);
	}

	// -------------------------------------------------- Redstone --------------------------------------------------

	@Override
	public int getWeakPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){

		return state.getValue(TorchHolderLit.POWERED).booleanValue() ? 15 : 0;
	}
	
	@Override
	public int getStrongPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
		EnumFacing Facing = EnumFacing.SOUTH;
		Facing = (state.getValue(TorchHolderLit.FACING));

		return !state.getValue(TorchHolderLit.POWERED).booleanValue() ? 0 : (Facing == side ? 15 : 0);
	}

	@Override
    public boolean canProvidePower(IBlockState state)
    {
       return false;
    }

	// -------------------------------------------------- Rendering Stuff --------------------------------------------------
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand){

		EnumFacing enumfacing = state.getValue(TorchHolderLit.FACING);
		double d0 = pos.getX() + 0.5D;
		double d1 = pos.getY() + 0.55D;
		double d2 = pos.getZ() + 0.5D;
		double d3 = 0.26D;
		double d4 = 0.25D;

		EnumFacing enumfacing1 = enumfacing.getOpposite();
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + (d4 * enumfacing1.getFrontOffsetX()), d1 + d3, d2 + (d4 * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D, new int[0]);
		world.spawnParticle(EnumParticleTypes.FLAME, d0 + (d4 * enumfacing1.getFrontOffsetX()), d1 + d3, d2 + (d4 * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D, new int[0]);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(state.getValue(TorchHolderLit.FACING) == EnumFacing.NORTH)
			return new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F);
		else if( state.getValue(TorchHolderLit.FACING) == EnumFacing.EAST )
			return new AxisAlignedBB(0.0F, 0.2F, 0.375F, 0.25F, 0.8F, 0.625F);
		else if( state.getValue(TorchHolderLit.FACING) == EnumFacing.SOUTH )
			return new AxisAlignedBB(0.375F, 0.2F, 0.0F, 0.625F, 0.8F, 0.25F);
		else if( state.getValue(TorchHolderLit.FACING) == EnumFacing.WEST )
			return new AxisAlignedBB(0.75F, 0.2F, 0.375F, 1.0F, 0.8F, 0.625F);
		return null;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		int i = meta;
		if(i < 4){
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.EAST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.WEST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.SOUTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		}
		else if((i >= 4) && (i < 8)){
			i -= 4;
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH).withProperty(TorchHolderLit.AddonLighter, true).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.EAST).withProperty(TorchHolderLit.AddonLighter, true).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.WEST).withProperty(TorchHolderLit.AddonLighter, true).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.SOUTH).withProperty(TorchHolderLit.AddonLighter, true).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		}
		else if((i >= 8) && (i < 12)){
			i -= 8;
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.EAST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.WEST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.SOUTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, false);
		}
		else if(i >= 12){
			i -= 12;
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, true);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.EAST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, true);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.WEST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, true);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.SOUTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, true).withProperty(TorchHolderLit.POWERED, true);
		}

		return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;
		if(state.getValue(TorchHolderLit.FACING).equals(EnumFacing.NORTH)) {
			i += 0;
		} else if(state.getValue(TorchHolderLit.FACING).equals(EnumFacing.EAST)) {
			i += 1;
		} else if(state.getValue(TorchHolderLit.FACING).equals(EnumFacing.SOUTH)) {
			i += 2;
		} else if(state.getValue(TorchHolderLit.FACING).equals(EnumFacing.WEST)) {
			i += 3;
		}
		if(state.getValue(TorchHolderLit.AddonLighter)){
			i += 4;
		}
		else if(state.getValue(TorchHolderLit.AddonTrap)){
			i += 8;
			if(state.getValue(TorchHolderLit.POWERED)){
				i = i + 4;
			}
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {TorchHolderLit.FACING, TorchHolderLit.AddonLighter, TorchHolderLit.AddonTrap, TorchHolderLit.POWERED});
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

		EnumFacing enumfacing = state.getValue(TorchHolderLit.FACING);
		if(!this.canBlockStay(worldIn, pos, enumfacing)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return;
		}

		if(state.getValue(TorchHolderLit.AddonLighter)){
			if(!worldIn.isRemote){
				if(worldIn.isBlockPowered(pos)){
					worldIn.setBlockState(pos, DRPMedievalBlocks.TORCH_HOLDER_UNLIT.getDefaultState().withProperty(TorchHolderLit.FACING, state.getValue(TorchHolderLit.FACING)).withProperty(TorchHolderLit.AddonLighter, state.getValue(TorchHolderLit.AddonLighter)).withProperty(TorchHolderLit.AddonTrap, state.getValue(TorchHolderLit.AddonTrap)).withProperty(TorchHolderLit.POWERED, state.getValue(TorchHolderLit.POWERED)), 2);
				}
			}
		}
	}
	
	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {

		return worldIn.isSideSolid(pos.west(), EnumFacing.EAST, true) || worldIn.isSideSolid(pos.east(), EnumFacing.WEST, true) || worldIn.isSideSolid(pos.north(), EnumFacing.SOUTH, true) || worldIn.isSideSolid(pos.south(), EnumFacing.NORTH, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if(!worldIn.isRemote){
			worldIn.setBlockState(pos, state.withProperty(TorchHolderLit.POWERED, Boolean.valueOf(false)), 3);
			worldIn.notifyNeighborsOfStateChange(pos, this, false);
			//TODO PLAY SOUND
			//worldIn.playSoundEffect((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean) state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
			EnumFacing Facing = state.getValue(TorchHolderLit.FACING);
			worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()), state.getBlock(),false);
		}

	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

		if(!world.isRemote){
			if(player.getHeldItem(EnumHand.MAIN_HAND) == null){
				if(state.getValue(TorchHolderLit.AddonTrap) && !(Boolean) state.getValue(TorchHolderLit.POWERED)){
					state = state.cycleProperty(TorchHolderLit.POWERED);
					world.setBlockState(pos, state, 3);
					world.scheduleUpdate(pos, this, 60);
					world.scheduleUpdate(pos, DRPMedievalBlocks.TORCH_HOLDER_UNLIT, 60);
					//TODO PLAY SOUND
					//worldIn.playSoundEffect((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean) state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);

					EnumFacing Facing = state.getValue(TorchHolderLit.FACING);

					world.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()), state.getBlock(), false);

				}
			}
			else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(DRPMedievalItems.TriggerTrap)){
				if(state.getValue(TorchHolderLit.AddonLighter)){
					state = state.cycleProperty(TorchHolderLit.AddonLighter);
					state = state.cycleProperty(TorchHolderLit.AddonTrap);
					world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
					world.setBlockState(pos, state, 3);
					if(!player.capabilities.isCreativeMode) {
						player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.TriggerTrap,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					}
				}
				else if(state.getValue(TorchHolderLit.AddonTrap)){

				}
				else{
					state = state.cycleProperty(TorchHolderLit.AddonTrap);
					world.setBlockState(pos, state, 3);
					if(!player.capabilities.isCreativeMode) {
						player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.TriggerTrap,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					}
				}
			}
			else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Items.FLINT)){
				if(state.getValue(TorchHolderLit.AddonTrap)){
					world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TriggerTrap, 1)));
					state = state.cycleProperty(TorchHolderLit.AddonTrap);
					state = state.cycleProperty(TorchHolderLit.AddonLighter);
					world.setBlockState(pos, state, 3);
					if(!player.capabilities.isCreativeMode) {
						player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					}
				}
				else if(state.getValue(TorchHolderLit.AddonLighter)){

				}
				else{
					state = state.cycleProperty(TorchHolderLit.AddonLighter);
					world.setBlockState(pos, state, 3);
					if(!player.capabilities.isCreativeMode) {
						player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					}}
			}
			else{
				if(player.isSneaking()){
					world.setBlockState(pos, DRPMedievalBlocks.TORCH_HOLDER_UNLIT.getDefaultState().withProperty(TorchHolderLit.FACING, state.getValue(TorchHolderLit.FACING)).withProperty(TorchHolderLit.AddonLighter, state.getValue(TorchHolderLit.AddonLighter)).withProperty(TorchHolderLit.AddonTrap, state.getValue(TorchHolderLit.AddonTrap)).withProperty(TorchHolderLit.POWERED, state.getValue(TorchHolderLit.POWERED)));
				}
				else if(state.getValue(TorchHolderLit.AddonTrap) && !(Boolean) state.getValue(TorchHolderLit.POWERED)){
					state = state.cycleProperty(TorchHolderLit.POWERED);
					world.setBlockState(pos, state, 3);
					world.scheduleUpdate(pos, this, 60);
					world.scheduleUpdate(pos, DRPMedievalBlocks.TORCH_HOLDER_UNLIT, 60);
					//TODO PLAY SOUND
					//worldIn.playSoundEffect((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean) state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);

					EnumFacing Facing = state.getValue(TorchHolderLit.FACING);

					world.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()), state.getBlock(),false);

				}
			}
			return true;
		}
		return true;
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

		if(facing.equals(EnumFacing.SOUTH))
			return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.SOUTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		else if(facing.equals(EnumFacing.WEST))
			return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.WEST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		else if(facing.equals(EnumFacing.NORTH))
			return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.NORTH).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		else if(facing.equals(EnumFacing.EAST))
			return this.getDefaultState().withProperty(TorchHolderLit.FACING, EnumFacing.EAST).withProperty(TorchHolderLit.AddonLighter, false).withProperty(TorchHolderLit.AddonTrap, false).withProperty(TorchHolderLit.POWERED, false);
		else
			return Blocks.AIR.getDefaultState();
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
		if(!world.isRemote){
			if(state.getValue(TorchHolderLit.AddonLighter)){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
			}
			if(state.getValue(TorchHolderLit.AddonTrap)){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TriggerTrap, 1)));
			}
		}
    }

}

package net.dark_roleplay.medieval.common.blocks.decorative;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TorchHolderEmpty extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static PropertyBool AddonLighter = PropertyBool.create("addonlighter");
	public static PropertyBool AddonTrap = PropertyBool.create("addontrap");

	public TorchHolderEmpty(String registryName) {
		super(Material.IRON);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
		this.setDefaultState(this.getDefaultState().withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, false));
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(state.getValue(TorchHolderEmpty.FACING) == EnumFacing.NORTH)
			return new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F);
		else if( state.getValue(TorchHolderEmpty.FACING) == EnumFacing.EAST )
			return new AxisAlignedBB(0.0F, 0.2F, 0.375F, 0.25F, 0.8F, 0.625F);
		else if( state.getValue(TorchHolderEmpty.FACING) == EnumFacing.SOUTH )
			return new AxisAlignedBB(0.375F, 0.2F, 0.0F, 0.625F, 0.8F, 0.25F);
		else if( state.getValue(TorchHolderEmpty.FACING) == EnumFacing.WEST )
			return new AxisAlignedBB(0.75F, 0.2F, 0.375F, 1.0F, 0.8F, 0.625F);
		return null;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		int i = meta;
		if(i < 4){
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.NORTH).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.EAST).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.WEST).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.SOUTH).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, false);
		}
		else if((i >= 4) && (i < 8)){
			i -= 4;
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.NORTH).withProperty(TorchHolderEmpty.AddonLighter, true).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.EAST).withProperty(TorchHolderEmpty.AddonLighter, true).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.WEST).withProperty(TorchHolderEmpty.AddonLighter, true).withProperty(TorchHolderEmpty.AddonTrap, false);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.SOUTH).withProperty(TorchHolderEmpty.AddonLighter, true).withProperty(TorchHolderEmpty.AddonTrap, false);
		}
		else if((i >= 8) && (i < 12)){
			i -= 8;
			if(i == 0)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.NORTH).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, true);
			else if(i == 1)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.EAST).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, true);
			else if(i == 2)
				return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.WEST).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, true);
			else if(i == 3) return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.SOUTH).withProperty(TorchHolderEmpty.AddonLighter, false).withProperty(TorchHolderEmpty.AddonTrap, true);
		}

		return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.NORTH);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;
		if(state.getValue(TorchHolderEmpty.FACING).equals(EnumFacing.NORTH)) {
			i += 0;
		} else if(state.getValue(TorchHolderEmpty.FACING).equals(EnumFacing.EAST)) {
			i += 1;
		} else if(state.getValue(TorchHolderEmpty.FACING).equals(EnumFacing.SOUTH)) {
			i += 2;
		} else if(state.getValue(TorchHolderEmpty.FACING).equals(EnumFacing.WEST)) {
			i += 3;
		}
		if(state.getValue(TorchHolderEmpty.AddonLighter)){
			i += 4;
		}
		else if(state.getValue(TorchHolderEmpty.AddonTrap)){
			i += 8;
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {TorchHolderEmpty.FACING, TorchHolderEmpty.AddonLighter, TorchHolderEmpty.AddonTrap});
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

		EnumFacing enumfacing = state.getValue(TorchHolderEmpty.FACING);
		if(!this.canBlockStay(worldIn, pos, enumfacing)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

		if(facing.equals(EnumFacing.SOUTH))
			return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.SOUTH);
		else if(facing.equals(EnumFacing.WEST))
			return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.WEST);
		else if(facing.equals(EnumFacing.NORTH))
			return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.NORTH);
		else if(facing.equals(EnumFacing.EAST))
			return this.getDefaultState().withProperty(TorchHolderEmpty.FACING, EnumFacing.EAST);
		else
			return Blocks.AIR.getDefaultState();

	}

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

		if(!world.isRemote){
			if(player.getHeldItem(EnumHand.MAIN_HAND) != null){
				if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Item.getItemFromBlock(Blocks.TORCH))){
					world.setBlockState(pos, DRPMedievalBlocks.TORCH_HOLDER_UNLIT.getDefaultState().withProperty(TorchHolderEmpty.FACING, state.getValue(TorchHolderEmpty.FACING)).withProperty(TorchHolderEmpty.AddonLighter, state.getValue(TorchHolderEmpty.AddonLighter)).withProperty(TorchHolderEmpty.AddonTrap, state.getValue(TorchHolderEmpty.AddonLighter)).withProperty(TorchHolderUnlit.POWERED, false));
					//worldIn.markBlockForUpdate(pos);
					if(!player.capabilities.isCreativeMode) {
						player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Item.getItemFromBlock(Blocks.TORCH),  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					}
				}
				else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(DRPMedievalItems.TriggerTrap)){
					if(state.getValue(TorchHolderEmpty.AddonLighter)){
						state = state.cycleProperty(TorchHolderEmpty.AddonLighter);
						state = state.cycleProperty(TorchHolderEmpty.AddonTrap);
						world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) {
							player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.TriggerTrap,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
						}
					}
					else if(state.getValue(TorchHolderEmpty.AddonTrap)){

					}
					else{
						state = state.cycleProperty(TorchHolderEmpty.AddonTrap);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) {
							player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.TriggerTrap,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
						}
					}
				}
				else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Items.FLINT)){
					if(state.getValue(TorchHolderEmpty.AddonTrap)){
						world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TriggerTrap, 1)));
						state = state.cycleProperty(TorchHolderEmpty.AddonTrap);
						state = state.cycleProperty(TorchHolderEmpty.AddonLighter);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) {
							player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
						}
					}
					else if(state.getValue(TorchHolderEmpty.AddonLighter)){}
					else{
						state = state.cycleProperty(TorchHolderEmpty.AddonLighter);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) {
							player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
						}
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
		if(!world.isRemote){
			if(state.getValue(TorchHolderEmpty.AddonLighter)){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
			}
			if(state.getValue(TorchHolderEmpty.AddonTrap)){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TriggerTrap, 1)));
			}
		}
    }
}

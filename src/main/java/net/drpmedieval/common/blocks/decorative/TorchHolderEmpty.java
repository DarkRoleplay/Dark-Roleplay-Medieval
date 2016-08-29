package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.drpmedieval.common.util.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

	public TorchHolderEmpty() {
		super(DRPMedievalMaterials.iron);
		this.setRegistryName("TorchHolderEmpty");
		this.setUnlocalizedName("TorchHolderEmpty");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
		this.setDefaultState(this.getDefaultState().withProperty(AddonLighter, false).withProperty(AddonTrap, false));
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(state.getValue(FACING) == EnumFacing.NORTH){
			return new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F);
		}else if( state.getValue(FACING) == EnumFacing.EAST ){
			return new AxisAlignedBB(0.0F, 0.2F, 0.375F, 0.25F, 0.8F, 0.625F);
		}else if( state.getValue(FACING) == EnumFacing.SOUTH ){
			return new AxisAlignedBB(0.375F, 0.2F, 0.0F, 0.625F, 0.8F, 0.25F);
		}else if( state.getValue(FACING) == EnumFacing.WEST ){
			return new AxisAlignedBB(0.75F, 0.2F, 0.375F, 1.0F, 0.8F, 0.625F);
		}
		return null;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		int i = meta;
		if(i < 4){
			if(i == 0)
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, false);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false);
		}
		else if(i >= 4 && i < 8){
			i -= 4;
			if(i == 0)
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, true).withProperty(AddonTrap, false);
			else if(i == 1)
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, true).withProperty(AddonTrap, false);
			else if(i == 2)
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, true).withProperty(AddonTrap, false);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, true).withProperty(AddonTrap, false);
		}
		else if(i >= 8 && i < 12){
			i -= 8;
			if(i == 0)
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true);
			else if(i == 1)
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, true);
			else if(i == 2)
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, true);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true);
		}

		return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;
		if(state.getValue(FACING).equals(EnumFacing.NORTH))
			i += 0;
		else if(state.getValue(FACING).equals(EnumFacing.EAST))
			i += 1;
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH))
			i += 2;
		else if(state.getValue(FACING).equals(EnumFacing.WEST)) i += 3;
		if((Boolean) state.getValue(AddonLighter)){
			i += 4;
		}
		else if((Boolean) state.getValue(AddonTrap)){
			i += 8;
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING, AddonLighter, AddonTrap});
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){

		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		if(!this.canBlockStay(worldIn, pos, enumfacing)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(facing.equals(facing.SOUTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		else if(facing.equals(facing.WEST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		else if(facing.equals(facing.NORTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		else if(facing.equals(facing.EAST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		else
			return Blocks.AIR.getDefaultState();

	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(!world.isRemote){
			if(player.getHeldItem(EnumHand.MAIN_HAND) != null){
				if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Item.getItemFromBlock(Blocks.TORCH))){
					world.setBlockState(pos, DRPMedievalBlocks.torchHolderUnlit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(AddonLighter, state.getValue(AddonLighter)).withProperty(AddonTrap, state.getValue(AddonLighter)));
					//worldIn.markBlockForUpdate(pos);
					if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Item.getItemFromBlock(Blocks.TORCH),  player.inventory.mainInventory), 1);
				}
				else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(DRPMedievalItems.itemTriggerTrap)){
					if((Boolean) state.getValue(AddonLighter)){
						state = state.cycleProperty(AddonLighter);
						state = state.cycleProperty(AddonTrap);
						world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.itemTriggerTrap,  player.inventory.mainInventory), 1);
					}
					else if((Boolean) state.getValue(AddonTrap)){

					}
					else{
						state = state.cycleProperty(AddonTrap);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(DRPMedievalItems.itemTriggerTrap,  player.inventory.mainInventory), 1);
					}
				}
				else if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Items.FLINT)){
					if((Boolean) state.getValue(AddonTrap)){
						world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.itemTriggerTrap, 1)));
						state = state.cycleProperty(AddonTrap);
						state = state.cycleProperty(AddonLighter);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory), 1);
					}
					else if((Boolean) state.getValue(AddonLighter)){}
					else{
						state = state.cycleProperty(AddonLighter);
						world.setBlockState(pos, state, 3);
						if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.FLINT,  player.inventory.mainInventory), 1);
					}
				}
			}
		}
		return true;
	}
}

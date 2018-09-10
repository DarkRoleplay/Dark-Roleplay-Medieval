package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.wall_mounted;

import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.ADDON_LIGHTER;
import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.ADDON_TRAP;
import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.FACING;
import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.POWERED;

import java.util.List;
import java.util.Random;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class UnlitWallMount extends EmptyWallMount {


	@ObjectHolder("drpmedieval:trigger_trap")
	private static Item trap;
	
	@ObjectHolder("minecraft:flint")
	private static Item lighter;

	private Item emptyItem;
	private Block lit;
	private Item mountObject;
	
	public UnlitWallMount(String registryName, AxisAlignedBB bb) {
		super(registryName, bb); // new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F));
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = super.getStateFromMeta(meta);
		if(meta > 12)
			state = state.withProperty(POWERED, true);
		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = super.getMetaFromState(state);
		if(state.getValue(ADDON_LIGHTER) && state.getValue(POWERED))
				i += 8;
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, ADDON_LIGHTER, ADDON_TRAP, POWERED});
	}
	
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING, facing).withProperty(ADDON_TRAP, false).withProperty(ADDON_LIGHTER, false).withProperty(POWERED, false);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		EnumFacing enumfacing = state.getValue(FACING);
		if(!this.canBlockStay(world, pos, enumfacing)){
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
			this.spawnAddons(world, pos, state);
		}else if(state.getValue(ADDON_LIGHTER) && world.isBlockPowered(fromPos)){
			world.setBlockState(pos, this.lit.getDefaultState()
				.withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_TRAP, state.getValue(ADDON_TRAP))
				.withProperty(ADDON_LIGHTER, state.getValue(ADDON_LIGHTER)).withProperty(POWERED, state.getValue(POWERED))
			);
		}
		
		super.neighborChanged(state, world, pos, block, fromPos);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean hasTrap = state.getValue(ADDON_TRAP);
			boolean hasLighter = state.getValue(ADDON_LIGHTER);
			ItemStack heldStack = player.getHeldItem(hand);
			
			if(heldStack.isEmpty()){
				if(hasTrap){
					state = state.cycleProperty(POWERED);
					world.setBlockState(pos, state, 3);
					world.scheduleUpdate(pos, this, 60);
					world.scheduleUpdate(pos, this.lit, 60);
					world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1F, 1F, true);
					world.notifyNeighborsOfStateChange(pos.offset(state.getValue(FACING).getOpposite()), state.getBlock(),false);
				}else if(hasLighter){
					
				}
			}else if(heldStack.getItem() == this.trap && !hasTrap){
				player.getHeldItem(hand).shrink(1);
				spawnAddons(world, pos, state);
				world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, true));
			}else if(heldStack.getItem() == this.lighter && !hasTrap){
				player.getHeldItem(hand).shrink(1);
				spawnAddons(world, pos, state);
				world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_LIGHTER, true).withProperty(ADDON_TRAP, false));
			}else if(heldStack.getItem() == Items.FLINT_AND_STEEL){
				player.getHeldItem(hand).attemptDamageItem(1, new Random(), (EntityPlayerMP) player);
				world.setBlockState(pos, this.lit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_LIGHTER, state.getValue(ADDON_LIGHTER)).withProperty(ADDON_TRAP, state.getValue(ADDON_TRAP)).withProperty(POWERED, state.getValue(POWERED)));
			}
		}
		return true;
	}
	
	@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
		NonNullList<ItemStack> stacks = NonNullList.create();
		
		if(state.getValue(ADDON_LIGHTER)){
			stacks.add(new ItemStack(Items.FLINT, 1));
		}
		if(state.getValue(ADDON_TRAP)){
			stacks.add(new ItemStack(DRPMedievalItems.TRIGGER_TRAP, 1));
		}
		
		stacks.add(new ItemStack(emptyItem == null ? emptyItem = Item.getByNameOrId(this.getRegistryName().toString().replace("_unlit", "_empty")) : emptyItem));
		stacks.add(new ItemStack(this.mountObject));

		return stacks;
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if(!world.isRemote){
			world.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(false)), 3);
			world.notifyNeighborsOfStateChange(pos, this, false);
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1F, 1F, true);
			EnumFacing Facing = state.getValue(FACING);
			world.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()), state.getBlock(),false);
		}

	}
	
	@Override
	public int getWeakPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
		return state.getValue(POWERED).booleanValue() ? 15 : 0;
	}
	
	@Override
	public int getStrongPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
		EnumFacing Facing = EnumFacing.SOUTH;
		Facing = (state.getValue(FACING));
		return !state.getValue(POWERED).booleanValue() ? 0 : (Facing == side ? 15 : 0);
	}

	public void init(Block lit, Item mountObject){
		this.lit = lit;
		this.mountObject = mountObject;
	}
}
package net.dark_roleplay.medieval.common.objects.blocks.decorative.wall_mounted;

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
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class EmptyWallMount extends WallMounted {

	public static PropertyBool ADDON_LIGHTER = PropertyBool.create("addon_lighter");
	public static PropertyBool ADDON_TRAP = PropertyBool.create("addon_trap");

	@ObjectHolder("drpmedieval:trigger_trap")
	private static Item trap;
	
	@ObjectHolder("minecraft:flint")
	private static Item lighter;
	
	private Block unlit;
	private Item mountObject;
	
	public EmptyWallMount(String registryName, AxisAlignedBB bb) {
		super(registryName, Material.IRON, bb);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
		this.setDefaultState(this.getDefaultState().withProperty(EmptyWallMount.ADDON_LIGHTER, false).withProperty(EmptyWallMount.ADDON_TRAP, false));
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = super.getStateFromMeta(meta % 4);
		if(meta > 3 && meta < 8){
			return state.withProperty(ADDON_LIGHTER, true).withProperty(ADDON_TRAP, false);
		}else if(meta >= 8){
			return state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, true);
		}else{
			return state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, false);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = super.getMetaFromState(state);
		if(state.getValue(EmptyWallMount.ADDON_LIGHTER)){
			i += 4;
		}
		else if(state.getValue(EmptyWallMount.ADDON_TRAP)){
			i += 8;
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, EmptyWallMount.ADDON_LIGHTER, EmptyWallMount.ADDON_TRAP});
	}
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING, facing).withProperty(ADDON_TRAP, false).withProperty(ADDON_LIGHTER, false);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean consumeItems = player.capabilities.isCreativeMode;
			boolean hasTrap = state.getValue(ADDON_TRAP);
			boolean hasLighter = state.getValue(ADDON_LIGHTER);
			ItemStack heldStack = player.getHeldItem(hand);
			
			if(heldStack.isEmpty()){
				if(hasTrap){
					
				}else if(hasLighter){
					
				}
			}else if(heldStack.getItem() == this.trap && !hasTrap){
				if(consumeItems){
					player.getHeldItem(hand).shrink(1);
					spawnAddons(world, pos, state);
				}
				world.setBlockState(pos, state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, true));
			}else if(heldStack.getItem() == this.lighter && !hasTrap){
				if(consumeItems){
					player.getHeldItem(hand).shrink(1);
					spawnAddons(world, pos, state);
				}
				world.setBlockState(pos, state.withProperty(ADDON_LIGHTER, true).withProperty(ADDON_TRAP, false));
			}else if(heldStack.getItem() == mountObject){
				if(!consumeItems){
					player.getHeldItem(hand).shrink(1);
				}
				world.setBlockState(pos, this.unlit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_LIGHTER, state.getValue(ADDON_LIGHTER)).withProperty(ADDON_TRAP, state.getValue(ADDON_TRAP)).withProperty(UnlitWallMount.POWERED, false));
			}
		}
		return true;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		EnumFacing enumfacing = state.getValue(FACING);
		if(!this.canBlockStay(world, pos, enumfacing)){
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
			this.spawnAddons(world, pos, state);
		}
		super.neighborChanged(state, world, pos, block, fromPos);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
		if(!world.isRemote){
			spawnAddons(world, pos, state);
		}
    }
	
	public void init(Block unlit, Item mountObject){
		this.unlit = unlit;
		this.mountObject = mountObject;
	}
	
	public void spawnAddons(World world, BlockPos pos, IBlockState state){
		if(state.getValue(EmptyWallMount.ADDON_LIGHTER)){
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
		}
		if(state.getValue(EmptyWallMount.ADDON_TRAP)){
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TRIGGER_TRAP, 1)));
		}
	}
}

package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.wall_mounted;

import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.*;

import java.util.List;
import java.util.Random;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LitWallMount extends EmptyWallMount {

	@ObjectHolder("drpmedieval:trigger_trap")
	private static Item trap;
	
	@ObjectHolder("minecraft:flint")
	private static Item lighter;
	
	private Item emptyItem;
	private Block unlit;
	private Item mountObject;
	
	private double centerOffset;
	private double centerOffsetPowered;
	private double yOffset;
	
	public LitWallMount(String registryName, AxisAlignedBB bb, double centerOffset, double yOffset) {
		super(registryName, bb); // new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F));
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setLightLevel(0.9375F);
//		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
		this.setDefaultState(this.getDefaultState().withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, false));
		this.centerOffset = centerOffset;		
		this.centerOffsetPowered = centerOffset - 0.275F;
		this.yOffset = yOffset;
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand){
		EnumFacing enumfacing = state.getValue(FACING);
		double offsetX = pos.getX() + 0.5D;
		double offsetY = pos.getY() + this.yOffset;
		double offsetZ = pos.getZ() + 0.5D;

		boolean powered = state.getValue(POWERED);
		
		EnumFacing enumfacing1 = enumfacing.getOpposite();
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, offsetX + ((powered ? this.centerOffsetPowered : this.centerOffset) * enumfacing1.getFrontOffsetX()), offsetY - (powered ? 0.15f : 0), offsetZ + ((powered ? this.centerOffsetPowered : this.centerOffset) * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D); 
		world.spawnParticle(EnumParticleTypes.FLAME, 		offsetX + ((powered ? this.centerOffsetPowered : this.centerOffset) * enumfacing1.getFrontOffsetX()), offsetY - (powered ? 0.15f : 0), offsetZ + ((powered ? this.centerOffsetPowered : this.centerOffset) * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = super.getStateFromMeta(meta % 4);
		if(meta > 3 && meta < 8){
			return state.withProperty(ADDON_LIGHTER, true).withProperty(ADDON_TRAP, false).withProperty(POWERED, false);
		}else if(meta > 7 && meta < 12){
			return state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, true).withProperty(POWERED, false);
		}else if(meta > 12){
			return state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, true).withProperty(POWERED, true);
		}else{
			return state.withProperty(ADDON_LIGHTER, false).withProperty(ADDON_TRAP, false).withProperty(POWERED, false);
		}
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
			world.setBlockState(pos, this.unlit.getDefaultState()
				.withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_TRAP, state.getValue(ADDON_TRAP))
				.withProperty(ADDON_LIGHTER, state.getValue(ADDON_LIGHTER)).withProperty(POWERED, state.getValue(POWERED))
			);
		}
		super.neighborChanged(state, world, pos, block, fromPos);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean consumeItems = player.capabilities.isCreativeMode;
			boolean hasTrap = state.getValue(ADDON_TRAP);
			boolean hasLighter = state.getValue(ADDON_LIGHTER);
			ItemStack heldStack = player.getHeldItem(hand);
			
			if(heldStack.isEmpty()){
				if(hasTrap){
					state = state.cycleProperty(POWERED);
					world.setBlockState(pos, state, 3);
					world.scheduleUpdate(pos, this, 60);
					world.scheduleUpdate(pos, this.unlit, 60);
					world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1F, 1F, true);
					world.notifyNeighborsOfStateChange(pos.offset(state.getValue(FACING).getOpposite()), state.getBlock(),false);
				}else if(hasLighter){
					
				}else{
					if(player.isSneaking()){
						world.setBlockState(pos, this.unlit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ADDON_LIGHTER, state.getValue(ADDON_LIGHTER)).withProperty(ADDON_TRAP, state.getValue(ADDON_TRAP)).withProperty(POWERED, state.getValue(POWERED)));
					}
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
			}
		}
		return true;
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
		this.unlit = lit;
		this.mountObject = mountObject;
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
		
		stacks.add(new ItemStack(emptyItem == null ? emptyItem = Item.getByNameOrId(this.getRegistryName().toString().replace("_lit", "_empty")) : emptyItem));
		stacks.add(new ItemStack(this.mountObject));
		
		return stacks;
	}
	
	private Vec3d rotatePos(Vec3d pos, int amount){
		switch(amount){
			case 0://NORTH
				return pos;
			case 1://WEST
				return new Vec3d(1 - pos.z, pos.y, pos.x);
			case 2://SOUTH
				return new Vec3d(1 - pos.x, pos.y, 1 - pos.z);
			case 3://EAST 
				return new Vec3d(pos.z, pos.y, 1 - pos.x);
			default:
				return pos;
		}
	}
}
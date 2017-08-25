package net.dark_roleplay.medieval.common.blocks.decorative.wall_mounted;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LitWallMount extends WallMounted {

	public static final PropertyBool POWERED = PropertyBool.create("powered");

	@ObjectHolder("drpmedieval:trigger_trap")
	private static Item trap;
	
	@ObjectHolder("minecraft:flint")
	private static Item lighter;
	
	private Block unlit;
	
	private double centerOffset;
	private double yOffset;
	
	public LitWallMount(String registryName, AxisAlignedBB bb, double centerOffset, double yOffset) {
		super(registryName, Material.IRON, bb); // new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F));
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(4F);
		this.setLightLevel(0.9375F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
		this.setDefaultState(this.getDefaultState().withProperty(EmptyWallMount.ADDON_LIGHTER, false).withProperty(EmptyWallMount.ADDON_TRAP, false));
		this.centerOffset = centerOffset;
		this.yOffset = yOffset;
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand){
		EnumFacing enumfacing = state.getValue(FACING);
//		Vec3d offset = state.getValue(POWERED) ? particleOffsetPowered : particleOffset;
//		switch(enumfacing.getOpposite()){
//		case NORTH:
//			offset = rotatePos(offset, 0);
//			break;
//		case EAST:
//			offset = rotatePos(offset, 1);
//			break;
//		case SOUTH:
//			offset = rotatePos(offset, 2);
//			break;
//		case WEST:
//			offset = rotatePos(offset, 3);
//			break;
//		default:
//			break;
//		}
		double offsetX = pos.getX() + 0.5D;
		double offsetY = pos.getY() + this.yOffset;
		double offsetZ = pos.getZ() + 0.5D;

		EnumFacing enumfacing1 = enumfacing.getOpposite();
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, offsetX + (this.centerOffset * enumfacing1.getFrontOffsetX()), offsetY, offsetZ + (this.centerOffset * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D); //d0 + (d4 * enumfacing1.getFrontOffsetX()), d1 + d3, d2 + (d4 * enumfacing1.getFrontOffsetZ())
		world.spawnParticle(EnumParticleTypes.FLAME, 		offsetX + (this.centerOffset * enumfacing1.getFrontOffsetX()), offsetY, offsetZ + (this.centerOffset * enumfacing1.getFrontOffsetZ()), 0.0D, 0.0D, 0.0D);//d0 + (d4 * enumfacing1.getFrontOffsetX()), d1 + d3, d2 + (d4 * enumfacing1.getFrontOffsetZ())
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return super.getStateFromMeta(meta % 4).withProperty(EmptyWallMount.ADDON_LIGHTER, (meta -= 4) > 0 ? true : false).withProperty(EmptyWallMount.ADDON_TRAP, (meta -= 4) > 0 ? true : false).withProperty(POWERED , (meta -= 4) > 0 ? true : false);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = super.getMetaFromState(state);
		if(state.getValue(EmptyWallMount.ADDON_LIGHTER)){
			i += 4;
		}
		else if(state.getValue(EmptyWallMount.ADDON_TRAP)){
			i += 8;
			if(state.getValue(UnlitWallMount.POWERED)){
				i += 4;
			}
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, EmptyWallMount.ADDON_LIGHTER, EmptyWallMount.ADDON_TRAP, POWERED});
	}
	
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING, facing).withProperty(EmptyWallMount.ADDON_TRAP, false).withProperty(EmptyWallMount.ADDON_LIGHTER, false).withProperty(POWERED, false);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean consumeItems = player.capabilities.isCreativeMode;
			boolean hasTrap = state.getValue(EmptyWallMount.ADDON_TRAP);
			boolean hasLighter = state.getValue(EmptyWallMount.ADDON_LIGHTER);
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
						world.setBlockState(pos, this.unlit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(EmptyWallMount.ADDON_LIGHTER, state.getValue(EmptyWallMount.ADDON_LIGHTER)).withProperty(EmptyWallMount.ADDON_TRAP, state.getValue(EmptyWallMount.ADDON_TRAP)).withProperty(UnlitWallMount.POWERED, state.getValue(UnlitWallMount.POWERED)));
					}
				}
			}else if(heldStack.getItem() == this.trap && !hasTrap){
				if(consumeItems){
					player.getHeldItem(hand).shrink(1);
					spawnAddons(world, pos, state);
				}
				world.setBlockState(pos, state.withProperty(EmptyWallMount.ADDON_LIGHTER, false).withProperty(EmptyWallMount.ADDON_TRAP, true));
			}else if(heldStack.getItem() == this.lighter && !hasTrap){
				if(consumeItems){
					player.getHeldItem(hand).shrink(1);
					spawnAddons(world, pos, state);
				}
				world.setBlockState(pos, state.withProperty(EmptyWallMount.ADDON_LIGHTER, true).withProperty(EmptyWallMount.ADDON_TRAP, false));
			}
		}
		return true;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
		if(!world.isRemote){
			spawnAddons(world, pos, state);
		}
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
	
	public void init(Block lit){
		this.unlit = lit;
	}
	
	public void spawnAddons(World world, BlockPos pos, IBlockState state){
		if(state.getValue(EmptyWallMount.ADDON_LIGHTER)){
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.FLINT, 1)));
		}
		if(state.getValue(EmptyWallMount.ADDON_TRAP)){
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.TRIGGER_TRAP, 1)));
		}
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
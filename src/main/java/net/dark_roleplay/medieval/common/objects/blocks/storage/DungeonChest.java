package net.dark_roleplay.medieval.common.objects.blocks.storage;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.gui.GuiHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DungeonChest extends FacedBlock {

	public DungeonChest(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(FACING) == EnumFacing.NORTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(FACING) == EnumFacing.EAST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		else if (state.getValue(FACING) == EnumFacing.SOUTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(FACING) == EnumFacing.WEST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		return null;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	protected ExtendedBlockState createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] { FACING, Properties.StaticProperty },
				new IUnlistedProperty[] { Properties.AnimationProperty });
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(Properties.StaticProperty, true);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		if (!world.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return Blocks.AIR.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TE_DungeonChest) {
			TE_DungeonChest chest = (TE_DungeonChest) tileentity;
			if(chest.isOpen() && !player.isSneaking()) {	
				if (!world.isRemote)
					player.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_GENERAL_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
			}else {
				((TE_DungeonChest) tileentity).click();	
				Minecraft.getMinecraft().world.playSound(pos, chest.isOpen() ? SoundEvents.BLOCK_CHEST_OPEN : SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 1F, 1F, true);
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TE_DungeonChest) {
			TE_DungeonChest tileentityChest = (TE_DungeonChest) tileEntity;
			ItemStackHandler handler = (ItemStackHandler) tileentityChest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			
			EntityItem entityItem;
			for(int i = 0; i < handler.getSlots(); i++) {
				ItemStack stack = handler.getStackInSlot(i);

				if(!stack.isEmpty()) {
					entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
					entityItem.setDefaultPickupDelay();
					worldIn.spawnEntity(entityItem);
				}
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TE_DungeonChest();
	}

}

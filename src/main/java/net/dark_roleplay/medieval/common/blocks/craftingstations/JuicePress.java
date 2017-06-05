package net.dark_roleplay.medieval.common.blocks.craftingstations;

import net.dark_roleplay.drpcore.common.DarkRoleplayCore;
import net.dark_roleplay.drpcore.common.handler.DRPCoreGuis;
import net.dark_roleplay.medieval.common.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JuicePress  extends FacedBlock {
	
	public static final PropertyBool TOP = PropertyBool.create("top");
	
	public JuicePress(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			player.openGui(DarkRoleplayCore.instance, DRPCoreGuis.DRPCORE_GUI_CRAFTING_RECIPESELECTION, player.world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		boolean top = (meta / 4) == 1 ? true : false;
		
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(JuicePress.TOP, top);
			case 1:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.EAST).withProperty(JuicePress.TOP, top);
			case 2:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.SOUTH).withProperty(JuicePress.TOP, top);
			case 3:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.WEST).withProperty(JuicePress.TOP, top);
			default:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(JuicePress.TOP, top);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int ret = state.getValue(JuicePress.TOP) ? 4 : 0;
		
		EnumFacing facing = state.getValue(BlockProperties.FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0 + ret;
		if(facing.equals(EnumFacing.EAST)) return 1 + ret;
		if(facing.equals(EnumFacing.SOUTH)) return 2 + ret;
		if(facing.equals(EnumFacing.WEST)) return 3 + ret;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {BlockProperties.FACING, JuicePress.TOP});
	}
}

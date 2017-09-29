package net.dark_roleplay.medieval.common.blocks.craftingstations.forge;

import net.dark_roleplay.drpcore.api.crafting.Crafting_Util;
import net.dark_roleplay.drpcore.client.gui.crafting.recipe_selection.RecipeSelection;
import net.dark_roleplay.medieval.client.gui.crafting.melting.MeltingOres;
import net.dark_roleplay.medieval.common.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Forge extends FacedBlock {

	public static final PropertyBool NORTH = PropertyBool.create("north");
	
	public Forge(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
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
	public IBlockState getStateFromMeta(int meta) {
		boolean north = false;
		if(meta > 3){
			north = true;
			meta -= 4;
		}
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(NORTH, north);
			case 1:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.EAST).withProperty(NORTH, north);
			case 2:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.SOUTH).withProperty(NORTH, north);
			case 3:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.WEST).withProperty(NORTH, north);
			default:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(NORTH, north);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		int i = state.getValue(NORTH) ? 4 : 0;
		
		EnumFacing facing = (EnumFacing) state.getValue(BlockProperties.FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0 + i;
		if(facing.equals(EnumFacing.EAST)) return 1 + i;
		if(facing.equals(EnumFacing.SOUTH)) return 2 + i;
		if(facing.equals(EnumFacing.WEST)) return 3 + i;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockProperties.FACING, NORTH});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(BlockProperties.FACING, placer.getHorizontalFacing().getOpposite()).withProperty(NORTH, true);
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			Minecraft.getMinecraft().displayGuiScreen(new MeltingOres());
		}
		return true;
	}
}
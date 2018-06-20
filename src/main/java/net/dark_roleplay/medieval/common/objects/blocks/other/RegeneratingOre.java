package net.dark_roleplay.medieval.common.objects.blocks.other;

import java.util.Random;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegeneratingOre extends Block{

	public static PropertyInteger AMOUNT = PropertyInteger.create("ore", 0, 15);;
	
	private float regenChance;
	private int maxOreAmount;
	
	public RegeneratingOre(String name,CreativeTabs tab, float regenChance, int maxOreAmount) {
		super(Material.ROCK);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);

		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
		this.setTickRandomly(true);
		
		this.regenChance = regenChance;
		this.maxOreAmount = maxOreAmount;
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
		return this.getDefaultState().withProperty(RegeneratingOre.AMOUNT, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return state.getValue(RegeneratingOre.AMOUNT).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {RegeneratingOre.AMOUNT});
	}
	
    @Override
	@Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {

		super.updateTick(world, pos, state, rand);

		int i = state.getValue(RegeneratingOre.AMOUNT).intValue();
		
		if((rand.nextFloat() < this.regenChance) && (i < this.maxOreAmount)){
			world.setBlockState(pos, state.withProperty(RegeneratingOre.AMOUNT, Integer.valueOf(i + 1)), 2);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(Blocks.IRON_ORE);
    }
	
    @Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
    	int i = state.getValue(RegeneratingOre.AMOUNT).intValue();
    	
    	if(i > 0) {
			world.setBlockState(pos, state.withProperty(RegeneratingOre.AMOUNT, Integer.valueOf(i - 1)), 2);
		}
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			player.openGui(DarkRoleplayMedieval.instance,net.dark_roleplay.medieval.common.gui.GuiHandler.GUI_MINIGAME_MUSIK,player.getEntityWorld(),pos.getX(),pos.getY(),pos.getZ());
		}
		return true;
	}
}

package net.drpmedieval.common.blocks.other;

import java.util.Random;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		return this.getDefaultState().withProperty(AMOUNT, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return ((Integer) state.getValue(AMOUNT)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {AMOUNT});
	}
	
    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {

		super.updateTick(world, pos, state, rand);

		int i = ((Integer) state.getValue(AMOUNT)).intValue();
		
		if(rand.nextFloat() < this.regenChance && i < maxOreAmount){
			world.setBlockState(pos, state.withProperty(AMOUNT, Integer.valueOf(i + 1)), 2);
		}
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(Blocks.IRON_ORE);
    }
	
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
    	int i = ((Integer) state.getValue(AMOUNT)).intValue();
    	
    	if(i > 0)
    		world.setBlockState(pos, state.withProperty(AMOUNT, Integer.valueOf(i - 1)), 2);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			player.openGui(DarkRoleplayMedieval.instance,net.drpmedieval.common.gui.GuiHandler.GUI_MINIGAME_MUSIK,player.getEntityWorld(),pos.getX(),pos.getY(),pos.getZ());
		}
		return true;
	}
}

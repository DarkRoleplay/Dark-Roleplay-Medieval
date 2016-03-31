package net.drpmedieval.common.blocks.craftingstations;

import java.util.Random;

import net.drpmedieval.common.blocks.tileentitys.TileEntityFirepit;
import net.drpmedieval.common.blocks.tileentitys.TileEntityRopeAnchor;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Firepit extends BlockContainer {

	public Firepit() {
		super(Material.wood);
		this.setLightLevel(0.93F);
		this.setUnlocalizedName("blockFirepit");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setBlockBounds(1.0F / 16F * 0F, 0.0F,
				1.0F / 16F * 0F, 1.0F / 16F * 16F, 1.0F / 16F * 10F,
				1.0F / 16F * 16F);
	}
	
	  @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
	    	Double x = (double) pos.getX()+0.25D;
	    	Double y = (double) pos.getY()+0.1D;
	    	Double z = (double) pos.getZ()+0.25D;
	    	for(int i = 0; i < 3; i++){
	    		worldIn.spawnParticle(EnumParticleTypes.FLAME, x + rand.nextDouble()/2, y + rand.nextDouble()/2, z+ rand.nextDouble()/2, 0.0D, 0.001D, 0.0D);
	    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + rand.nextDouble()/2, y + rand.nextDouble()/2, z+ rand.nextDouble()/2, 0.0D, 0.1D, 0.0D);
	    	}
	    }
	
		@Override
		public boolean isFullCube() {
			return false;
		}

		public boolean isSolidFullCube() {
			return false;
		}

		public boolean isOpaqueCube() {
			return false;
		}
		
	    //TODO 
	    public int getRenderType() {
			return -1;
		}
		
		@Override
		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityFirepit();
		}
}

package net.drpmedieval.common.blocks.decorative;

import java.util.Random;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TorchHolderUnlit extends Block{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static PropertyBool AddonLighter = PropertyBool.create("addonLighter");
	public static PropertyBool AddonTrap = PropertyBool.create("addonTrap");
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	
	
	public TorchHolderUnlit() {
		super(DRPMedievalMaterials.iron);
		this.setUnlocalizedName("blockTorchHolderUnlit");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos){
		 IBlockState iblockstate = worldIn.getBlockState(pos);
		 if (iblockstate.getBlock() == this){
			 if (iblockstate.getValue(FACING).equals(EnumFacing.NORTH))
            {
				 this.setBlockBounds(0.375F, 0.2F, 0.75F,  0.625F, 0.8F, 1.0F);
            }
			 else if(iblockstate.getValue(FACING).equals(EnumFacing.EAST))
			 {
				 this.setBlockBounds(0.0F, 0.2F, 0.375F, 0.25F, 0.8F, 0.625F);
			 }
			 else if(iblockstate.getValue(FACING).equals(EnumFacing.SOUTH))
			 {
				 this.setBlockBounds(0.375F, 0.2F, 0.0F,0.625F, 0.8F, 0.25F);
			 }
            else
            {              
                this.setBlockBounds(0.75F, 0.2F, 0.375F, 1.0F, 0.8F, 0.625F);
            }
		 }
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
		int i = meta;
		if(i < 4){
			if(i == 0) return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 1) return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 2) return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		}else if(i >= 4 && i < 8){
			i -= 4;
			if(i == 0) return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, true).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 1) return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, true).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 2) return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, true).withProperty(AddonTrap, false).withProperty(POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, true).withProperty(AddonTrap, false).withProperty(POWERED, false);
		}else if(i >= 8 && i < 12){
			i -= 8;
			if(i == 0) return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, false);
			else if(i == 1) return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, false);
			else if(i == 2) return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, false);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, false);
		}else if(i >= 12){
			i -= 12;
			if(i == 0) return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, true);
			else if(i == 1) return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, true);
			else if(i == 2) return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, true);
			else if(i == 3) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, true).withProperty(POWERED, true);
		}
		
		return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
    }
	
	public int getMetaFromState(IBlockState state)
    {
		int i = 0;
		if(state.getValue(FACING).equals(EnumFacing.NORTH)) i += 0;
		else if(state.getValue(FACING).equals(EnumFacing.EAST)) i += 1;
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH)) i += 2;
		else if(state.getValue(FACING).equals(EnumFacing.WEST)) i += 3;
		if((Boolean) state.getValue(AddonLighter))
		{
			i += 4;
		}else if((Boolean) state.getValue(AddonTrap)){
			i += 8;
			if((Boolean) state.getValue(POWERED)){
				i = i +4;
			}
		}
		return i;
    }
	
	 protected BlockState createBlockState()
	 {
		 return new BlockState(this, new IProperty[] {FACING,AddonLighter,AddonTrap,POWERED});
	 }
	    
	 public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	 {
		if(facing.equals(facing.SOUTH)) return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		else if(facing.equals(facing.WEST)) return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		else if(facing.equals(facing.NORTH)) return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		else if(facing.equals(facing.EAST)) return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		else return Blocks.air.getDefaultState();    
	 }
	    
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	    	if(!worldIn.isRemote){
	    		if(playerIn.getHeldItem() == null){
	    			if((Boolean)state.getValue(AddonTrap) && !(Boolean)state.getValue(POWERED)){
	    				state = state.cycleProperty(POWERED);
			            worldIn.setBlockState(pos, state, 3);
			            worldIn.scheduleUpdate(pos, this, 60);
			           worldIn.scheduleUpdate(pos, DRPMedievalBlocks.torchHolderLit, 60);
			            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    			
			            EnumFacing Facing = (EnumFacing) state.getValue(FACING);
				    	
				    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    			
	    			}
	    		}
	    		else if(playerIn.getHeldItem().getItem().equals(DRPMedievalItems.itemTriggerTrap)){
		    			if((Boolean)state.getValue(AddonLighter)){
		    				state = state.cycleProperty(AddonLighter);
		    				state = state.cycleProperty(AddonTrap);
		    				worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.flint,1)));
			    			worldIn.setBlockState(pos,state,3);
			    			playerIn.inventory.consumeInventoryItem(DRPMedievalItems.itemTriggerTrap);
		    			}else if((Boolean)state.getValue(AddonTrap)){
		    				
		    			}else{
		    				state = state.cycleProperty(AddonTrap);
			    			worldIn.setBlockState(pos,state,3);
			    			playerIn.inventory.consumeInventoryItem(DRPMedievalItems.itemTriggerTrap);
		    			}
		    	}
	    		else if(playerIn.getHeldItem().getItem().equals(Items.flint)){
	    			if((Boolean)state.getValue(AddonTrap)){
	    				worldIn.spawnEntityInWorld(new EntityItem(worldIn,pos.getX(),pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.itemTriggerTrap,1)));
	    				state = state.cycleProperty(AddonTrap);
	    				state = state.cycleProperty(AddonLighter);
	    				worldIn.setBlockState(pos, state,3);
	    				playerIn.inventory.consumeInventoryItem(Items.flint);
	    			}else if((Boolean)state.getValue(AddonLighter)){
	    				
	    			}else{
	    				state = state.cycleProperty(AddonLighter);
	    				worldIn.setBlockState(pos, state,3);
	    				playerIn.inventory.consumeInventoryItem(Items.flint);
	    			}
	    		}
	    		else if(playerIn.getHeldItem().getItem().equals(Items.flint_and_steel)){
	    			worldIn.setBlockState(pos, DRPMedievalBlocks.torchHolderLit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(AddonLighter, state.getValue(AddonLighter)).withProperty(AddonTrap, state.getValue(AddonTrap)).withProperty(POWERED, state.getValue(POWERED)));
	    			playerIn.getHeldItem().attemptDamageItem(1, new Random());
	    		}
	    		else{
	    			if((Boolean)state.getValue(AddonTrap) && !(Boolean)state.getValue(POWERED)){
	    				state = state.cycleProperty(POWERED);
			            worldIn.setBlockState(pos, state, 3);
			            worldIn.scheduleUpdate(pos, this, 60);
			           worldIn.scheduleUpdate(pos, DRPMedievalBlocks.torchHolderLit, 60);
			            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    			
			            EnumFacing Facing = (EnumFacing) state.getValue(FACING);
				    	
				    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    			
	    			}
	    		}
		    	return true;
	    	}
	    	return true;
	    }
	    
	    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	    	
	    	if(!worldIn.isRemote){
	    		worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(false)), 3);
	    		worldIn.notifyNeighborsOfStateChange(pos, this);
	    		 worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    		 EnumFacing Facing = (EnumFacing) state.getValue(FACING);
			    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    	}
	    	
	    }
		
	    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	    {
	    	EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	        if (!this.canBlockStay(worldIn, pos, enumfacing)){
	    		this.dropBlockAsItem(worldIn, pos, state, 0);
	    		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	    		return;
	    	}
	    	
	    	if((Boolean)state.getValue(AddonLighter)){
	    		 if (!worldIn.isRemote)
	 	        {
	 	            if (worldIn.isBlockPowered(pos))
	 	            {
	 	            	worldIn.setBlockState(pos, DRPMedievalBlocks.torchHolderLit.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(AddonLighter, state.getValue(AddonLighter)).withProperty(AddonTrap, state.getValue(AddonTrap)).withProperty(POWERED, state.getValue(POWERED)), 2);
	 	            }
	 	        }
	    	}
	    }
	    
	    public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	    {
	        return ((Boolean)state.getValue(POWERED)).booleanValue() ? 15 : 0;
	    }

	    public int isProvidingStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	    {
	    	EnumFacing Facing = EnumFacing.SOUTH;
	    	Facing =((EnumFacing) state.getValue(FACING));
	    			
	        return !((Boolean)state.getValue(POWERED)).booleanValue() ? 0 : (Facing == side ? 15 : 0);
	    }
	    
	    public boolean canProvidePower()
	    {
	        return true;
	    }
	    
	    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
	    {
	        return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	    }
		
	 public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		 return worldIn.isSideSolid(pos.west(), EnumFacing.EAST, true) ||
				 worldIn.isSideSolid(pos.east(), EnumFacing.WEST, true) ||
				 worldIn.isSideSolid(pos.north(), EnumFacing.SOUTH, true) ||
				 worldIn.isSideSolid(pos.south(), EnumFacing.NORTH, true);
	 }
	 
		@Override
		public boolean isFullCube()
	    {
	        return false;
	    }
	    
		@Override
	    public boolean isOpaqueCube()
		{
			return false;
		}
		
	    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	    {
	        this.setBlockBoundsBasedOnState(worldIn, pos);
	        return super.getCollisionBoundingBox(worldIn, pos, state);
	    }

	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
	    {
	        this.setBlockBoundsBasedOnState(worldIn, pos);
	        return super.getSelectedBoundingBox(worldIn, pos);
	    }
}


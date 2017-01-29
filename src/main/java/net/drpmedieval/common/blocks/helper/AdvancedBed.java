package net.drpmedieval.common.blocks.helper;

import net.drpmedieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.drpmedieval.common.capabilities.DRPMCapabilities;
import net.minecraft.block.BlockBed;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.SleepResult;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AdvancedBed extends BlockBed implements ITileEntityProvider{
	
    public static final PropertyEnum<EnumMattressType> MATTRESS = PropertyEnum.<EnumMattressType>create("mattress", EnumMattressType.class);
	
	public AdvancedBed(Material materialIn,String registreName,String unlocalizedName)
    {
        this(materialIn, materialIn.getMaterialMapColor());
        this.setRegistryName(registreName);
		this.setUnlocalizedName(unlocalizedName);
    }

    protected AdvancedBed(Material materialIn, MapColor color)
    {
        super();
        this.isBlockContainer = true;
    }

	// -------------------------------------------------- Block Data --------------------------------------------------

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
	@Override
	public boolean isBed(IBlockState state, IBlockAccess world, BlockPos pos, Entity player){
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, PART, OCCUPIED, MATTRESS});
    }
    
    @Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
    	EnumMattressType mattress = EnumMattressType.NONE;
		if(world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof BedFrameTileEntity){
			BedFrameTileEntity te = (BedFrameTileEntity) world.getTileEntity(pos);
			if(te.hasCapability(DRPMCapabilities.MATTRESS,null)){
				mattress =	te.getCapability(DRPMCapabilities.MATTRESS,null).getMattress();
			}
		}
		
		return state.withProperty(MATTRESS, mattress);
	}
	
	// -------------------------------------------------- Block Placement --------------------------------------------------

    
    protected boolean hasInvalidNeighbor(World worldIn, BlockPos pos)
    {
        return this.isInvalidNeighbor(worldIn, pos, EnumFacing.NORTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.SOUTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.WEST) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.EAST);
    }

    protected boolean isInvalidNeighbor(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.getBlockState(pos.offset(facing)).getMaterial() == Material.CACTUS;
    }
    
	// -------------------------------------------------- Block Events --------------------------------------------------

    /*if(world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof BedFrameTileEntity){
	BedFrameTileEntity te = (BedFrameTileEntity) world.getTileEntity(pos);
	if(te.hasCapability(DRPMCapabilities.MATTRESS,null)){
		te.getCapability(DRPMCapabilities.MATTRESS,null).setMattress(te.getCapability(DRPMCapabilities.MATTRESS,null).getMattress() + 1);
		System.out.println(te.getCapability(DRPMCapabilities.MATTRESS,null).getMattress());
	}
}*/
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }

    /**
     * Called on both Client and Server when World#addBlockEvent is called
     */
//    @Override
//    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
//    {
//        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
//        TileEntity tileentity = worldIn.getTileEntity(pos);
//        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
//    }
    
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BedFrameTileEntity();
	}
	
	// -------------------------------------------------- Bed Methods --------------------------------------------------
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            if (state.getValue(PART) != BlockBed.EnumPartType.HEAD)
            {
                pos = pos.offset((EnumFacing)state.getValue(FACING));
                state = worldIn.getBlockState(pos);

                if (state.getBlock() != this)
                {
                    return true;
                }
            }

            if (worldIn.provider.canRespawnHere() && worldIn.getBiomeForCoordsBody(pos) != Biomes.HELL)
            {
                if (((Boolean)state.getValue(OCCUPIED)).booleanValue())
                {
                    EntityPlayer entityplayer = this.getPlayerInBed(worldIn, pos);

                    if (entityplayer != null)
                    {
                        playerIn.sendMessage(new TextComponentTranslation("tile.bed.occupied", new Object[0]));
                        return true;
                    }

                    state = state.withProperty(OCCUPIED, Boolean.valueOf(false));
                    worldIn.setBlockState(pos, state, 4);
                }

                SleepResult entityplayer$enumstatus = playerIn.trySleep(pos);

                if (entityplayer$enumstatus == SleepResult.OK)
                {
                    state = state.withProperty(OCCUPIED, Boolean.valueOf(true));
                    worldIn.setBlockState(pos, state, 4);
                    return true;
                }
                else
                {
                    if (entityplayer$enumstatus == SleepResult.NOT_POSSIBLE_NOW)
                    {
                        playerIn.sendMessage(new TextComponentTranslation("tile.bed.noSleep", new Object[0]));
                    }
                    else if (entityplayer$enumstatus == SleepResult.NOT_SAFE)
                    {
                        playerIn.sendMessage(new TextComponentTranslation("tile.bed.notSafe", new Object[0]));
                    }

                    return true;
                }
            }
            else
            {
                worldIn.setBlockToAir(pos);
                BlockPos blockpos = pos.offset(((EnumFacing)state.getValue(FACING)).getOpposite());

                if (worldIn.getBlockState(blockpos).getBlock() == this)
                {
                    worldIn.setBlockToAir(blockpos);
                }

                worldIn.newExplosion((Entity)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, true);
                return true;
            }
        }
    }
	
    private EntityPlayer getPlayerInBed(World worldIn, BlockPos pos)
    {
        for (EntityPlayer entityplayer : worldIn.playerEntities)
        {
            if (entityplayer.isPlayerSleeping() && entityplayer.getPosition().equals(pos))
            {
                return entityplayer;
            }
        }

        return null;
    }
}

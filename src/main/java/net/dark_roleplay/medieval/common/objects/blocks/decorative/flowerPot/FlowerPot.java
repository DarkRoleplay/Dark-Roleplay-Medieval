package net.dark_roleplay.medieval.common.objects.blocks.decorative.flowerPot;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.TileEntity_FlowerStorage;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FlowerPot extends Block implements ITileEntityProvider{

    public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);

	//TODO ROTATION
	
	public static final PropertyInteger FLOWER1 = PropertyInteger.create("flower1", 0, 10);
	public static final PropertyInteger FLOWER2 = PropertyInteger.create("flower2", 0, 10);
	public static final PropertyInteger FLOWER3 = PropertyInteger.create("flower3", 0, 10);

	public FlowerPot(String registreName) {
		super(Material.WOOD);
		this.setRegistryName(registreName);
		this.setUnlocalizedName(registreName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F); 
		this.setSoundType(SoundType.WOOD);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS, FLOWER1, FLOWER2, FLOWER3});
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_FlowerStorage();
	}
	
	private TileEntity_FlowerStorage getTE(IBlockAccess world, BlockPos pos) {
	    return (TileEntity_FlowerStorage) world.getTileEntity(pos);
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(FLOWER1, getTE(world, pos).getFlower((byte)0)).withProperty(FLOWER2, getTE(world, pos).getFlower((byte)1)).withProperty(FLOWER3, getTE(world, pos).getFlower((byte)2));
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
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(AXIS, EnumAxis.X);
			case 1:
				return this.getDefaultState().withProperty(AXIS, EnumAxis.Z);
			default:
				return this.getDefaultState().withProperty(AXIS, EnumAxis.X);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		EnumAxis facing = (EnumAxis) state.getValue(AXIS);
		if(facing.equals(EnumAxis.X)) return 0;
		if(facing.equals(EnumAxis.Z)) return 1;

		return 0;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
    }
	
	// -------------------------------------------------- Rendering --------------------------------------------------

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer(){
		return BlockRenderLayer.CUTOUT;
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(AXIS, EnumAxis.X);
	    default:
	        return this.getDefaultState().withProperty(AXIS, EnumAxis.X);
		}
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = getTE(world, pos);

		if(tileEntity instanceof TileEntity_FlowerStorage){
			TileEntity_FlowerStorage tileEntityBucket = (TileEntity_FlowerStorage) tileEntity;
			for(int i = 0; i < 3; i++){
				ItemStack stack;
				switch(tileEntityBucket.getFlower((byte)i)){
				case 1:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.YELLOW_FLOWER));
					break;
				case 2:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,0);
					break;
				case 3:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,1);
					break;
				case 4:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,2);
					break;
				case 5:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,3);
					break;
				case 6:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,4);
					break;
				case 7:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,5);
					break;
				case 8:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,6);
					break;
				case 9:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,7);
					break;
				case 10:
					stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,8);
					break;
				default: 
					continue;	
				}
	            EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), stack);
	            world.spawnEntity(entityItem);
			}
		}

		super.breakBlock(world, pos, state);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

        	TileEntity_FlowerStorage te = getTE(world, pos);
            if (te.getFlower((byte) 2) == 0) {
                if (player.getHeldItem(hand) != null) {
                	if(player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.YELLOW_FLOWER)){
                		te.addFlower(1);
                        if (!world.isRemote){
                        	player.getHeldItem(hand).shrink(1);
                        	player.openContainer.detectAndSendChanges();
                        }
                	}else if(player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.RED_FLOWER)){
                		switch(player.getHeldItem(hand).getMetadata()){
                		case 0:
                			te.addFlower(2);
                			break;
                		case 1:
                			te.addFlower(3);
                			break;
                		case 2:
                			te.addFlower(4);
                			break;
                		case 3:
                			te.addFlower(5);
                			break;
                		case 4:
                			te.addFlower(6);
                			break;
                		case 5:
                			te.addFlower(7);
                			break;
                		case 6:
                			te.addFlower(8);
                			break;
                		case 7:
                			te.addFlower(9);
                			break;
                		case 8:
                			te.addFlower(10);
                			break;
                		default:
                			break;
                		}
	                		if (!world.isRemote){
	                        player.getHeldItem(hand).shrink(1);
	                        player.openContainer.detectAndSendChanges();
                		}
                	}
                }
            }
            if (player.getHeldItem(hand).getItem().getToolClasses(player.getHeldItem(hand)).contains("shovel")) {
            	 if(te.getFlower((byte) 2) != 0){
            		 if (!world.isRemote){
            			 giveItem(player, world,pos, (byte) te.getFlower((byte) 2));
	             		 player.getHeldItem(hand).damageItem(1, player);
            		 }
            		 te.removeFlower();
            	}else if(te.getFlower((byte) 1) != 0){
            		if (!world.isRemote){
            			giveItem(player, world,pos, (byte) te.getFlower((byte) 1));
	             		player.getHeldItem(hand).damageItem(1, player);
           		 	}
           		 	te.removeFlower();
            	}else if(te.getFlower((byte) 0) != 0){
            		if (!world.isRemote){
            			giveItem(player, world,pos, (byte) te.getFlower((byte) 0));
            			player.getHeldItem(hand).damageItem(1, player);
            		}
            		te.removeFlower();
            	}
            }
        return true;
    }
	
	public void giveItem(EntityPlayer player, World world, BlockPos pos, byte item){
		ItemStack stack;
		switch(item){
			case 1:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.YELLOW_FLOWER));
				break;
			case 2:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,0);
				break;
			case 3:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,1);
				break;
			case 4:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,2);
				break;
			case 5:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,3);
				break;
			case 6:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,4);
				break;
			case 7:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,5);
				break;
			case 8:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,6);
				break;
			case 9:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,7);
				break;
			case 10:
				stack = new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER),1,8);
				break;
			default: 
				return;	
		}
		if (!player.inventory.addItemStackToInventory(stack)) {
            EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), stack);
            world.spawnEntity(entityItem);
        } else {
            player.openContainer.detectAndSendChanges();
        }
	}
}
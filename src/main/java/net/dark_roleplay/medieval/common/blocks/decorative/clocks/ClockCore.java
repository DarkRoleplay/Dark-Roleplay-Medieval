package net.dark_roleplay.medieval.common.blocks.decorative.clocks;

import net.dark_roleplay.medieval.common.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.util.ToolHelper;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ClockCore extends FacedBlock implements ITileEntityProvider{

	public ClockCore(String registreName) {
		super(Material.ANVIL);
		this.setRegistryName(registreName);
		this.setUnlocalizedName(registreName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F); 
		this.setSoundType(SoundType.ANVIL);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TE_ClockCore();
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
		if(ToolHelper.isAcceptedTool("wrench", 0, player.getHeldItemMainhand())){
			TileEntity te = world.getTileEntity(pos);
			if(te != null && te instanceof TE_ClockCore){
				TE_ClockCore teCC = (TE_ClockCore) te;
				if(teCC.isRealTime()){
					teCC.setRealTime(false);
					player.sendStatusMessage(new TextComponentTranslation("drpcore.blocks.clock_core.change.ingame"), true);
				}else{
					teCC.setRealTime(true);
					player.sendStatusMessage(new TextComponentTranslation("drpcore.blocks.clock_core.change.real"), true);
				}
			}
			return true;
		}
        return false;
    }
}

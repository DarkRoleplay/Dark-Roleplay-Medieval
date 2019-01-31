package net.dark_roleplay.medieval.objects.blocks.general.behaviors;

import net.dark_roleplay.core.testing.drawing.DrawingGui;
import net.dark_roleplay.core.testing.drawing.ImageHelper;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.medieval.testing.blocks.TE_Banner;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_DrawBanner implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(pos);
		if(te == null) return false;
		if(!(te instanceof TE_Banner)) return false;
		if(!world.isRemote) return true;

		TE_Banner banner = (TE_Banner) te;

		ImageHelper image = banner.getImage();
		if(image == null) {
			Minecraft.getMinecraft().displayGuiScreen(new DrawingGui(new int[] {
					0xFFFFFFFF,
					0xFF136207, 0xFF004A7F, 0xFFFFC400, 0xFF7F0000,
					0xFFAA7A46, 0xFF57007F, 0xFFD70270, 0xFF734F96
					}, 16, 32, 16, (image2) -> {banner.setImage(image2);}));
		}else {

		}


		return true;
	}

}

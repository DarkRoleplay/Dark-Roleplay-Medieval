package net.dark_roleplay.medieval.objects.blocks.building.roofs;


import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.WHITE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.holders.MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ColorHandlerRoofs implements IBlockColor{

	@Override
	public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex){
		Block b = state.getBlock();
		if(tintIndex != 0) return -1;

		if(b == WHITE_CLAY_SHINGLE_ROOF) {
			return 16383998;
		}else if(b == ORANGE_CLAY_SHINGLE_ROOF) {
			return 16351261;
		}else if(b == MAGENTA_CLAY_SHINGLE_ROOF) {
			return 13061821;
		}else if(b == LIGHT_BLUE_CLAY_SHINGLE_ROOF) {
			return 3847130;
		}else if(b == YELLOW_CLAY_SHINGLE_ROOF) {
			return 16701501;
		}else if(b ==LIGHT_GREEN_CLAY_SHINGLE_ROOF) {
			return 8439583;
		}else if(b == PINK_CLAY_SHINGLE_ROOF) {
			return 15961002;
		}else if(b == GRAY_CLAY_SHINGLE_ROOF) {
			return 4673362;
		}else if(b == LIGHT_GRAY_CLAY_SHINGLE_ROOF) {
			return 10329495;
		}else if(b == CYAN_CLAY_SHINGLE_ROOF) {
			return 1481884;
		}else if(b == PURPLE_CLAY_SHINGLE_ROOF) {
			return 8991416;
		}else if(b == BROWN_CLAY_SHINGLE_ROOF) {
			return 8606770;
		}else if(b == GREEN_CLAY_SHINGLE_ROOF) {
			return 6192150;
		}else if(b == RED_CLAY_SHINGLE_ROOF) {
			return 11546150;
		}else if(b == BLACK_CLAY_SHINGLE_ROOF) {
			return 1908001;
		}else if(b == BLUE_CLAY_SHINGLE_ROOF) {
			return 3949738;
		}

		return -1;
    }
}

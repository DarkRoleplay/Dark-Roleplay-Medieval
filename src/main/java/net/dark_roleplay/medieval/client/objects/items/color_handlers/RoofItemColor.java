package net.dark_roleplay.medieval.client.objects.items.color_handlers;

import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.BLACK_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.BLUE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.BROWN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.CYAN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.GRAY_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.GREEN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.LIGHT_BLUE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.LIGHT_GRAY_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.LIGHT_GREEN_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.MAGENTA_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.ORANGE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.PINK_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.PURPLE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.RED_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF;
import static net.dark_roleplay.medieval.common.handler.MedievalBlocks.YELLOW_CLAY_SHINGLE_ROOF;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RoofItemColor implements IItemColor{

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		Block b = ((ItemBlock) stack.getItem()).getBlock();
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

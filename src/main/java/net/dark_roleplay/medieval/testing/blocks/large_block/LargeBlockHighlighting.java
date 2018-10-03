package net.dark_roleplay.medieval.testing.blocks.large_block;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.References;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = References.MODID)
public class LargeBlockHighlighting {

	@SubscribeEvent
	public static void drawHighlight(DrawBlockHighlightEvent event) {
		RayTraceResult target = event.getTarget();
		if (target.getBlockPos() == null || event.getPlayer().getEntityWorld().isAirBlock(target.getBlockPos()))
			return;

		IBlockState state = event.getPlayer().getEntityWorld().getBlockState(target.getBlockPos());

		if (state.getBlock() instanceof LargeBlock) {
			event.setCanceled(true);

			EntityPlayer player = event.getPlayer();
			BlockPos pos = target.getBlockPos();

			double playerX = player.prevPosX + (player.posX - player.prevPosX) * event.getPartialTicks();
			double playerY = player.prevPosY + (player.posY - player.prevPosY) * event.getPartialTicks();
			double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * event.getPartialTicks();

			Vec3d vec = new Vec3d(playerX, playerY, playerZ);
			vec = new Vec3d(pos.getX(), pos.getY(), pos.getZ()).subtract(vec);

			GlStateManager.color(1F, 1F, 1F);
			GlStateManager.glLineWidth(2);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
		    GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder buffer = tessellator.getBuffer();
			buffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			
			for (AxisAlignedBB bb : ((LargeBlock) state.getBlock()).getSelectionBoxes(state))
				RenderGlobal.drawBoundingBox(buffer, vec.x + bb.minX, vec.y + bb.minY, vec.z + bb.minZ, vec.x + bb.maxX,
						vec.y + bb.maxY, vec.z + bb.maxZ, 0.5F, 0.5F, 0.5F, 0.5F);
			
			tessellator.draw();
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
		}
	}

	private static void drawBoundingBox(BufferBuilder buffer, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha) {
		buffer.pos(minX, minY, minZ).color(red, green, blue, 0.0F).endVertex();
		buffer.pos(minX, minY, minZ).color(red, green, blue, alpha).endVertex();
		
		buffer.pos(maxX, minY, minZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(maxX, minY, maxZ).color(red, green, blue, alpha).endVertex();
		
		buffer.pos(minX, minY, maxZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(minX, minY, minZ).color(red, green, blue, alpha).endVertex();
		
		buffer.pos(minX, maxY, minZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(maxX, maxY, minZ).color(red, green, blue, alpha).endVertex();
		
		buffer.pos(maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(minX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
		
		buffer.pos(minX, maxY, minZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(minX, maxY, maxZ).color(red, green, blue, 0.0F).endVertex();
		
		buffer.pos(minX, minY, maxZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(maxX, minY, maxZ).color(red, green, blue, 0.0F).endVertex();
		
		buffer.pos(maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(maxX, maxY, minZ).color(red, green, blue, 0.0F).endVertex();
		
		buffer.pos(maxX, minY, minZ).color(red, green, blue, alpha).endVertex();
		buffer.pos(maxX, minY, minZ).color(red, green, blue, 0.0F).endVertex();
	}

}

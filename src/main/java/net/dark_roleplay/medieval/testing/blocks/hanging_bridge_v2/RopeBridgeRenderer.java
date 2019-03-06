package net.dark_roleplay.medieval.testing.blocks.hanging_bridge_v2;

import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;

//@EventBusSubscriber(modid = References.MODID, value = Dist.CLIENT)
public class RopeBridgeRenderer {

	public static RopeBridgeModel model = new RopeBridgeModel(new Vec3d(-10.5 - 0.0625, 59, -9.5), new Vec3d(9.5 - 0.0625, 59, 10.5), new Vec3d(-9.5 - 0.0625, 59, -10.5), new Vec3d(10.5 + 0.0625, 59, 9.5));

//	@SubscribeEvent
	public static void renderGlobal(RenderWorldLastEvent event) {
//		Minecraft.getInstance().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
//
//		Tessellator tes = Tessellator.getInstance();
//		BufferBuilder buffer = tes.getBuffer();
//		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//
////		model = new RopeBridgeModel(new Vec3d(-10.5 - 0.0625, 59, -9.5), new Vec3d(9.5 - 0.0625, 59, 10.5), new Vec3d(-9.5 - 0.0625, 59, -10.5), new Vec3d(10.5 + 0.0625, 59, 9.5));
//
//		EntityPlayer player = Minecraft.getInstance().player;
//
//		GlStateManager.pushMatrix();
//		GlStateManager.translate(
//			0 - ((player.prevPosX * (1F - event.getPartialTicks())) +  (player.posX * event.getPartialTicks())),
//			0 - ((player.prevPosY * (1F - event.getPartialTicks())) +  (player.posY * event.getPartialTicks())),
//			0 - ((player.prevPosZ * (1F - event.getPartialTicks())) +  (player.posZ * event.getPartialTicks()))
//		);
//
//		for(RopeBridgeModel.TexturedVertex vertex : model.getQuads())
//			buffer.pos(vertex.x, vertex.y, vertex.z).tex(vertex.u, vertex.v).endVertex();
//
//		tes.draw();
//		GlStateManager.popMatrix();
	}

}

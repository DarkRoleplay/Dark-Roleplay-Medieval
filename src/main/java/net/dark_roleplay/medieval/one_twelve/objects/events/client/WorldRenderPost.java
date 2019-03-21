package net.dark_roleplay.medieval.one_twelve.objects.events.client;

//PORT to 1.13
//@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class WorldRenderPost {

	//TODO make new Hanging Bridge renderer
//	@SubscribeEvent
//	public static void renderWorld(RenderWorldLastEvent event) {
//
//		Vec3d playerPos = Minecraft.getInstance().getRenderViewEntity().getPositionVector();
//		BlockPos player = Minecraft.getInstance().getRenderViewEntity().getPosition();
//
//		List<Vec3d> points = new ArrayList<Vec3d>();
//
//
//		//Calculations
//		//pos 1 < pos2
//		Vec3d pos1 = new Vec3d(40.5, 60.5, 100.5);
//		Vec3d pos2 = new Vec3d(56.5, 62.5, 105.5);
//
//		double dX = pos2.x - pos1.x;
//		double dY = pos1.y - pos2.y;
//		double dZ = pos2.z - pos1.z;
//
//		float length = (float) Math.sqrt(dX * dX + dZ * dZ);
//
//		Vec2f pos2d = new Vec2f(length, (float) dY);
//
//
//		// normalize vector
//		Vec2f normalized = new Vec2f((float) (dX / length), (float) (dZ / length));
//
//		float x0 = 0, y0 = 0, x1 = length/2, y1 = (float) (dY - (length * 0.05F)), x2 = length, y2 = (float) dY;
//
//		float length2 = (float) Math.pow(length, 2);
//
//		float a2 = (float) (((y2*x1) - (y1*x2))/((Math.pow(x1, 2) * x2) - (Math.pow(x2, 2) * x1)));
//		float b2 = (float) (((a2 * Math.pow(x1, 2)) - y1) / x1);
//
//		for(int j = 0; j <= length; j ++) {
//			float remaining = length - j ;
//			float y = (float) (a2 * (Math.pow(remaining- (length/2),2)) + b2 * (remaining- (length/2)));
//			points.add(new Vec3d((normalized.x * (length - remaining)) + pos1.x, Math.max(pos1.y, pos2.y) - y + y1, (normalized.y * (length - remaining))  + pos1.z));
//		}
//
//		Tessellator tes = Tessellator.getInstance();
//		BufferBuilder buffer = tes.getBuffer();
//		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
//
//		buffer.setTranslation(-playerPos.x, -playerPos.y, -playerPos.z);
//
//
//		Random rnd = new Random();
//
////		System.out.println(points.size());
//
//		for(int i = 1; i < points.size(); i++) {
//			buffer
//				.pos(points.get(i).x - 0.5, points.get(i - 1).y, points.get(i).z - 0.5)
//				.color(1F, 0F, 1F, 1F)
//				.endVertex();
//			buffer
//				.pos(points.get(i).x - 0.5, points.get(i - 1).y, points.get(i).z + 0.5)
//				.color(1F, 0F, 1F, 1F)
//				.endVertex();
//			buffer
//				.pos(points.get(i).x + 0.5, points.get(i).y, points.get(i).z + 0.5)
//				.color(1F, 0F, 1F, 1F)
//				.endVertex();
//			buffer
//				.pos(points.get(i).x + 0.5, points.get(i).y, points.get(i).z - 0.5)
//				.color(1F, 0F, 1F, 1F)
//				.endVertex();
//		}
//
//
//		GlStateManager.pushMatrix();
//		GlStateManager.glLineWidth(2F);
//		GlStateManager.color(1F, 1F, 1F);
//        GlStateManager.disableTexture2D();
//
//		tes.draw();
//
//		buffer.setTranslation(0, 0, 0);
//		GlStateManager.popMatrix();
//		GlStateManager.enableTexture2D();
//	}
}

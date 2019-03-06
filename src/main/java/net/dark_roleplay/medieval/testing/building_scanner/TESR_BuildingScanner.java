package net.dark_roleplay.medieval.testing.building_scanner;

public class TESR_BuildingScanner{}/*  extends TileEntityRenderer<TE_BuildingScanner> {

	private int slowMode = 20;

	@Override
	public void render(TE_BuildingScanner te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

		this.slowMode--;
		if(this.slowMode <= 0) {
			te.update();
			System.out.println(te.containedArea.size());
			this.slowMode = 20;
		}

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.disableLighting();
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		this.setLightmapDisabled(true);
		GlStateManager.glLineWidth(3.0F);
		bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);

		bufferbuilder.setTranslation(x - te.getPos().getX(), y - te.getPos().getY(), z - te.getPos().getZ());

		for(BlockPos pos : te.containedArea) {
			drawColorblindBox(bufferbuilder, pos.getX() + 0.25F, pos.getY() + 0.25F, pos.getZ() + 0.25F, pos.getX() + 0.75F, pos.getY() + 0.75F, pos.getZ() + 0.75F,
				0, 1F, 0, 1F
			);
		}

		tessellator.draw();
		bufferbuilder.setTranslation(0, 0, 0);

		this.setLightmapDisabled(false);
		GlStateManager.glLineWidth(1.0F);
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
		GlStateManager.enableDepth();
		GlStateManager.depthMask(true);



	}

	public static void drawColorblindBox(BufferBuilder buffer, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha){
		double centerY = minY + 0.1F;
		double centerX = minX + 0.1F;
		double centerZ = minZ + 0.1F;

        buffer.pos(centerX, centerY, minZ).color(red, green, blue, 0.0F).endVertex();
        buffer.pos(centerX, centerY, minZ).color(red, green, blue, alpha).endVertex();
        buffer.pos(centerX, centerY, maxZ).color(red, green, blue, alpha).endVertex();

        buffer.pos(centerX, minY, centerZ).color(red, green, blue, 0.0F).endVertex();
        buffer.pos(centerX, minY, centerZ).color(red, green, blue, alpha).endVertex();
        buffer.pos(centerX, maxY, centerZ).color(red, green, blue, alpha).endVertex();

        buffer.pos(minX, centerY, centerZ).color(red, green, blue, 0.0F).endVertex();
        buffer.pos(minX, centerY, centerZ).color(red, green, blue, alpha).endVertex();
        buffer.pos(maxX, centerY, centerZ).color(red, green, blue, alpha).endVertex();
        buffer.pos(maxX, centerY, centerZ).color(red, green, blue, 0.0F).endVertex();
    }

}*/

package net.dark_roleplay.medieval.testing.blocks;

public class TESR_Banner{}/*  extends TileEntityRenderer<TE_Banner>{

	@Override
	public void render(TE_Banner te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		ImageHelper image = te.getImage();

		if(image == null) return;

		Minecraft.getInstance().getTextureManager().bindTexture(image.getResource());

		Tessellator tes = Tessellator.getInstance();
		BufferBuilder buf = tes.getBuffer();

		//TODO Improve that stuff
		buf.begin(7, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);

		int light = te.getWorld().getCombinedLight(te.getPos(), 0);
//System.out.println(light);
		buf.setTranslation(x, y, z);
		buf.pos(0, 1, 0).tex(0, 1).lightmap(((light >>> 20) & 0xFFFF) * 16, ((light >> 4) & 0xFFFF) * 16).color(1f, 1f, 1f, 1f).endVertex();
		buf.pos(1, 1, 0).tex(1, 1).lightmap(((light >>> 20) & 0xFFFF) * 16, ((light >> 4) & 0xFFFF) * 16).color(1f, 1f, 1f, 1f).endVertex();
		buf.pos(1, 3, 0).tex(1, 0).lightmap(((light >>> 20) & 0xFFFF) * 16, ((light >> 4) & 0xFFFF) * 16).color(1f, 1f, 1f, 1f).endVertex();
		buf.pos(0, 3, 0).tex(0, 0).lightmap(((light >>> 20) & 0xFFFF) * 16, ((light >> 4) & 0xFFFF) * 16).color(1f, 1f, 1f, 1f).endVertex();

		buf.setTranslation(0, 0, 0);



//		GlStateManager.disableLighting();
		GlStateManager.color(1f, 1f, 1f, 1f);
		GlStateManager.disableLighting();
//		GlStateManager.enableLight(LightUtil.);

		tes.draw();

		GlStateManager.color(1f, 1f, 1f, alpha);
//		GlStateManager.enableLighting();
	}
}*/

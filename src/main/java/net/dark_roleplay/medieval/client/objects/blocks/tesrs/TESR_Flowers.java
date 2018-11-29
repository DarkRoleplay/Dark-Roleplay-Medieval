package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer.FlowerData;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer.FlowerDataClient;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class TESR_Flowers extends TileEntitySpecialRenderer<TE_FlowerContainer>{ // extends FastTESR<FlowersTileEntity> {

	@Override
	public final void render(TE_FlowerContainer te, double x, double y, double z, float partialTicks, int destroyStage, float partial) {
//		BlockRendererDispatcher blockRenderDispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();

		IBlockState state = te.getWorld().getBlockState(te.getPos());
		//TODO Load Flower Positioning from Files

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		RenderHelper.disableStandardItemLighting();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.enableBlend();


		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

		this.renderTileEntityFast(te, x, y, z, partialTicks, destroyStage, partial, buffer);
		buffer.setTranslation(0, 0, 0);

		tessellator.draw();

		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public void renderTileEntityFast(TE_FlowerContainer te, double x, double y, double z, float partialTicks,
			int destroyStage, float partial, BufferBuilder buffer) {
		FlowerData[] flowers = te.getFlowerData();

		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
		BlockModelRenderer renderer = blockrendererdispatcher.getBlockModelRenderer();

		for (FlowerData data : flowers) {

			if (data == null || !(data instanceof FlowerDataClient))
				continue;

			FlowerDataClient dataClient = (FlowerDataClient) data;
			IBakedModel model = dataClient.getModel();
			if (model == null) {

				dataClient.gatherBakedModel();
				model = dataClient.getModel();
			}

			if (model == null)
				continue;

			buffer.setTranslation(-te.getPos().getX() + x, -te.getPos().getY() + y, -te.getPos().getZ() + z);
			renderer.renderModel(te.getWorld(), model, dataClient.getState(), te.getPos().up(), buffer, true, 0);
		}
	}
}

package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer.FlowerData;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class TESR_Flowers extends TileEntitySpecialRenderer<TE_FlowerContainer>{ // extends FastTESR<FlowersTileEntity> {

	@Override
	public final void render(TE_FlowerContainer te, double x, double y, double z, float partialTicks, int destroyStage, float partial) {
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
		BlockModelRenderer renderer = blockrendererdispatcher.getBlockModelRenderer();
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

		FlowerData[] flowers = te.getFlowerData();

		int flowerId = 0;

		IBlockState state = te.getWorld().getBlockState(te.getPos());

		boolean flag = state.getBlock().getRegistryName().getPath().contains("flower");
		boolean rotate90 = state.getValue(BlockProperties.AXIS_HORIZONTAL) == EnumFacing.Axis.X;

//		if(rotate90) {
//			GlStateManager.rotate(90, 0, 1, 0);
//		}


		for (FlowerData data : flowers) {

			if (data == null) continue;

//			FlowerDataClient dataClient = (FlowerDataClient) data;
			IBakedModel model = data.getModel();
			if (model == null) {

				data.gatherBakedModel();
				model = data.getModel();
			}

			if (model == null)
				continue;

			BlockPos pos = te.getPos();

			Vec3d vec3d = data.getState().getOffset(te.getWorld(), te.getPos());
			vec3d = new Vec3d(-pos.getX() - vec3d.x, -pos.getY() - vec3d.y, -pos.getZ() - vec3d.z);

			if(flag) {
				switch(flowerId) {
					case 0:	buffer.setTranslation(vec3d.x + 0.1, vec3d.y, vec3d.z + 0.4); break;
					case 1:	buffer.setTranslation(vec3d.x - 0.05, vec3d.y, vec3d.z); break;
					case 2:	buffer.setTranslation(vec3d.x + 0.05, vec3d.y, vec3d.z - 0.35); break;
					default:buffer.setTranslation(vec3d.x, vec3d.y, vec3d.z); break;
				}
			}else {
				switch(flowerId) {
					case 0:	buffer.setTranslation(vec3d.x + 0.15, vec3d.y, vec3d.z + 0.1); break;
					case 1:	buffer.setTranslation(vec3d.x - 0.05, vec3d.y, vec3d.z - 0.15); break;
					case 2:	buffer.setTranslation(vec3d.x - 0.2, vec3d.y, vec3d.z + 0.05); break;
					default:buffer.setTranslation(vec3d.x, vec3d.y, vec3d.z); break;
				}
			}
			flowerId++;

			renderer.renderModel(te.getWorld(), model, data.getState(), te.getPos(), buffer, true, 0);
		}

		buffer.setTranslation(0, 0, 0);

		RenderHelper.disableStandardItemLighting();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.pushMatrix();

		GlStateManager.translate(x - 0.5F, y - 0.5F, z - 0.5F);
		GlStateManager.scale(0.8F, 0.8F, 0.8F);
		GlStateManager.translate(rotate90 ?  1.75F : 0.75F , 1.1875F, 0.75F);
		if(rotate90) GlStateManager.rotate(-90, 0, 1, 0);

		tessellator.draw();

//		GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public void renderTileEntityFast(TE_FlowerContainer te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {

	}
}

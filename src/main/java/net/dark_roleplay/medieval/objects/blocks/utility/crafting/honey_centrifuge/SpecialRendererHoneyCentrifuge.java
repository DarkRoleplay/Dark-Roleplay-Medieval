package net.dark_roleplay.medieval.objects.blocks.utility.crafting.honey_centrifuge;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.Properties;

public class SpecialRendererHoneyCentrifuge extends TileEntitySpecialRenderer<TileEntityHoneyCentrifuge>{

	List<BakedQuad> quads = null;

	@Override
	public void render(TileEntityHoneyCentrifuge tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		if(this.quads == null) {
			BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
			this.quads =
					blockrendererdispatcher.getBlockModelShapes().getModelForState(tileEntity.getWorld().getBlockState(tileEntity.getPos()).withProperty(Properties.StaticProperty, false).withProperty(MedievalBlockProperties.FACING_HORIZONTAL, EnumFacing.NORTH))
					.getQuads(tileEntity.getWorld().getBlockState(tileEntity.getPos()).withProperty(Properties.StaticProperty, false), null, 0L);;
		}

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		float rotation = tileEntity.getLastRotation() + ((tileEntity.getRotation() - tileEntity.getLastRotation()) * partialTicks);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

		for(BakedQuad quad : this.quads) {
			VertexFormat format = quad.getFormat();
			buffer.addVertexData(quad.getVertexData());
		}

		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.5F, y, z + 0.5F);
		GlStateManager.rotate(rotation, 0F, 1F, 0F);
		tessellator.draw();

		GlStateManager.popMatrix();
	}
}

package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FluidBarrel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class TESR_FluidBarrel extends TileEntitySpecialRenderer<TE_FluidBarrel>{

	@Override
	public void render(TE_FluidBarrel te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

		FluidTank fluidTank = (FluidTank) te.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
		FluidStack fluid = fluidTank.getFluid();

		if(fluid == null || fluid.getFluid() == null)
			return;

	    double y2 = ((0.000048828125D) * (fluidTank.getFluidAmount()));

		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.color(1F, 1F, 1F);
		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        TextureAtlasSprite still = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getFluid().getStill().toString());

        int color = fluid.getFluid().getColor(fluid);
        float[] colors = new float[] { 255F / ((color >> 24) & 0xFF), 255F / ((color >> 16) & 0xFF), 255F / ((color >> 8) & 0xFF), 255F / (color & 0xFF)};

		Tessellator tessellator = Tessellator.getInstance();
	    BufferBuilder buffer = tessellator.getBuffer();

	    buffer.setTranslation(x, y + 0.125F + y2, z);

	    buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
	    if(y2 <= 0.0625 || y2 >= 0.6875) {
		    this.addHQuad(buffer, 0, 0.1875, 0.125, 0.815, 0.3125, colors, still);
		    this.addHQuad(buffer, 0, 0.125, 0.3125, 0.875, 0.6875, colors, still);
		    this.addHQuad(buffer, 0, 0.1875, 0.6875, 0.815, 0.875, colors, still);
	    }else{
		    this.addHQuad(buffer, 0, 0.1872, 0.0625, 0.8125, 0.1875, colors, still);
		    this.addHQuad(buffer, 0, 0.0625, 0.1875, 0.9375, 0.8125, colors, still);
		    this.addHQuad(buffer, 0, 0.1872, 0.8125, 0.8125, 0.9375, colors, still);
	    }
	    tessellator.draw();

	    buffer.setTranslation(0, 0, 0);
	    GlStateManager.disableBlend();
		GlStateManager.popMatrix();
    }

	public void addHQuad(BufferBuilder buffer, double posY, double posX1, double posZ1, double posX2, double posZ2, float[] colors, TextureAtlasSprite sprite) {
		buffer.pos(posX1, posY, posZ1).tex(sprite.getInterpolatedU(16 * posX1), sprite.getInterpolatedV(16 * posZ1)).color(colors[3], colors[1], colors[2], colors[0]).endVertex();
        buffer.pos(posX1, posY, posZ2).tex(sprite.getInterpolatedU(16 * posX1), sprite.getInterpolatedV(16 * posZ2)).color(colors[3], colors[1], colors[2], colors[0]).endVertex();
        buffer.pos(posX2, posY, posZ2).tex(sprite.getInterpolatedU(16 * posX2), sprite.getInterpolatedV(16 * posZ2)).color(colors[3], colors[1], colors[2], colors[0]).endVertex();
        buffer.pos(posX2, posY, posZ1).tex(sprite.getInterpolatedU(16 * posX2), sprite.getInterpolatedV(16 * posZ1)).color(colors[3], colors[1], colors[2], colors[0]).endVertex();
	}

}

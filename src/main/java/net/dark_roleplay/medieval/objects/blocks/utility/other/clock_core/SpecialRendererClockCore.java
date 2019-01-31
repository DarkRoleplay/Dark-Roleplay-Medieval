package net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;

public class SpecialRendererClockCore extends TileEntitySpecialRenderer<TileEntityClockCore> {

	public SpecialRendererClockCore() {}

	@Override
	public void render(TileEntityClockCore te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		EnumFacing facing = te.getWorld().getBlockState(te.getPos()).getValue(MedievalBlockProperties.FACING_HORIZONTAL);

		float angleMinutes = 0F;
		float angleHours = 0F;

		if(te.isRealTime()){
			angleHours = 30 * Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			angleMinutes = 6 * Calendar.getInstance().get(Calendar.MINUTE);
		}else{
			angleMinutes = 0.36F * (te.getWorld().getWorldTime() % 1000F);
			angleHours = 30F * (te.getWorld().getWorldTime() / 1000F) + 180;
		}

		GlStateManager.pushMatrix();{
			GlStateManager.disableTexture2D();
			GlStateManager.disableCull();

			switch(facing){
				case NORTH:
					GlStateManager.translate(x + 0.5, y + 0.5, z);
					GlStateManager.rotate(270,0F,1F,0F);
					break;
				case EAST:
					GlStateManager.translate(x + 1, y + 0.5, z + 0.5);
					GlStateManager.rotate(180,0F,1F,0F);
					break;
				case SOUTH:
					GlStateManager.translate(x + 0.5, y + 0.5, z + 1);
					GlStateManager.rotate(90,0F,1F,0F);
					break;
				case WEST:
					GlStateManager.translate(x, y + 0.5, z + 0.5);
					break;
				default:
					break;
			}


			Tessellator tessellator = Tessellator.getInstance();
		    BufferBuilder buff = tessellator.getBuffer();
		    buff.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);

			GlStateManager.rotate(angleMinutes,1F,0F,0F);

			buff.pos(-0.0775, 0, -0.03127).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.0775, 0, 0.03127).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.0775, 1.2, 0.03127).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.0775, 1.2, -0.03127).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();

		    tessellator.draw();

		    buff.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);

			GlStateManager.rotate(angleHours-angleMinutes,1F,0F,0F);

			buff.pos(-0.075, 0, -0.0625).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.075, 0, 0.0625).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.075, 0.8, 0.0625).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
			buff.pos(-0.075, 0.8, -0.0625).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();


		    tessellator.draw();

			GlStateManager.enableTexture2D();
			GlStateManager.enableCull();
		}GlStateManager.popMatrix();

	}
}

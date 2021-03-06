package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;

public class TESR_ShopSign extends TileEntitySpecialRenderer<TE_ShopSign> {

	public TESR_ShopSign() {}

	@Override
	public void render(TE_ShopSign tes, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

			if(tes.getDrawing() == null)
				return;

			GL11.glPushMatrix();

			Tessellator tessellator = Tessellator.getInstance();
		    BufferBuilder buff = tessellator.getBuffer();
		    buff.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);

		    EnumFacing facing = tes.getWorld().getBlockState(tes.getPos()).getValue(BlockProperties.FACING_HORIZONTAL);

		    this.bindTexture(tes.getDrawing());
		    double x2 = x;
		    double y2 = y - 0.25;
		    double z2 = z;
		    if(facing == EnumFacing.NORTH){
		    	 x2 = x + 0.46874;
		    	 z2 = z - 0.28125;
		    }
		    if(facing == EnumFacing.SOUTH){
		    	 x2 = x + 0.46874;
		    	 z2 = z + 0.28125;
		    }
		    if(facing == EnumFacing.WEST){
		    	 z2 = z + 0.46875;
		    	 x2 = x - 0.28125;
		    }
		    if(facing == EnumFacing.EAST){
		    	 z2 = z + 0.46875;
		    	 x2 = x + 0.28125;
		    }
		    //NORTH
		    if(facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH){
			    buff.pos(x2, y2 , z2).tex(0, 1).endVertex();
			    buff.pos(x2, y2, z2 + 1).tex(1, 1).endVertex();
			    buff.pos(x2, y2 + 0.75, z2 + 1).tex(1, 0).endVertex();
			    buff.pos(x2, y2 + 0.75, z2).tex(0, 0).endVertex();

			    buff.pos(x2 + 0.0627, y2 , z2 + 1).tex(0, 1).endVertex();
			    buff.pos(x2 + 0.0627, y2, z2).tex(1, 1).endVertex();
			    buff.pos(x2 + 0.0627, y2 + 0.75, z2).tex(1, 0).endVertex();
			    buff.pos(x2 + 0.0627, y2 + 0.75, z2 + 1).tex(0, 0).endVertex();
		    }

		    if(facing == EnumFacing.EAST || facing == EnumFacing.WEST){
			    buff.pos(x2 + 1, y2 , z2).tex(0, 1).endVertex();
			    buff.pos(x2, y2, z2).tex(1, 1).endVertex();
			    buff.pos(x2, y2 + 0.75, z2).tex(1, 0).endVertex();
			    buff.pos(x2 + 1, y2 + 0.75, z2).tex(0, 0).endVertex();

			    buff.pos(x2, y2 , z2 + 0.0626).tex(0, 1).endVertex();
			    buff.pos(x2 + 1, y2, z2 + 0.0626).tex(1, 1).endVertex();
			    buff.pos(x2 + 1, y2 + 0.75, z2 + 0.0626).tex(1, 0).endVertex();
			    buff.pos(x2, y2 + 0.75, z2 + 0.0626).tex(0, 0).endVertex();
		    }



		    tessellator.draw();

			GL11.glPopMatrix();
	}
}
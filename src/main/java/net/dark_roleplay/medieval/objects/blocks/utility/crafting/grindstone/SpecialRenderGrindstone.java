package net.dark_roleplay.medieval.objects.blocks.utility.crafting.grindstone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.block.state.IBlockState;
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

public class SpecialRenderGrindstone extends TileEntitySpecialRenderer<TileEntityGrindstone> {


	Map<IBlockState, List<BakedQuad>> quads = new HashMap<IBlockState, List<BakedQuad>>();

	@Override
	public void render(TileEntityGrindstone tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		IBlockState state = tileEntity.getWorld().getBlockState(tileEntity.getPos());

		if(!(state.getBlock() instanceof Grindstone)) return;

		if(!this.quads.containsKey(state.withProperty(Properties.StaticProperty, false))) {
			BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
			this.quads.put(state,
				blockrendererdispatcher.getBlockModelShapes().getModelForState(tileEntity.getWorld().getBlockState(tileEntity.getPos()).withProperty(Properties.StaticProperty, false))
				.getQuads(tileEntity.getWorld().getBlockState(tileEntity.getPos()).withProperty(Properties.StaticProperty, false), null, 0L));
		}

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		EnumFacing facing = state.getValue(MedievalBlockProperties.FACING_HORIZONTAL);

		float rotation = tileEntity.getLastRotation() + ((tileEntity.getRotation() - tileEntity.getLastRotation()) * partialTicks);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

		for(BakedQuad quad : this.quads.get(state)) {
			VertexFormat format = quad.getFormat();
			buffer.addVertexData(quad.getVertexData());
		}

		GlStateManager.pushMatrix();

		switch(facing) {
			case EAST:
				GlStateManager.translate(x + 8 * 0.0625F, y + 0.625F, z);
				GlStateManager.rotate(rotation, 0F, 0F, 1F);
				GlStateManager.translate(-1, 0, 0);
				break;
			case NORTH:
				GlStateManager.translate(x, y + 0.625F, z + 8 * 0.0625F);
				GlStateManager.rotate(rotation, 1F, 0F, 0F);
				break;
			case SOUTH:
				GlStateManager.translate(x, y + 0.625F, z + 8 * 0.0625F);
				GlStateManager.rotate(rotation, 1F, 0F, 0F);
				GlStateManager.translate(0, 0, -1);
				break;
			case WEST:
				GlStateManager.translate(x + 8 * 0.0625F, y + 0.625F, z);
				GlStateManager.rotate(rotation, 0F, 0F, 1F);
				break;
			default:
				break;
		}

		tessellator.draw();

		GlStateManager.popMatrix();
	}
}

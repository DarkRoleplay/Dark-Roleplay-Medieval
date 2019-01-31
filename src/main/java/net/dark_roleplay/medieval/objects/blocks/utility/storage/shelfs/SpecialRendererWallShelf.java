package net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class SpecialRendererWallShelf extends TileEntitySpecialRenderer<TileEnittyUniversalShelf> {

    private RenderItem itemRenderer;

	public SpecialRendererWallShelf(RenderItem itemRenderer) {
		this.itemRenderer = itemRenderer;
	}

	@Override
	public void render(TileEnittyUniversalShelf te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

		ShelfRenderInformation renderInformation = te.getRenderInformation(Minecraft.getMinecraft().getRenderItem());
		ShelfRenderInformation.ItemMap[] stacks = renderInformation.getSlots();

		IBlockState state  = te.getWorld().getBlockState(te.getPos());

		EnumFacing facing = state.getValue(MedievalBlockProperties.FACING_HORIZONTAL);

		if(this.itemRenderer == null)
			this.itemRenderer = Minecraft.getMinecraft().getRenderItem();

		IItemHandler invHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for(int i = 0; i < invHandler.getSlots(); i ++){
			stacks[i].refresh(invHandler.getStackInSlot(i), te.getWorld());
		}

        Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);


		GL11.glPushMatrix();
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.alphaFunc(516, 0.1F);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        GL11.glPushMatrix();
        switch(facing){
			case EAST:
				GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.5F);
				GlStateManager.rotate(-90F, 0F, 1F, 0F);

				for(int i = 0; i < stacks.length; i ++){
					stacks[i].render();
				}
				break;
			case NORTH:
				GlStateManager.translate(x + 1, y, z + 0.5);
				GlStateManager.rotate(180F, 0F, 1F, 0F);
				for(int i = 0; i < stacks.length; i ++){
					stacks[i].render();
				}
				break;
			case SOUTH:
				GlStateManager.translate(x, y, z);
				GlStateManager.rotate(180F, 0F, 1F, 0F);


				for(int i = 0; i < stacks.length; i ++){
					stacks[i].render();
				}
				break;
			case WEST:
				GlStateManager.translate(x, y, z);
				GlStateManager.rotate(90F, 0F, 1F, 0F);

				for(int i = 0; i < stacks.length; i ++){
					stacks[i].render();
				}
				break;
			default:
				break;
        }
        GL11.glPopMatrix();

        GlStateManager.disableBlend();
        GL11.glPopMatrix();
	}
}

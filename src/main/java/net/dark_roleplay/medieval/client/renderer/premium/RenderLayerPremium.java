package net.dark_roleplay.medieval.client.renderer.premium;

import net.dark_roleplay.medieval.client.entities.fox.Model_Fox;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderLayerPremium implements LayerRenderer<EntityPlayer> {

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	@Override
	public void doRenderLayer(EntityPlayer entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		Model_Fox mf = new Model_Fox();
		Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(new ResourceLocation(DRPMedievalInfo.MODID, "textures/entitys/fox/fox.png"));
		mf.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

}

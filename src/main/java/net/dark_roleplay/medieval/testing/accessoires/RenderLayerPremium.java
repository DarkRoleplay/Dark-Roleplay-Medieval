package net.dark_roleplay.medieval.testing.accessoires;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.objects.entities.fox.ModelFox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderLayerPremium implements LayerRenderer<EntityPlayer> {

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	@Override
	public void doRenderLayer(EntityPlayer entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ModelFox mf = new ModelFox();
		Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(new ResourceLocation(References.MODID, "textures/entitys/fox/fox.png"));
		mf.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

}

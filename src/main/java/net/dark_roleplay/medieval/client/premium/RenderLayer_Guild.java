package net.dark_roleplay.medieval.client.premium;

import net.dark_roleplay.medieval.client.entities.fox.Model_Fox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class RenderLayer_Guild implements LayerRenderer<EntityPlayer> {

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	@Override
	public void doRenderLayer(EntityPlayer entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		double d0 = entity.getDistanceSq(renderManager.renderViewEntity);

		String str = "DEBUG";
		
//		if (d0 <= (double) (40 * 40)) {
			boolean flag = entity.isSneaking();
			float f = renderManager.playerViewY;
			float f1 = renderManager.playerViewX;
			boolean flag1 = renderManager.options.thirdPersonView == 2;
			float f2 = entity.height + 0.5F - (flag ? 0.25F : 0.0F);
			int i = "deadmau5".equals(str) ? -10 : 0;
			BlockPos pos = entity.getPosition();
			EntityRenderer.drawNameplate(renderManager.getFontRenderer(), str, pos.getX(), pos.getY() + f2, pos.getZ(), i, f, f1, flag1, flag);
//		}
	}
}

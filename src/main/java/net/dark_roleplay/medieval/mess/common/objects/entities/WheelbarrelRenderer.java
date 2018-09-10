package net.dark_roleplay.medieval.mess.common.objects.entities;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.mess.client.entities.fox.Model_Fox;
import net.dark_roleplay.medieval.mess.client.entities.fox.Render_Fox;
import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.entities.fox.Entity_Fox;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WheelbarrelRenderer extends Render<Wheelbarrel>{
	
	public static final Factory FACTORY = new Factory();

	protected WheelbarrelRenderer(RenderManager renderManager) {
		super(renderManager);
	}

    @Override
	public void doRender(Wheelbarrel entity, double x, double y, double z, float entityYaw, float partialTicks){
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.scale(0.1F, 0.1F, 0.1F);
        new Model_Fox().BodyCenter.render(1F);
        GlStateManager.popMatrix();
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Wheelbarrel entity) {
		return new ResourceLocation(References.MODID, "textures/entitys/fox/fox.png");
	}
	
	private static class Factory implements IRenderFactory<Wheelbarrel> {
		@Override
		public Render<? super Wheelbarrel> createRenderFor(RenderManager manager) {
			return new WheelbarrelRenderer(manager);
	    }
	}
}

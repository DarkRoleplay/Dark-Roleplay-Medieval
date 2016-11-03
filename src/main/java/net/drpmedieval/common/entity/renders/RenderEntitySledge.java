package net.drpmedieval.common.entity.renders;

import javax.annotation.Nonnull;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entity.item.EntitySledge;
import net.drpmedieval.common.entity.models.SledgeModel;
import net.drpmedieval.common.entity.models.TrainingDummyModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEntitySledge extends RenderLiving<EntitySledge>{

	private static final ResourceLocation sledgeTexture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/entitys/TrainingDummy.png");

	public static final Factory FACTORY = new Factory();
	
	public RenderEntitySledge(RenderManager rendermanagerIn) {
		//super(rendermanagerIn, new ModelZombie(), 1f);
		super(rendermanagerIn, new SledgeModel(), 0.5f);
	}
	
	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntitySledge entity) {
		return sledgeTexture;
	}

	public static class Factory implements IRenderFactory<EntitySledge> {
		@Override
		public Render<? super EntitySledge> createRenderFor(RenderManager manager) {
			return new RenderEntitySledge(manager);
	    }
	}
}

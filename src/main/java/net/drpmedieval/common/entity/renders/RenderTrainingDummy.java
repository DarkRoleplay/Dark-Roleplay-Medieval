package net.drpmedieval.common.entity.renders;

import org.lwjgl.opengl.GL11;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entity.TrainingDummy;
import net.drpmedieval.common.entity.models.TrainingDummyModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTrainingDummy extends RenderLiving<TrainingDummy> {

	private static final ResourceLocation trainingDummyTextures = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/entitys/TrainingDummy.png");

	public RenderTrainingDummy() {
		this(Minecraft.getMinecraft().getRenderManager());
	}

	public RenderTrainingDummy(RenderManager renderManagerIn) {
		super(Minecraft.getMinecraft().getRenderManager(), new TrainingDummyModel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(TrainingDummy entity) {

		return trainingDummyTextures;
	}
}

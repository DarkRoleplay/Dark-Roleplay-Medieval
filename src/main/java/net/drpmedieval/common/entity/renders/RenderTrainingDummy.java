package net.drpmedieval.common.entity.renders;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entity.TrainingDummy;
import net.drpmedieval.common.entity.item.EntitySledge;
import net.drpmedieval.common.entity.models.TrainingDummyModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTrainingDummy<T extends EntitySledge> extends Render<T> {

	private static final ResourceLocation trainingDummyTextures = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/entitys/TrainingDummy.png");

    protected ModelBase modelDummy = new TrainingDummyModel();
	
	public RenderTrainingDummy() {
		this(Minecraft.getMinecraft().getRenderManager());
	}

	public RenderTrainingDummy(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return trainingDummyTextures;
	}
	
	@Override
	public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks){
		 modelDummy.render(entity, 0, 0, 0, entityYaw, entityYaw, 1);
	}
}

package net.dark_roleplay.medieval.client.renderer.entity;

import javax.annotation.Nonnull;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.entity.models.SledgeModel;
import net.dark_roleplay.medieval.common.entity.models.TrainingDummyModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntitySledge extends RenderLiving<EntitySledge>{

	private static final ResourceLocation sledgeTexture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/entitys/Sledge.png");

	public static final Factory FACTORY = new Factory();
	
	public RenderEntitySledge(RenderManager rendermanagerIn) {
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
	
	@Override
	public void doRender(EntitySledge entity, double x, double y, double z, float entityYaw, float partialTicks){
        this.doRender2(entity, x, y, z, entityYaw, partialTicks);

        if (!this.renderOutlines){
            this.renderLeash(entity, x, y, z, entityYaw, partialTicks);
        }
    }
	

	public void doRender2(EntitySledge entity, double x, double y, double z, float entityYaw, float partialTicks){
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<EntitySledge>(entity, this, x, y, z))) return;
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
        boolean shouldSit = entity.isRiding() && (entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit());
        this.mainModel.isRiding = shouldSit;
        this.mainModel.isChild = entity.isChild();

        try{
            float f = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
            float f1 = this.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
            float f2 = f1 - f;

            if (shouldSit && entity.getRidingEntity() instanceof EntityLivingBase){
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity.getRidingEntity();
                f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
                f2 = f1 - f;
                float f3 = MathHelper.wrapDegrees(f2);

                if (f3 < -85.0F){
                    f3 = -85.0F;
                }

                if (f3 >= 85.0F){
                    f3 = 85.0F;
                }

                f = f1 - f3;

                if (f3 * f3 > 2500.0F){
                    f += f3 * 0.2F;
                }
            }

            float f7 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
            this.renderLivingAt(entity, x, y, z);
            float f8 = this.handleRotationFloat(entity, partialTicks);
            //TODO SLEDGE RENDERER FIX ROTATE CORPSE
            //this.rotateCorpse(entity, f8, f, partialTicks);
            float f4 = this.prepareScale(entity, partialTicks);
            float f5 = 0.0F;
            float f6 = 0.0F;

            if (!entity.isRiding()){
                f5 = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
                f6 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);

                if (entity.isChild()){
                    f6 *= 3.0F;
                }

                if (f5 > 1.0F){
                    f5 = 1.0F;
                }
            }

            GlStateManager.enableAlpha();
            this.mainModel.setLivingAnimations(entity, f6, f5, partialTicks);
            this.mainModel.setRotationAngles(f6, f5, f8, f2, f7, f4, entity);

            GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);

            
            if (this.renderOutlines){
                boolean flag1 = this.setScoreTeamColor(entity);
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode(this.getTeamColor(entity));

                if (!this.renderMarker){
                    this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                }

                this.renderLayers(entity, f6, f5, partialTicks, f8, f2, f7, f4);

                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();

                if (flag1){
                    this.unsetScoreTeamColor();
                }
            }
            else
            {
                boolean flag = this.setDoRenderBrightness(entity, partialTicks);
                this.renderModel(entity, f6, f5, f8, f2, f7, f4);

                if (flag){
                    this.unsetBrightness();
                }

                GlStateManager.depthMask(true);

                this.renderLayers(entity, f6, f5, partialTicks, f8, f2, f7, f4);
            }

            GlStateManager.disableRescaleNormal();
        }
        catch (Exception exception){
            DarkRoleplayMedieval.LOGGER.error((String)"Couldn\'t render entity", (Throwable)exception);
        }

        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();
      
        if (!this.renderOutlines){
            this.renderName(entity, x, y, z);
        }
        
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<EntitySledge>(entity, this, x, y, z));
    }
	
	protected void renderLivingLabel2(EntitySledge entityIn, String str, double x, double y, double z, int maxDistance){
        double d0 = entityIn.getDistanceSqToEntity(this.renderManager.renderViewEntity);

        if (d0 <= (double)(maxDistance * maxDistance)){
            boolean flag = entityIn.isSneaking();
            float f = this.renderManager.playerViewY;
            float f1 = this.renderManager.playerViewX;
            boolean flag1 = this.renderManager.options.thirdPersonView == 2;
            float f2 = entityIn.height + 0.5F - (flag ? 0.25F : 0.0F);
            int i = "deadmau5".equals(str) ? -10 : 0;
            EntityRenderer.drawNameplate(this.getFontRendererFromRenderManager(), str, (float)x, (float)y + f2 + 1.2F, (float)z, i, f, f1, flag1, flag);
        }
    }
}

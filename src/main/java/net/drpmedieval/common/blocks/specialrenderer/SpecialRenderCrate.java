package net.drpmedieval.common.blocks.specialrenderer;

import org.lwjgl.opengl.GL11;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMBlocks;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderCrate extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/old_blocks/block_crate.png");

	private ModelCrate model;

	public SpecialRenderCrate() {
		this.model = new ModelCrate();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMBlocks.CRATE)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			GL11.glRotatef(tileentity.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
		}
	}

}

class ModelCrate extends ModelBase {

	// fields
	ModelRenderer Crateside1;
	ModelRenderer Cratesid12;
	ModelRenderer Crateside2;
	ModelRenderer Crateside3;
	ModelRenderer Crateside4;
	ModelRenderer Crateside5;
	ModelRenderer Cratesidewall6;
	ModelRenderer Crateside6;
	ModelRenderer Crateside7;
	ModelRenderer Cratemiddle1;
	ModelRenderer Crateside9;
	ModelRenderer Crateside10;
	ModelRenderer Crateside11;
	ModelRenderer Crateside8;
	ModelRenderer Cratesidewall1;
	ModelRenderer Cratesidewall2;
	ModelRenderer Cratesidewall3;
	ModelRenderer Cratesidewall4;
	ModelRenderer Cratesidewall5;

	public ModelCrate() {
		textureWidth = 64;
		textureHeight = 64;

		Crateside1 = new ModelRenderer(this, 30, 20);
		Crateside1.addBox(0F, 0F, 0F, 2, 2, 12);
		Crateside1.setRotationPoint(-8F, 8F, -6F);
		Crateside1.setTextureSize(64, 64);
		Crateside1.mirror = true;
		setRotation(Crateside1, 0F, 0F, 0F);
		Cratesid12 = new ModelRenderer(this, 0, 30);
		Cratesid12.addBox(0F, 0F, 0F, 12, 2, 2);
		Cratesid12.setRotationPoint(-6F, 8F, 6F);
		Cratesid12.setTextureSize(64, 64);
		Cratesid12.mirror = true;
		setRotation(Cratesid12, 0F, 0F, 0F);
		Crateside2 = new ModelRenderer(this, 55, 0);
		Crateside2.addBox(0F, 0F, 0F, 2, 16, 2);
		Crateside2.setRotationPoint(-8F, 8F, -8F);
		Crateside2.setTextureSize(64, 64);
		Crateside2.mirror = true;
		setRotation(Crateside2, 0F, 0F, 0F);
		Crateside3 = new ModelRenderer(this, 55, 0);
		Crateside3.addBox(0F, 0F, 0F, 2, 16, 2);
		Crateside3.setRotationPoint(-8F, 8F, 6F);
		Crateside3.setTextureSize(64, 64);
		Crateside3.mirror = true;
		setRotation(Crateside3, 0F, 0F, 0F);
		Crateside4 = new ModelRenderer(this, 55, 0);
		Crateside4.addBox(0F, 0F, 0F, 2, 16, 2);
		Crateside4.setRotationPoint(6F, 8F, 6F);
		Crateside4.setTextureSize(64, 64);
		Crateside4.mirror = true;
		setRotation(Crateside4, 0F, 0F, 0F);
		Crateside5 = new ModelRenderer(this, 55, 0);
		Crateside5.addBox(0F, 0F, 0F, 2, 16, 2);
		Crateside5.setRotationPoint(6F, 8F, -8F);
		Crateside5.setTextureSize(64, 64);
		Crateside5.mirror = true;
		setRotation(Crateside5, 0F, 0F, 0F);
		Cratesidewall6 = new ModelRenderer(this, 0, 21);
		Cratesidewall6.addBox(0F, 0F, 0F, 18, 2, 1);
		Cratesidewall6.setRotationPoint(-7F, 22F, -7.5F);
		Cratesidewall6.setTextureSize(64, 64);
		Cratesidewall6.mirror = true;
		setRotation(Cratesidewall6, 0F, 0F, -0.7853982F);
		Crateside6 = new ModelRenderer(this, 30, 20);
		Crateside6.addBox(0F, 0F, 0F, 2, 2, 12);
		Crateside6.setRotationPoint(6F, 22F, -6F);
		Crateside6.setTextureSize(64, 64);
		Crateside6.mirror = true;
		setRotation(Crateside6, 0F, 0F, 0F);
		Crateside7 = new ModelRenderer(this, 30, 20);
		Crateside7.addBox(0F, 0F, 0F, 2, 2, 12);
		Crateside7.setRotationPoint(-8F, 22F, -6F);
		Crateside7.setTextureSize(64, 64);
		Crateside7.mirror = true;
		setRotation(Crateside7, 0F, 0F, 0F);
		Cratemiddle1 = new ModelRenderer(this, 0, 36);
		Cratemiddle1.addBox(0F, 0F, 0F, 14, 15, 14);
		Cratemiddle1.setRotationPoint(-7F, 9F, -7F);
		Cratemiddle1.setTextureSize(64, 64);
		Cratemiddle1.mirror = true;
		setRotation(Cratemiddle1, 0F, 0F, 0F);
		Crateside9 = new ModelRenderer(this, 0, 30);
		Crateside9.addBox(0F, 0F, 0F, 12, 2, 2);
		Crateside9.setRotationPoint(-6F, 8F, -8F);
		Crateside9.setTextureSize(64, 64);
		Crateside9.mirror = true;
		setRotation(Crateside9, 0F, 0F, 0F);
		Crateside10 = new ModelRenderer(this, 0, 30);
		Crateside10.addBox(0F, 0F, 0F, 12, 2, 2);
		Crateside10.setRotationPoint(-6F, 22F, -8F);
		Crateside10.setTextureSize(64, 64);
		Crateside10.mirror = true;
		setRotation(Crateside10, 0F, 0F, 0F);
		Crateside11 = new ModelRenderer(this, 0, 30);
		Crateside11.addBox(0F, 0F, 0F, 12, 2, 2);
		Crateside11.setRotationPoint(-6F, 22F, 6F);
		Crateside11.setTextureSize(64, 64);
		Crateside11.mirror = true;
		setRotation(Crateside11, 0F, 0F, 0F);
		Crateside8 = new ModelRenderer(this, 30, 20);
		Crateside8.addBox(0F, 0F, 0F, 2, 2, 12);
		Crateside8.setRotationPoint(6F, 8F, -6F);
		Crateside8.setTextureSize(64, 64);
		Crateside8.mirror = true;
		setRotation(Crateside8, 0F, 0F, 0F);
		Cratesidewall1 = new ModelRenderer(this, 0, 25);
		Cratesidewall1.addBox(0F, 0F, 0F, 18, 1, 2);
		Cratesidewall1.setRotationPoint(-7F, 22.5F, 6F);
		Cratesidewall1.setTextureSize(64, 64);
		Cratesidewall1.mirror = true;
		setRotation(Cratesidewall1, 0F, 0.7853982F, 0F);
		Cratesidewall2 = new ModelRenderer(this, 0, 0);
		Cratesidewall2.addBox(0F, 0F, 0F, 1, 2, 18);
		Cratesidewall2.setRotationPoint(-7.5F, 9F, -6F);
		Cratesidewall2.setTextureSize(64, 64);
		Cratesidewall2.mirror = true;
		setRotation(Cratesidewall2, -0.7853982F, 0F, 0F);
		Cratesidewall3 = new ModelRenderer(this, 0, 21);
		Cratesidewall3.addBox(0F, 0F, 0F, 18, 2, 1);
		Cratesidewall3.setRotationPoint(-6F, 9F, 6.5F);
		Cratesidewall3.setTextureSize(64, 64);
		Cratesidewall3.mirror = true;
		setRotation(Cratesidewall3, 0F, 0F, 0.7853982F);
		Cratesidewall4 = new ModelRenderer(this, 0, 0);
		Cratesidewall4.addBox(0F, 0F, 0F, 1, 2, 18);
		Cratesidewall4.setRotationPoint(6.5F, 22F, -7F);
		Cratesidewall4.setTextureSize(64, 64);
		Cratesidewall4.mirror = true;
		setRotation(Cratesidewall4, 0.7853982F, 0F, 0F);
		Cratesidewall5 = new ModelRenderer(this, 0, 25);
		Cratesidewall5.addBox(0F, 0F, 0F, 18, 1, 2);
		Cratesidewall5.setRotationPoint(-7F, 8.5F, 6F);
		Cratesidewall5.setTextureSize(64, 64);
		Cratesidewall5.mirror = true;
		setRotation(Cratesidewall5, 0F, 0.7853982F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Crateside1.render(f5);
		Cratesid12.render(f5);
		Crateside2.render(f5);
		Crateside3.render(f5);
		Crateside4.render(f5);
		Crateside5.render(f5);
		Cratesidewall6.render(f5);
		Crateside6.render(f5);
		Crateside7.render(f5);
		Cratemiddle1.render(f5);
		Crateside9.render(f5);
		Crateside10.render(f5);
		Crateside11.render(f5);
		Crateside8.render(f5);
		Cratesidewall1.render(f5);
		Cratesidewall2.render(f5);
		Cratesidewall3.render(f5);
		Cratesidewall4.render(f5);
		Cratesidewall5.render(f5);
	}

	public void renderModel(float f) {

		Crateside1.render(f);
		Cratesid12.render(f);
		Crateside2.render(f);
		Crateside3.render(f);
		Crateside4.render(f);
		Crateside5.render(f);
		Cratesidewall6.render(f);
		Crateside6.render(f);
		Crateside7.render(f);
		Cratemiddle1.render(f);
		Crateside9.render(f);
		Crateside10.render(f);
		Crateside11.render(f);
		Crateside8.render(f);
		Cratesidewall1.render(f);
		Cratesidewall2.render(f);
		Cratesidewall3.render(f);
		Cratesidewall4.render(f);
		Cratesidewall5.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}

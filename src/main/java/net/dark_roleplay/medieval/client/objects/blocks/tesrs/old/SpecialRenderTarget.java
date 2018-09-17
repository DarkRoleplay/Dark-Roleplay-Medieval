package net.dark_roleplay.medieval.client.objects.blocks.tesrs.old;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityTarget;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderTarget extends TileEntitySpecialRenderer<TileEntityTarget> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_target.png");

	private ModelTarget model;

	public SpecialRenderTarget() {
		this.model = new ModelTarget();
	}

	@Override
	public void render(TileEntityTarget tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = 0;
		if(state.getValue(FACING).equals(EnumFacing.NORTH))
			facing = 1;
		else if(state.getValue(FACING).equals(EnumFacing.EAST))
			facing = 2;
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH))
			facing = 3;
		else if(state.getValue(FACING).equals(EnumFacing.WEST)) facing = 4;

		GL11.glRotatef((facing + 1) * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelTarget extends ModelBase {

	// fields
	ModelRenderer Left3;
	ModelRenderer Center;
	ModelRenderer Top3;
	ModelRenderer Bottom3;
	ModelRenderer Right3;
	ModelRenderer Top1;
	ModelRenderer Bottom1;
	ModelRenderer Right1;
	ModelRenderer Left1;
	ModelRenderer Top2;
	ModelRenderer Right2;
	ModelRenderer Left2;
	ModelRenderer Bottom2;
	ModelRenderer Leg4;
	ModelRenderer Leg2;
	ModelRenderer Leg1;
	ModelRenderer Leg3;

	public ModelTarget() {
		textureWidth = 64;
		textureHeight = 32;

		Left3 = new ModelRenderer(this, 0, 12);
		Left3.addBox(11F, -4F, 0F, 1, 8, 1);
		Left3.setRotationPoint(0F, 4F, 0F);
		Left3.setTextureSize(64, 32);
		Left3.mirror = true;
		setRotation(Left3, 0.2617994F, 0F, 0F);
		Center = new ModelRenderer(this, 12, 7);
		Center.addBox(-9F, -9F, 0F, 18, 18, 1);
		Center.setRotationPoint(0F, 4F, 0F);
		Center.setTextureSize(64, 32);
		Center.mirror = true;
		setRotation(Center, 0.2617994F, 0F, 0F);
		Top3 = new ModelRenderer(this, 22, 1);
		Top3.addBox(-4F, -12F, 0F, 8, 1, 1);
		Top3.setRotationPoint(0F, 4F, 0F);
		Top3.setTextureSize(64, 32);
		Top3.mirror = true;
		setRotation(Top3, 0.2617994F, 0F, 0F);
		Bottom3 = new ModelRenderer(this, 22, 30);
		Bottom3.addBox(-4F, 11F, 0F, 8, 1, 1);
		Bottom3.setRotationPoint(0F, 4F, 0F);
		Bottom3.setTextureSize(64, 32);
		Bottom3.mirror = true;
		setRotation(Bottom3, 0.2617994F, 0F, 0F);
		Right3 = new ModelRenderer(this, 54, 0);
		Right3.addBox(-12F, -4F, 0F, 1, 8, 1);
		Right3.setRotationPoint(0F, 4F, 0F);
		Right3.setTextureSize(64, 32);
		Right3.mirror = true;
		setRotation(Right3, 0.2617994F, 0F, 0F);
		Top1 = new ModelRenderer(this, 12, 5);
		Top1.addBox(-9F, -10F, 0F, 18, 1, 1);
		Top1.setRotationPoint(0F, 4F, 0F);
		Top1.setTextureSize(64, 32);
		Top1.mirror = true;
		setRotation(Top1, 0.2617994F, 0F, 0F);
		Bottom1 = new ModelRenderer(this, 12, 26);
		Bottom1.addBox(-9F, 9F, 0F, 18, 1, 1);
		Bottom1.setRotationPoint(0F, 4F, 0F);
		Bottom1.setTextureSize(64, 32);
		Bottom1.mirror = true;
		setRotation(Bottom1, 0.2617994F, 0F, 0F);
		Right1 = new ModelRenderer(this, 50, 7);
		Right1.addBox(-10F, -9F, 0F, 1, 18, 1);
		Right1.setRotationPoint(0F, 4F, 0F);
		Right1.setTextureSize(64, 32);
		Right1.mirror = true;
		setRotation(Right1, 0.2617994F, 0F, 0F);
		Left1 = new ModelRenderer(this, 8, 7);
		Left1.addBox(9F, -9F, 0F, 1, 18, 1);
		Left1.setRotationPoint(0F, 4F, 0F);
		Left1.setTextureSize(64, 32);
		Left1.mirror = true;
		setRotation(Left1, 0.2617994F, 0F, 0F);
		Top2 = new ModelRenderer(this, 16, 3);
		Top2.addBox(-7F, -11F, 0F, 14, 1, 1);
		Top2.setRotationPoint(0F, 4F, 0F);
		Top2.setTextureSize(64, 32);
		Top2.mirror = true;
		setRotation(Top2, 0.2617994F, 0F, 0F);
		Right2 = new ModelRenderer(this, 54, 9);
		Right2.addBox(-11F, -7F, 0F, 1, 14, 1);
		Right2.setRotationPoint(0F, 4F, 0F);
		Right2.setTextureSize(64, 32);
		Right2.mirror = true;
		setRotation(Right2, 0.2617994F, 0F, 0F);
		Left2 = new ModelRenderer(this, 4, 9);
		Left2.addBox(10F, -7F, 0F, 1, 14, 1);
		Left2.setRotationPoint(0F, 4F, 0F);
		Left2.setTextureSize(64, 32);
		Left2.mirror = true;
		setRotation(Left2, 0.2617994F, 0F, 0F);
		Bottom2 = new ModelRenderer(this, 16, 28);
		Bottom2.addBox(-7F, 10F, 0F, 14, 1, 1);
		Bottom2.setRotationPoint(0F, 4F, 0F);
		Bottom2.setTextureSize(64, 32);
		Bottom2.mirror = true;
		setRotation(Bottom2, 0.2617994F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 58, 8);
		Leg4.addBox(-1F, 0F, 0F, 2, 13, 1);
		Leg4.setRotationPoint(0F, 4F, 0.7F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, -2.897247F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 58, 8);
		Leg2.addBox(-1F, 0F, 0F, 2, 23, 1);
		Leg2.setRotationPoint(0F, 4F, -0.2F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0.1570796F, 0F, 0.4014257F);
		Leg1 = new ModelRenderer(this, 58, 8);
		Leg1.addBox(-1F, 0F, 0F, 2, 23, 1);
		Leg1.setRotationPoint(0F, 4F, -0.2F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0.1570796F, 0F, -0.4014257F);
		Leg3 = new ModelRenderer(this, 58, 8);
		Leg3.addBox(-1F, 0F, 0F, 2, 23, 1);
		Leg3.setRotationPoint(0F, 4F, 0F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, -0.3839724F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Left3.render(f5);
		Center.render(f5);
		Top3.render(f5);
		Bottom3.render(f5);
		Right3.render(f5);
		Top1.render(f5);
		Bottom1.render(f5);
		Right1.render(f5);
		Left1.render(f5);
		Top2.render(f5);
		Right2.render(f5);
		Left2.render(f5);
		Bottom2.render(f5);
		Leg4.render(f5);
		Leg2.render(f5);
		Leg1.render(f5);
		Leg3.render(f5);
	}

	public void renderModel(float f5) {

		Left3.render(f5);
		Center.render(f5);
		Top3.render(f5);
		Bottom3.render(f5);
		Right3.render(f5);
		Top1.render(f5);
		Bottom1.render(f5);
		Right1.render(f5);
		Left1.render(f5);
		Top2.render(f5);
		Right2.render(f5);
		Left2.render(f5);
		Bottom2.render(f5);
		Leg4.render(f5);
		Leg2.render(f5);
		Leg1.render(f5);
		Leg3.render(f5);
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

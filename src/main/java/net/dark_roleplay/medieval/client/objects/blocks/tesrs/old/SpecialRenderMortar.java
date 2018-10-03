package net.dark_roleplay.medieval.client.objects.blocks.tesrs.old;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityMortar;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderMortar extends TileEntitySpecialRenderer<TileEntityMortar> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_mortar.png");

	private ModelMortar model;

	public SpecialRenderMortar() {
		this.model = new ModelMortar();
	}

	@Override
	public void render(TileEntityMortar tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
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

		GL11.glRotatef((facing + 2) * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelMortar extends ModelBase {
	// fields

	ModelRenderer Mortar;
	ModelRenderer Mortar1;
	ModelRenderer Mortar2;
	ModelRenderer Mortar3;
	ModelRenderer Mortar4;
	ModelRenderer Mortar5;
	ModelRenderer Mortar6;
	ModelRenderer Mortar7;
	ModelRenderer Mortar8;
	ModelRenderer Mortar9;
	ModelRenderer Mortar10;
	ModelRenderer Mortar11;
	ModelRenderer Mortar12;
	ModelRenderer Mortar13;
	ModelRenderer Mortar15;
	ModelRenderer Mortar16;
	ModelRenderer Mortar17;
	ModelRenderer Mortar18;
	ModelRenderer Mortar20;
	ModelRenderer Pestle1;
	ModelRenderer Pestle2;
	ModelRenderer Pestle5;
	ModelRenderer Pestle3;
	ModelRenderer Pestle;
	ModelRenderer Pestle4;

	public ModelMortar() {
		textureWidth = 32;
		textureHeight = 32;

		Mortar = new ModelRenderer(this, 12, 0);
		Mortar.addBox(0F, 0F, 0F, 1, 3, 5);
		Mortar.setRotationPoint(-3.9F, 20F, -2.466667F);
		Mortar.setTextureSize(32, 32);
		Mortar.mirror = true;
		setRotation(Mortar, 0F, 0F, 0F);
		Mortar1 = new ModelRenderer(this, 0, 14);
		Mortar1.addBox(0F, 0F, 0F, 5, 3, 1);
		Mortar1.setRotationPoint(-2.5F, 20F, -3.9F);
		Mortar1.setTextureSize(32, 32);
		Mortar1.mirror = true;
		setRotation(Mortar1, 0F, 0F, 0F);
		Mortar2 = new ModelRenderer(this, 0, 10);
		Mortar2.addBox(0F, 0F, 0F, 5, 3, 1);
		Mortar2.setRotationPoint(-2.5F, 20F, 2.9F);
		Mortar2.setTextureSize(32, 32);
		Mortar2.mirror = true;
		setRotation(Mortar2, 0F, 0F, 0F);
		Mortar3 = new ModelRenderer(this, 18, 21);
		Mortar3.addBox(-1F, 0F, 0F, 1, 3, 2);
		Mortar3.setRotationPoint(-1.8F, 20F, -3.2F);
		Mortar3.setTextureSize(32, 32);
		Mortar3.mirror = true;
		setRotation(Mortar3, 0F, -0.7853982F, 0F);
		Mortar4 = new ModelRenderer(this, 4, 20);
		Mortar4.addBox(0F, 0F, -1F, 1, 1, 1);
		Mortar4.setRotationPoint(-2.7F, 23F, -2F);
		Mortar4.setTextureSize(32, 32);
		Mortar4.mirror = true;
		setRotation(Mortar4, 0F, 0.7853982F, 0F);
		Mortar5 = new ModelRenderer(this, 12, 16);
		Mortar5.addBox(0F, 0F, -1F, 1, 3, 2);
		Mortar5.setRotationPoint(2.5F, 20F, -2.5F);
		Mortar5.setTextureSize(32, 32);
		Mortar5.mirror = true;
		setRotation(Mortar5, 0F, 0.7853982F, 0F);
		Mortar6 = new ModelRenderer(this, 0, 24);
		Mortar6.addBox(0F, 0F, 0F, 5, 1, 1);
		Mortar6.setRotationPoint(-2.5F, 23F, 2.5F);
		Mortar6.setTextureSize(32, 32);
		Mortar6.mirror = true;
		setRotation(Mortar6, 0F, 0F, 0F);
		Mortar7 = new ModelRenderer(this, 12, 8);
		Mortar7.addBox(0F, 0F, 0F, 1, 3, 5);
		Mortar7.setRotationPoint(2.9F, 20F, -2.5F);
		Mortar7.setTextureSize(32, 32);
		Mortar7.mirror = true;
		setRotation(Mortar7, 0F, 0F, 0F);
		Mortar8 = new ModelRenderer(this, 4, 18);
		Mortar8.addBox(-1F, 0F, 0F, 1, 1, 1);
		Mortar8.setRotationPoint(-2.7F, 23F, 2F);
		Mortar8.setTextureSize(32, 32);
		Mortar8.mirror = true;
		setRotation(Mortar8, 0F, 0.7853982F, 0F);
		Mortar9 = new ModelRenderer(this, 0, 22);
		Mortar9.addBox(0F, 0F, 0F, 5, 1, 1);
		Mortar9.setRotationPoint(-2.5F, 23F, -3.5F);
		Mortar9.setTextureSize(32, 32);
		Mortar9.mirror = true;
		setRotation(Mortar9, 0F, 0F, 0F);
		Mortar10 = new ModelRenderer(this, 0, 26);
		Mortar10.addBox(0F, 0F, 0F, 7, 1, 5);
		Mortar10.setRotationPoint(-3.5F, 23F, -2.5F);
		Mortar10.setTextureSize(32, 32);
		Mortar10.mirror = true;
		setRotation(Mortar10, 0F, 0F, 0F);
		Mortar11 = new ModelRenderer(this, 12, 21);
		Mortar11.addBox(-1F, 0F, 0F, 1, 3, 2);
		Mortar11.setRotationPoint(-3.2F, 20F, 1.8F);
		Mortar11.setTextureSize(32, 32);
		Mortar11.mirror = true;
		setRotation(Mortar11, 0F, 0.7853982F, 0F);
		Mortar12 = new ModelRenderer(this, 0, 4);
		Mortar12.addBox(0F, 0F, 0F, 1, 1, 5);
		Mortar12.setRotationPoint(-3.2F, 22.3F, -2.5F);
		Mortar12.setTextureSize(32, 32);
		Mortar12.mirror = true;
		setRotation(Mortar12, 0F, 0F, 0.7853982F);
		Mortar13 = new ModelRenderer(this, 0, 2);
		Mortar13.addBox(0F, 0F, 0F, 5, 1, 1);
		Mortar13.setRotationPoint(-2.5F, 22.3F, -3.2F);
		Mortar13.setTextureSize(32, 32);
		Mortar13.mirror = true;
		setRotation(Mortar13, -0.7853982F, 0F, 0F);
		Mortar15 = new ModelRenderer(this, 0, 4);
		Mortar15.addBox(0F, 0F, 0F, 1, 1, 5);
		Mortar15.setRotationPoint(2.5F, 23F, -2.5F);
		Mortar15.setTextureSize(32, 32);
		Mortar15.mirror = true;
		setRotation(Mortar15, 0F, 0F, -0.7853982F);
		Mortar16 = new ModelRenderer(this, 0, 20);
		Mortar16.addBox(0F, 0F, -1F, 1, 1, 1);
		Mortar16.setRotationPoint(2.7F, 23F, -2F);
		Mortar16.setTextureSize(32, 32);
		Mortar16.mirror = true;
		setRotation(Mortar16, 0F, 0.7853982F, 0F);
		Mortar17 = new ModelRenderer(this, 18, 17);
		Mortar17.addBox(0F, 0F, 0F, 2, 3, 1);
		Mortar17.setRotationPoint(1.8F, 20F, 3.2F);
		Mortar17.setTextureSize(32, 32);
		Mortar17.mirror = true;
		setRotation(Mortar17, 0F, 0.7853982F, 0F);
		Mortar18 = new ModelRenderer(this, 0, 18);
		Mortar18.addBox(0F, 0F, 0F, 1, 1, 1);
		Mortar18.setRotationPoint(2F, 23F, 2.7F);
		Mortar18.setTextureSize(32, 32);
		Mortar18.mirror = true;
		setRotation(Mortar18, 0F, 0.7853982F, 0F);
		Mortar20 = new ModelRenderer(this, 0, 2);
		Mortar20.addBox(0F, 0F, 0F, 5, 1, 1);
		Mortar20.setRotationPoint(-2.5F, 23F, 2.5F);
		Mortar20.setTextureSize(32, 32);
		Mortar20.mirror = true;
		setRotation(Mortar20, 0.7853982F, 0F, 0F);
		Pestle1 = new ModelRenderer(this, 28, 23);
		Pestle1.addBox(-0.1F, -0.2F, 0.1F, 1, 1, 1);
		Pestle1.setRotationPoint(-0.2F, 18F, -3.5F);
		Pestle1.setTextureSize(32, 32);
		Pestle1.mirror = true;
		setRotation(Pestle1, 0.3839724F, 0.7504916F, 0.3665191F);
		Pestle2 = new ModelRenderer(this, 24, 29);
		Pestle2.addBox(0F, 3.5F, 0.3F, 1, 2, 1);
		Pestle2.setRotationPoint(0F, 18F, -4F);
		Pestle2.setTextureSize(32, 32);
		Pestle2.mirror = true;
		setRotation(Pestle2, 0.5235988F, 0F, 0F);
		Pestle5 = new ModelRenderer(this, 24, 26);
		Pestle5.addBox(0.3F, 3.5F, 0F, 1, 2, 1);
		Pestle5.setRotationPoint(0F, 18F, -4F);
		Pestle5.setTextureSize(32, 32);
		Pestle5.mirror = true;
		setRotation(Pestle5, 0.5235988F, 0F, 0F);
		Pestle3 = new ModelRenderer(this, 24, 23);
		Pestle3.addBox(0F, 3.5F, -0.3F, 1, 2, 1);
		Pestle3.setRotationPoint(0F, 18F, -4F);
		Pestle3.setTextureSize(32, 32);
		Pestle3.mirror = true;
		setRotation(Pestle3, 0.5235988F, 0F, 0F);
		Pestle = new ModelRenderer(this, 28, 25);
		Pestle.addBox(0F, 0F, 0F, 1, 6, 1);
		Pestle.setRotationPoint(0F, 18F, -4F);
		Pestle.setTextureSize(32, 32);
		Pestle.mirror = true;
		setRotation(Pestle, 0.5235988F, 0F, 0F);
		Pestle4 = new ModelRenderer(this, 24, 20);
		Pestle4.addBox(-0.3F, 3.5F, 0F, 1, 2, 1);
		Pestle4.setRotationPoint(0F, 18F, -4F);
		Pestle4.setTextureSize(32, 32);
		Pestle4.mirror = true;
		setRotation(Pestle4, 0.5235988F, 0F, 0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Mortar.render(f5);
		Mortar1.render(f5);
		Mortar2.render(f5);
		Mortar3.render(f5);
		Mortar4.render(f5);
		Mortar5.render(f5);
		Mortar6.render(f5);
		Mortar7.render(f5);
		Mortar8.render(f5);
		Mortar9.render(f5);
		Mortar10.render(f5);
		Mortar11.render(f5);
		Mortar12.render(f5);
		Mortar13.render(f5);
		Mortar15.render(f5);
		Mortar16.render(f5);
		Mortar17.render(f5);
		Mortar18.render(f5);
		Mortar20.render(f5);
		Pestle1.render(f5);
		Pestle2.render(f5);
		Pestle5.render(f5);
		Pestle3.render(f5);
		Pestle.render(f5);
		Pestle4.render(f5);

	}

	public void renderModel(float f5) {

		Mortar.render(f5);
		Mortar1.render(f5);
		Mortar2.render(f5);
		Mortar3.render(f5);
		Mortar4.render(f5);
		Mortar5.render(f5);
		Mortar6.render(f5);
		Mortar7.render(f5);
		Mortar8.render(f5);
		Mortar9.render(f5);
		Mortar10.render(f5);
		Mortar11.render(f5);
		Mortar12.render(f5);
		Mortar13.render(f5);
		Mortar15.render(f5);
		Mortar16.render(f5);
		Mortar17.render(f5);
		Mortar18.render(f5);
		Mortar20.render(f5);
		Pestle1.render(f5);
		Pestle2.render(f5);
		Pestle5.render(f5);
		Pestle3.render(f5);
		Pestle.render(f5);
		Pestle4.render(f5);

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
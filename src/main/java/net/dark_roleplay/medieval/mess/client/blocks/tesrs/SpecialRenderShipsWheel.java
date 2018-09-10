package net.dark_roleplay.medieval.mess.client.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityShipsWheel;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderShipsWheel extends TileEntitySpecialRenderer<TileEntityShipsWheel> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_ship_steering_wheel.png");

	private ModelShipSteeringWheel model;

	public SpecialRenderShipsWheel() {
		this.model = new ModelShipSteeringWheel();
	}

	@Override
	public void render(TileEntityShipsWheel tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.SHIPS_HELM)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
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

			GL11.glRotatef((facing - 1) * 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
		}
	}

}

class ModelShipSteeringWheel extends ModelBase {

	// fields
	ModelRenderer Center2;
	ModelRenderer Axis;
	ModelRenderer Handle8;
	ModelRenderer Center1;
	ModelRenderer Handle3;
	ModelRenderer Handle4;
	ModelRenderer Handle6;
	ModelRenderer Handle7;
	ModelRenderer Wheel1;
	ModelRenderer Handle1;
	ModelRenderer Wheel2;
	ModelRenderer Wheel6;
	ModelRenderer Wheel7;
	ModelRenderer Wheel8;
	ModelRenderer Wheel9;
	ModelRenderer Wheel10;
	ModelRenderer Wheel11;
	ModelRenderer Wheel12;
	ModelRenderer Wheel13;
	ModelRenderer Wheel14;
	ModelRenderer Wheel15;
	ModelRenderer Wheel16;
	ModelRenderer Wheel17;
	ModelRenderer Wheel18;
	ModelRenderer Wheel19;
	ModelRenderer Wheel20;
	ModelRenderer Wheel21;
	ModelRenderer Wheel22;
	ModelRenderer Wheel23;
	ModelRenderer Wheel24;
	ModelRenderer Wheel25;
	ModelRenderer Wheel26;
	ModelRenderer Wheel27;
	ModelRenderer Wheel28;
	ModelRenderer Wheel29;
	ModelRenderer Wheel30;
	ModelRenderer Wheel31;
	ModelRenderer Wheel32;
	ModelRenderer Wheel5;
	ModelRenderer Wheel4;
	ModelRenderer Wheel3;
	ModelRenderer Handle2;
	ModelRenderer Handle5;

	public ModelShipSteeringWheel() {
		textureWidth = 32;
		textureHeight = 32;

		Center2 = new ModelRenderer(this, 0, 18);
		Center2.addBox(-1.5F, -1.5F, 0F, 3, 3, 2);
		Center2.setRotationPoint(0F, 0F, 2F);
		Center2.setTextureSize(32, 32);
		Center2.mirror = true;
		setRotation(Center2, 0F, 0F, 0.7853982F);
		Axis = new ModelRenderer(this, 0, 23);
		Axis.addBox(0F, 0F, 0F, 2, 2, 7);
		Axis.setRotationPoint(-1F, -1F, 1.5F);
		Axis.setTextureSize(32, 32);
		Axis.mirror = true;
		setRotation(Axis, 0F, 0F, 0F);
		Handle8 = new ModelRenderer(this, 22, 17);
		Handle8.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle8.setRotationPoint(0F, 0F, 3F);
		Handle8.setTextureSize(32, 32);
		Handle8.mirror = true;
		setRotation(Handle8, 0F, 0F, -2.356194F);
		Center1 = new ModelRenderer(this, 0, 18);
		Center1.addBox(-1.5F, -1.5F, 0F, 3, 3, 2);
		Center1.setRotationPoint(0F, 0F, 2F);
		Center1.setTextureSize(32, 32);
		Center1.mirror = true;
		setRotation(Center1, 0F, 0F, 0F);
		Handle3 = new ModelRenderer(this, 22, 17);
		Handle3.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle3.setRotationPoint(0F, 0F, 3F);
		Handle3.setTextureSize(32, 32);
		Handle3.mirror = true;
		setRotation(Handle3, 0F, 0F, 1.570796F);
		Handle4 = new ModelRenderer(this, 18, 17);
		Handle4.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle4.setRotationPoint(0F, 0F, 3F);
		Handle4.setTextureSize(32, 32);
		Handle4.mirror = true;
		setRotation(Handle4, 0F, 0F, 0.7853982F);
		Handle6 = new ModelRenderer(this, 22, 17);
		Handle6.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle6.setRotationPoint(0F, 0F, 3F);
		Handle6.setTextureSize(32, 32);
		Handle6.mirror = true;
		setRotation(Handle6, 0F, 0F, -0.7853982F);
		Handle7 = new ModelRenderer(this, 18, 17);
		Handle7.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle7.setRotationPoint(0F, 0F, 3F);
		Handle7.setTextureSize(32, 32);
		Handle7.mirror = true;
		setRotation(Handle7, 0F, 0F, -1.570796F);
		Wheel1 = new ModelRenderer(this, 0, 14);
		Wheel1.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel1.setRotationPoint(0F, 0F, 3F);
		Wheel1.setTextureSize(32, 32);
		Wheel1.mirror = true;
		setRotation(Wheel1, 0F, 0F, -3.14392F);
		Handle1 = new ModelRenderer(this, 18, 17);
		Handle1.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle1.setRotationPoint(0F, 0F, 3F);
		Handle1.setTextureSize(32, 32);
		Handle1.mirror = true;
		setRotation(Handle1, 0F, 0F, -3.141593F);
		Wheel2 = new ModelRenderer(this, 0, 10);
		Wheel2.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel2.setRotationPoint(0F, 0F, 3F);
		Wheel2.setTextureSize(32, 32);
		Wheel2.mirror = true;
		setRotation(Wheel2, 0F, 0F, 2.96706F);
		Wheel6 = new ModelRenderer(this, 0, 10);
		Wheel6.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel6.setRotationPoint(0F, 0F, 3F);
		Wheel6.setTextureSize(32, 32);
		Wheel6.mirror = true;
		setRotation(Wheel6, 0F, 0F, 2.146755F);
		Wheel7 = new ModelRenderer(this, 0, 6);
		Wheel7.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel7.setRotationPoint(0F, 0F, 3F);
		Wheel7.setTextureSize(32, 32);
		Wheel7.mirror = true;
		setRotation(Wheel7, 0F, 0F, 1.954769F);
		Wheel8 = new ModelRenderer(this, 0, 10);
		Wheel8.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel8.setRotationPoint(0F, 0F, 3F);
		Wheel8.setTextureSize(32, 32);
		Wheel8.mirror = true;
		setRotation(Wheel8, 0F, 0F, 1.762782F);
		Wheel9 = new ModelRenderer(this, 0, 14);
		Wheel9.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel9.setRotationPoint(0F, 0F, 3F);
		Wheel9.setTextureSize(32, 32);
		Wheel9.mirror = true;
		setRotation(Wheel9, 0F, 0F, 1.570796F);
		Wheel10 = new ModelRenderer(this, 0, 10);
		Wheel10.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel10.setRotationPoint(0F, 0F, 3F);
		Wheel10.setTextureSize(32, 32);
		Wheel10.mirror = true;
		setRotation(Wheel10, 0F, 0F, 1.37881F);
		Wheel11 = new ModelRenderer(this, 0, 6);
		Wheel11.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel11.setRotationPoint(0F, 0F, 3F);
		Wheel11.setTextureSize(32, 32);
		Wheel11.mirror = true;
		setRotation(Wheel11, 0F, 0F, 1.186824F);
		Wheel12 = new ModelRenderer(this, 0, 10);
		Wheel12.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel12.setRotationPoint(0F, 0F, 3F);
		Wheel12.setTextureSize(32, 32);
		Wheel12.mirror = true;
		setRotation(Wheel12, 0F, 0F, 0.9948377F);
		Wheel13 = new ModelRenderer(this, 0, 14);
		Wheel13.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel13.setRotationPoint(0F, 0F, 3F);
		Wheel13.setTextureSize(32, 32);
		Wheel13.mirror = true;
		setRotation(Wheel13, 0F, 0F, 0.7853982F);
		Wheel14 = new ModelRenderer(this, 0, 10);
		Wheel14.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel14.setRotationPoint(0F, 0F, 3F);
		Wheel14.setTextureSize(32, 32);
		Wheel14.mirror = true;
		setRotation(Wheel14, 0F, 0F, 0.5759587F);
		Wheel15 = new ModelRenderer(this, 0, 14);
		Wheel15.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel15.setRotationPoint(0F, 0F, 3F);
		Wheel15.setTextureSize(32, 32);
		Wheel15.mirror = true;
		setRotation(Wheel15, 0F, 0F, 0.3839724F);
		Wheel16 = new ModelRenderer(this, 0, 10);
		Wheel16.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel16.setRotationPoint(0F, 0F, 3F);
		Wheel16.setTextureSize(32, 32);
		Wheel16.mirror = true;
		setRotation(Wheel16, 0F, 0F, 0.1919862F);
		Wheel17 = new ModelRenderer(this, 0, 14);
		Wheel17.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel17.setRotationPoint(0F, 0F, 3F);
		Wheel17.setTextureSize(32, 32);
		Wheel17.mirror = true;
		setRotation(Wheel17, 0F, 0F, 0F);
		Wheel18 = new ModelRenderer(this, 0, 10);
		Wheel18.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel18.setRotationPoint(0F, 0F, 3F);
		Wheel18.setTextureSize(32, 32);
		Wheel18.mirror = true;
		setRotation(Wheel18, 0F, 0F, -0.1919862F);
		Wheel19 = new ModelRenderer(this, 0, 6);
		Wheel19.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel19.setRotationPoint(0F, 0F, 3F);
		Wheel19.setTextureSize(32, 32);
		Wheel19.mirror = true;
		setRotation(Wheel19, 0F, 0F, -0.3839724F);
		Wheel20 = new ModelRenderer(this, 0, 10);
		Wheel20.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel20.setRotationPoint(0F, 0F, 3F);
		Wheel20.setTextureSize(32, 32);
		Wheel20.mirror = true;
		setRotation(Wheel20, 0F, 0F, -0.5759587F);
		Wheel21 = new ModelRenderer(this, 0, 14);
		Wheel21.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel21.setRotationPoint(0F, 0F, 3F);
		Wheel21.setTextureSize(32, 32);
		Wheel21.mirror = true;
		setRotation(Wheel21, 0F, 0F, -0.7853982F);
		Wheel22 = new ModelRenderer(this, 0, 10);
		Wheel22.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel22.setRotationPoint(0F, 0F, 3F);
		Wheel22.setTextureSize(32, 32);
		Wheel22.mirror = true;
		setRotation(Wheel22, 0F, 0F, -0.9948377F);
		Wheel23 = new ModelRenderer(this, 0, 6);
		Wheel23.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel23.setRotationPoint(0F, 0F, 3F);
		Wheel23.setTextureSize(32, 32);
		Wheel23.mirror = true;
		setRotation(Wheel23, 0F, 0F, -1.186824F);
		Wheel24 = new ModelRenderer(this, 0, 10);
		Wheel24.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel24.setRotationPoint(0F, 0F, 3F);
		Wheel24.setTextureSize(32, 32);
		Wheel24.mirror = true;
		setRotation(Wheel24, 0F, 0F, -1.37881F);
		Wheel25 = new ModelRenderer(this, 0, 14);
		Wheel25.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel25.setRotationPoint(0F, 0F, 3F);
		Wheel25.setTextureSize(32, 32);
		Wheel25.mirror = true;
		setRotation(Wheel25, 0F, 0F, -1.570796F);
		Wheel26 = new ModelRenderer(this, 0, 10);
		Wheel26.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel26.setRotationPoint(0F, 0F, 3F);
		Wheel26.setTextureSize(32, 32);
		Wheel26.mirror = true;
		setRotation(Wheel26, 0F, 0F, -1.762782F);
		Wheel27 = new ModelRenderer(this, 0, 6);
		Wheel27.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel27.setRotationPoint(0F, 0F, 3F);
		Wheel27.setTextureSize(32, 32);
		Wheel27.mirror = true;
		setRotation(Wheel27, 0F, 0F, -1.954769F);
		Wheel28 = new ModelRenderer(this, 0, 10);
		Wheel28.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel28.setRotationPoint(0F, 0F, 3F);
		Wheel28.setTextureSize(32, 32);
		Wheel28.mirror = true;
		setRotation(Wheel28, 0F, 0F, -2.146755F);
		Wheel29 = new ModelRenderer(this, 0, 14);
		Wheel29.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel29.setRotationPoint(0F, 0F, 3F);
		Wheel29.setTextureSize(32, 32);
		Wheel29.mirror = true;
		setRotation(Wheel29, 0F, 0F, -2.356194F);
		Wheel30 = new ModelRenderer(this, 0, 10);
		Wheel30.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel30.setRotationPoint(0F, 0F, 3F);
		Wheel30.setTextureSize(32, 32);
		Wheel30.mirror = true;
		setRotation(Wheel30, 0F, 0F, -2.565634F);
		Wheel31 = new ModelRenderer(this, 0, 6);
		Wheel31.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel31.setRotationPoint(0F, 0F, 3F);
		Wheel31.setTextureSize(32, 32);
		Wheel31.mirror = true;
		setRotation(Wheel31, 0F, 0F, -2.75762F);
		Wheel32 = new ModelRenderer(this, 0, 10);
		Wheel32.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel32.setRotationPoint(0F, 0F, 3F);
		Wheel32.setTextureSize(32, 32);
		Wheel32.mirror = true;
		setRotation(Wheel32, 0F, 0F, -2.949606F);
		Wheel5 = new ModelRenderer(this, 0, 14);
		Wheel5.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel5.setRotationPoint(0F, 0F, 3F);
		Wheel5.setTextureSize(32, 32);
		Wheel5.mirror = true;
		setRotation(Wheel5, 0F, 0F, 2.356194F);
		Wheel4 = new ModelRenderer(this, 0, 10);
		Wheel4.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel4.setRotationPoint(0F, 0F, 3F);
		Wheel4.setTextureSize(32, 32);
		Wheel4.mirror = true;
		setRotation(Wheel4, 0F, 0F, 2.565634F);
		Wheel3 = new ModelRenderer(this, 0, 6);
		Wheel3.addBox(-1F, 8F, -1F, 2, 2, 2);
		Wheel3.setRotationPoint(0F, 0F, 3F);
		Wheel3.setTextureSize(32, 32);
		Wheel3.mirror = true;
		setRotation(Wheel3, 0F, 0F, 2.75762F);
		Handle2 = new ModelRenderer(this, 26, 17);
		Handle2.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle2.setRotationPoint(0F, 0F, 3F);
		Handle2.setTextureSize(32, 32);
		Handle2.mirror = true;
		setRotation(Handle2, 0F, 0F, 2.356194F);
		Handle5 = new ModelRenderer(this, 26, 17);
		Handle5.addBox(-0.5F, -0.5F, -0.5F, 1, 14, 1);
		Handle5.setRotationPoint(0F, 0F, 3F);
		Handle5.setTextureSize(32, 32);
		Handle5.mirror = true;
		setRotation(Handle5, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Center2.render(f5);
		Axis.render(f5);
		Handle8.render(f5);
		Center1.render(f5);
		Handle3.render(f5);
		Handle4.render(f5);
		Handle6.render(f5);
		Handle7.render(f5);
		Wheel1.render(f5);
		Handle1.render(f5);
		Wheel2.render(f5);
		Wheel6.render(f5);
		Wheel7.render(f5);
		Wheel8.render(f5);
		Wheel9.render(f5);
		Wheel10.render(f5);
		Wheel11.render(f5);
		Wheel12.render(f5);
		Wheel13.render(f5);
		Wheel14.render(f5);
		Wheel15.render(f5);
		Wheel16.render(f5);
		Wheel17.render(f5);
		Wheel18.render(f5);
		Wheel19.render(f5);
		Wheel20.render(f5);
		Wheel21.render(f5);
		Wheel22.render(f5);
		Wheel23.render(f5);
		Wheel24.render(f5);
		Wheel25.render(f5);
		Wheel26.render(f5);
		Wheel27.render(f5);
		Wheel28.render(f5);
		Wheel29.render(f5);
		Wheel30.render(f5);
		Wheel31.render(f5);
		Wheel32.render(f5);
		Wheel5.render(f5);
		Wheel4.render(f5);
		Wheel3.render(f5);
		Handle2.render(f5);
		Handle5.render(f5);
	}

	public void renderModel(float f5) {

		Center2.render(f5);
		Axis.render(f5);
		Handle8.render(f5);
		Center1.render(f5);
		Handle3.render(f5);
		Handle4.render(f5);
		Handle6.render(f5);
		Handle7.render(f5);
		Wheel1.render(f5);
		Handle1.render(f5);
		Wheel2.render(f5);
		Wheel6.render(f5);
		Wheel7.render(f5);
		Wheel8.render(f5);
		Wheel9.render(f5);
		Wheel10.render(f5);
		Wheel11.render(f5);
		Wheel12.render(f5);
		Wheel13.render(f5);
		Wheel14.render(f5);
		Wheel15.render(f5);
		Wheel16.render(f5);
		Wheel17.render(f5);
		Wheel18.render(f5);
		Wheel19.render(f5);
		Wheel20.render(f5);
		Wheel21.render(f5);
		Wheel22.render(f5);
		Wheel23.render(f5);
		Wheel24.render(f5);
		Wheel25.render(f5);
		Wheel26.render(f5);
		Wheel27.render(f5);
		Wheel28.render(f5);
		Wheel29.render(f5);
		Wheel30.render(f5);
		Wheel31.render(f5);
		Wheel32.render(f5);
		Wheel5.render(f5);
		Wheel4.render(f5);
		Wheel3.render(f5);
		Handle2.render(f5);
		Handle5.render(f5);
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

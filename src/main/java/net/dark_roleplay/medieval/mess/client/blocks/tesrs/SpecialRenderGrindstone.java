package net.dark_roleplay.medieval.mess.client.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityGrindstone;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderGrindstone extends TileEntitySpecialRenderer<TileEntityGrindstone> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_grindstone.png");

	private ModelGrindstone model;

	public SpecialRenderGrindstone() {
		this.model = new ModelGrindstone();
	}

	@Override
	public void render(TileEntityGrindstone tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.GRINDSTONE)){
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

			GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
		}
	}

}

class ModelGrindstone extends ModelBase {

	// fields
	ModelRenderer Bein1;
	ModelRenderer Schleifstein9;
	ModelRenderer Bein2;
	ModelRenderer Schleifstein8;
	ModelRenderer Bein3;
	ModelRenderer Schleifstein7;
	ModelRenderer Bein4;
	ModelRenderer Schleifstein6;
	ModelRenderer Bein5;
	ModelRenderer Schleifstein5;
	ModelRenderer Bein6;
	ModelRenderer Schleifstein4;
	ModelRenderer Bein7;
	ModelRenderer Schleifstein1;
	ModelRenderer Bein8;
	ModelRenderer Schleifstein3;
	ModelRenderer Bein9;
	ModelRenderer Schleifstein2;
	ModelRenderer Bein10;
	ModelRenderer Mittelstange;
	ModelRenderer Bein11;
	ModelRenderer Bein22;
	ModelRenderer Bein12;
	ModelRenderer Bein21;
	ModelRenderer Bein13;
	ModelRenderer Bein20;
	ModelRenderer Bein14;
	ModelRenderer Bein19;
	ModelRenderer Bein15;
	ModelRenderer Bein18;
	ModelRenderer Bein16;
	ModelRenderer Bein17;

	public ModelGrindstone() {
		textureWidth = 128;
		textureHeight = 128;

		Bein1 = new ModelRenderer(this, 45, 90);
		Bein1.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein1.setRotationPoint(-6F, 18F, 5F);
		Bein1.setTextureSize(128, 128);
		Bein1.mirror = true;
		setRotation(Bein1, 0F, 0F, 0F);
		Schleifstein9 = new ModelRenderer(this, 0, 32);
		Schleifstein9.addBox(0F, 0F, 0F, 1, 6, 6);
		Schleifstein9.setRotationPoint(-7F, 13F, -3F);
		Schleifstein9.setTextureSize(128, 128);
		Schleifstein9.mirror = true;
		setRotation(Schleifstein9, 0F, 0F, 0F);
		Bein2 = new ModelRenderer(this, 71, 70);
		Bein2.addBox(0F, 0F, 0F, 4, 1, 2);
		Bein2.setRotationPoint(-2F, 14F, 5F);
		Bein2.setTextureSize(128, 128);
		Bein2.mirror = true;
		setRotation(Bein2, 0F, 0F, 0F);
		Schleifstein8 = new ModelRenderer(this, 39, 9);
		Schleifstein8.addBox(0F, 0F, 0F, 6, 1, 6);
		Schleifstein8.setRotationPoint(-3F, 9F, -3F);
		Schleifstein8.setTextureSize(128, 128);
		Schleifstein8.mirror = true;
		setRotation(Schleifstein8, 0F, 0F, 0F);
		Bein3 = new ModelRenderer(this, 40, 100);
		Bein3.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein3.setRotationPoint(-7F, 21F, -7F);
		Bein3.setTextureSize(128, 128);
		Bein3.mirror = true;
		setRotation(Bein3, 0F, 0F, 0F);
		Schleifstein7 = new ModelRenderer(this, 39, 58);
		Schleifstein7.addBox(0F, 0F, 0F, 6, 1, 6);
		Schleifstein7.setRotationPoint(-3F, 22F, -3F);
		Schleifstein7.setTextureSize(128, 128);
		Schleifstein7.mirror = true;
		setRotation(Schleifstein7, 0F, 0F, 0F);
		Bein4 = new ModelRenderer(this, 65, 80);
		Bein4.addBox(0F, 0F, 0F, 10, 2, 2);
		Bein4.setRotationPoint(-5F, 16F, -7F);
		Bein4.setTextureSize(128, 128);
		Bein4.mirror = true;
		setRotation(Bein4, 0F, 0F, 0F);
		Schleifstein6 = new ModelRenderer(this, 35, 49);
		Schleifstein6.addBox(0F, 0F, 0F, 10, 1, 6);
		Schleifstein6.setRotationPoint(-5F, 21F, -3F);
		Schleifstein6.setTextureSize(128, 128);
		Schleifstein6.mirror = true;
		setRotation(Schleifstein6, 0F, 0F, 0F);
		Bein5 = new ModelRenderer(this, 100, 100);
		Bein5.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein5.setRotationPoint(3F, 21F, 5F);
		Bein5.setTextureSize(128, 128);
		Bein5.mirror = true;
		setRotation(Bein5, 0F, 0F, 0F);
		Schleifstein5 = new ModelRenderer(this, 15, 30);
		Schleifstein5.addBox(0F, 0F, 0F, 1, 10, 6);
		Schleifstein5.setRotationPoint(-6F, 11F, -3F);
		Schleifstein5.setTextureSize(128, 128);
		Schleifstein5.mirror = true;
		setRotation(Schleifstein5, 0F, 0F, 0F);
		Bein6 = new ModelRenderer(this, 60, 90);
		Bein6.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein6.setRotationPoint(-2F, 18F, 5F);
		Bein6.setTextureSize(128, 128);
		Bein6.mirror = true;
		setRotation(Bein6, 0F, 0F, 0F);
		Schleifstein4 = new ModelRenderer(this, 35, 19);
		Schleifstein4.addBox(0F, 0F, 0F, 10, 1, 6);
		Schleifstein4.setRotationPoint(-5F, 10F, -3F);
		Schleifstein4.setTextureSize(128, 128);
		Schleifstein4.mirror = true;
		setRotation(Schleifstein4, 0F, 0F, 0F);
		Bein7 = new ModelRenderer(this, 95, 90);
		Bein7.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein7.setRotationPoint(2F, 18F, 5F);
		Bein7.setTextureSize(128, 128);
		Bein7.mirror = true;
		setRotation(Bein7, 0F, 0F, 0F);
		Schleifstein1 = new ModelRenderer(this, 75, 30);
		Schleifstein1.addBox(0F, 0F, 0F, 1, 10, 6);
		Schleifstein1.setRotationPoint(5F, 11F, -3F);
		Schleifstein1.setTextureSize(128, 128);
		Schleifstein1.mirror = true;
		setRotation(Schleifstein1, 0F, 0F, 0F);
		Bein8 = new ModelRenderer(this, 35, 95);
		Bein8.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein8.setRotationPoint(-7F, 20F, 5F);
		Bein8.setTextureSize(128, 128);
		Bein8.mirror = true;
		setRotation(Bein8, 0F, 0F, 0F);
		Schleifstein3 = new ModelRenderer(this, 91, 32);
		Schleifstein3.addBox(0F, 0F, 0F, 1, 6, 6);
		Schleifstein3.setRotationPoint(6F, 13F, -3F);
		Schleifstein3.setTextureSize(128, 128);
		Schleifstein3.mirror = true;
		setRotation(Schleifstein3, 0F, 0F, 0F);
		Bein9 = new ModelRenderer(this, 40, 100);
		Bein9.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein9.setRotationPoint(-7F, 21F, 5F);
		Bein9.setTextureSize(128, 128);
		Bein9.mirror = true;
		setRotation(Bein9, 0F, 0F, 0F);
		Schleifstein2 = new ModelRenderer(this, 35, 30);
		Schleifstein2.addBox(0F, 0F, 0F, 10, 10, 6);
		Schleifstein2.setRotationPoint(-5F, 11F, -3F);
		Schleifstein2.setTextureSize(128, 128);
		Schleifstein2.mirror = true;
		setRotation(Schleifstein2, 0F, 0F, 0F);
		Bein10 = new ModelRenderer(this, 85, 90);
		Bein10.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein10.setRotationPoint(1F, 18F, 5F);
		Bein10.setTextureSize(128, 128);
		Bein10.mirror = true;
		setRotation(Bein10, 0F, 0F, 0F);
		Mittelstange = new ModelRenderer(this, 3, 69);
		Mittelstange.addBox(-1F, -1F, 0F, 2, 2, 16);
		Mittelstange.setRotationPoint(0F, 16F, -8F);
		Mittelstange.setTextureSize(128, 128);
		Mittelstange.mirror = true;
		setRotation(Mittelstange, 0F, 0F, 0F);
		Bein11 = new ModelRenderer(this, 110, 95);
		Bein11.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein11.setRotationPoint(6F, 20F, 5F);
		Bein11.setTextureSize(128, 128);
		Bein11.mirror = true;
		setRotation(Bein11, 0F, 0F, 0F);
		Bein22 = new ModelRenderer(this, 71, 70);
		Bein22.addBox(0F, 0F, 0F, 4, 1, 2);
		Bein22.setRotationPoint(-2F, 14F, -7F);
		Bein22.setTextureSize(128, 128);
		Bein22.mirror = true;
		setRotation(Bein22, 0F, 0F, 0F);
		Bein12 = new ModelRenderer(this, 100, 100);
		Bein12.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein12.setRotationPoint(3F, 21F, -7F);
		Bein12.setTextureSize(128, 128);
		Bein12.mirror = true;
		setRotation(Bein12, 0F, 0F, 0F);
		Bein21 = new ModelRenderer(this, 67, 75);
		Bein21.addBox(0F, 0F, 0F, 8, 1, 2);
		Bein21.setRotationPoint(-4F, 15F, -7F);
		Bein21.setTextureSize(128, 128);
		Bein21.mirror = true;
		setRotation(Bein21, 0F, 0F, 0F);
		Bein13 = new ModelRenderer(this, 95, 90);
		Bein13.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein13.setRotationPoint(2F, 18F, -7F);
		Bein13.setTextureSize(128, 128);
		Bein13.mirror = true;
		setRotation(Bein13, 0F, 0F, 0F);
		Bein20 = new ModelRenderer(this, 67, 75);
		Bein20.addBox(0F, 0F, 0F, 8, 1, 2);
		Bein20.setRotationPoint(-4F, 15F, 5F);
		Bein20.setTextureSize(128, 128);
		Bein20.mirror = true;
		setRotation(Bein20, 0F, 0F, 0F);
		Bein14 = new ModelRenderer(this, 45, 90);
		Bein14.addBox(0F, 0F, 0F, 4, 3, 2);
		Bein14.setRotationPoint(-6F, 18F, -7F);
		Bein14.setTextureSize(128, 128);
		Bein14.mirror = true;
		setRotation(Bein14, 0F, 0F, 0F);
		Bein19 = new ModelRenderer(this, 65, 80);
		Bein19.addBox(0F, 0F, 0F, 10, 2, 2);
		Bein19.setRotationPoint(-5F, 16F, 5F);
		Bein19.setTextureSize(128, 128);
		Bein19.mirror = true;
		setRotation(Bein19, 0F, 0F, 0F);
		Bein15 = new ModelRenderer(this, 110, 95);
		Bein15.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein15.setRotationPoint(6F, 20F, -7F);
		Bein15.setTextureSize(128, 128);
		Bein15.mirror = true;
		setRotation(Bein15, 0F, 0F, 0F);
		Bein18 = new ModelRenderer(this, 60, 90);
		Bein18.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein18.setRotationPoint(-2F, 18F, -7F);
		Bein18.setTextureSize(128, 128);
		Bein18.mirror = true;
		setRotation(Bein18, 0F, 0F, 0F);
		Bein16 = new ModelRenderer(this, 35, 95);
		Bein16.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein16.setRotationPoint(-7F, 20F, -7F);
		Bein16.setTextureSize(128, 128);
		Bein16.mirror = true;
		setRotation(Bein16, 0F, 0F, 0F);
		Bein17 = new ModelRenderer(this, 85, 90);
		Bein17.addBox(0F, 0F, 0F, 1, 1, 2);
		Bein17.setRotationPoint(1F, 18F, -7F);
		Bein17.setTextureSize(128, 128);
		Bein17.mirror = true;
		setRotation(Bein17, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Bein1.render(f5);
		Schleifstein9.render(f5);
		Bein2.render(f5);
		Schleifstein8.render(f5);
		Bein3.render(f5);
		Schleifstein7.render(f5);
		Bein4.render(f5);
		Schleifstein6.render(f5);
		Bein5.render(f5);
		Schleifstein5.render(f5);
		Bein6.render(f5);
		Schleifstein4.render(f5);
		Bein7.render(f5);
		Schleifstein1.render(f5);
		Bein8.render(f5);
		Schleifstein3.render(f5);
		Bein9.render(f5);
		Schleifstein2.render(f5);
		Bein10.render(f5);
		Mittelstange.render(f5);
		Bein11.render(f5);
		Bein22.render(f5);
		Bein12.render(f5);
		Bein21.render(f5);
		Bein13.render(f5);
		Bein20.render(f5);
		Bein14.render(f5);
		Bein19.render(f5);
		Bein15.render(f5);
		Bein18.render(f5);
		Bein16.render(f5);
		Bein17.render(f5);
	}

	public void renderModel(float f5) {

		Bein1.render(f5);
		Schleifstein9.render(f5);
		Bein2.render(f5);
		Schleifstein8.render(f5);
		Bein3.render(f5);
		Schleifstein7.render(f5);
		Bein4.render(f5);
		Schleifstein6.render(f5);
		Bein5.render(f5);
		Schleifstein5.render(f5);
		Bein6.render(f5);
		Schleifstein4.render(f5);
		Bein7.render(f5);
		Schleifstein1.render(f5);
		Bein8.render(f5);
		Schleifstein3.render(f5);
		Bein9.render(f5);
		Schleifstein2.render(f5);
		Bein10.render(f5);
		Mittelstange.render(f5);
		Bein11.render(f5);
		Bein22.render(f5);
		Bein12.render(f5);
		Bein21.render(f5);
		Bein13.render(f5);
		Bein20.render(f5);
		Bein14.render(f5);
		Bein19.render(f5);
		Bein15.render(f5);
		Bein18.render(f5);
		Bein16.render(f5);
		Bein17.render(f5);
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

package net.drpmedieval.common.blocks.specialrenderer;

import org.lwjgl.opengl.GL11;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderBookOne extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/oldBlocks/blockBookOne.png");

	private ModelBookOne model;

	public SpecialRenderBookOne() {
		this.model = new ModelBookOne();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.bookOne)){
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

			GL11.glRotatef(facing * 90 -45, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
		}
	}

}

class ModelBookOne extends ModelBase {

	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;

	public ModelBookOne() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 8);
		Shape1.addBox(0F, 0F, 0F, 10, 2, 6);
		Shape1.setRotationPoint(-5.2F, 21F, 1.1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0.7435722F, 0F);
		Shape2 = new ModelRenderer(this, 0, 16);
		Shape2.addBox(0F, 0F, 0F, 11, 1, 7);
		Shape2.setRotationPoint(-6F, 20F, 1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0.7435722F, 0F);
		Shape3 = new ModelRenderer(this, 0, 4);
		Shape3.addBox(0F, 0F, 0F, 11, 3, 1);
		Shape3.setRotationPoint(-1.6F, 20.5F, 5.8F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0.7435722F, 0F);
		Shape4 = new ModelRenderer(this, 0, 24);
		Shape4.addBox(0F, 0F, 0F, 11, 1, 7);
		Shape4.setRotationPoint(-6F, 23F, 1F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0.7435722F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
	}

	public void renderModel(float f5) {

		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
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

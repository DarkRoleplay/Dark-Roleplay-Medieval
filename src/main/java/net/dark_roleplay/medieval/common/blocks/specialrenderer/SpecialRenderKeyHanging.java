package net.dark_roleplay.medieval.common.blocks.specialrenderer;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.DRPInfo;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderKeyHanging extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(DRPInfo.MODID, "textures/old_blocks/block_key_hanging.png");

	private ModelKeyHanging model;

	public SpecialRenderKeyHanging() {
		this.model = new ModelKeyHanging();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.KEY_HANGING)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.3F, (float) z + 0.5F);
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

class ModelKeyHanging extends ModelBase {

	// fields
	ModelRenderer Shape8;
	ModelRenderer Shape12;
	ModelRenderer Shape9;
	ModelRenderer Shape4;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape1;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape11;
	ModelRenderer Shape10;

	public ModelKeyHanging() {
		textureWidth = 32;
		textureHeight = 32;

		Shape8 = new ModelRenderer(this, 0, 8);
		Shape8.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape8.setRotationPoint(0.5F, 18F, 6F);
		Shape8.setTextureSize(32, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0.7853982F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 28);
		Shape12.addBox(-3F, 0F, 0F, 3, 1, 1);
		Shape12.setRotationPoint(0.5F, 7.5F, 6F);
		Shape12.setTextureSize(32, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0.7853982F, 0F, -0.7853982F);
		Shape9 = new ModelRenderer(this, 0, 6);
		Shape9.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape9.setRotationPoint(0.5F, 15.5F, 6F);
		Shape9.setTextureSize(32, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0.7853982F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 26);
		Shape4.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape4.setRotationPoint(0.5F, 7.5F, 6F);
		Shape4.setTextureSize(32, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0.7853982F, 0F, 0.7853982F);
		Shape2 = new ModelRenderer(this, 10, 28);
		Shape2.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape2.setRotationPoint(0F, 9F, 5F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 10, 26);
		Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape3.setRotationPoint(0F, 8F, 5F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 18);
		Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape1.setRotationPoint(-1.4F, 9.1F, 6F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0.7853982F, 0F, 1.570796F);
		Shape5 = new ModelRenderer(this, 0, 22);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape5.setRotationPoint(0F, 7.7F, 6F);
		Shape5.setTextureSize(32, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0.7853982F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 30);
		Shape6.addBox(-3F, 0F, 0F, 3, 1, 1);
		Shape6.setRotationPoint(0.5F, 11.7F, 6F);
		Shape6.setTextureSize(32, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0.7853982F, 0F, 0.7853982F);
		Shape7 = new ModelRenderer(this, 0, 10);
		Shape7.addBox(0F, 0F, 0F, 1, 7, 1);
		Shape7.setRotationPoint(-0.2F, 11.7F, 6.7F);
		Shape7.setTextureSize(32, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0.7853982F, 0F);
		Shape11 = new ModelRenderer(this, 0, 24);
		Shape11.addBox(0F, -1F, 0F, 3, 1, 1);
		Shape11.setRotationPoint(1F, 12.2F, 6.7F);
		Shape11.setTextureSize(32, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0.7853982F, 0F, -0.7853982F);
		Shape10 = new ModelRenderer(this, 0, 20);
		Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape10.setRotationPoint(2.4F, 9.1F, 6F);
		Shape10.setTextureSize(32, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0.7853982F, 0F, 1.570796F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape8.render(f5);
		Shape12.render(f5);
		Shape9.render(f5);
		Shape4.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape1.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape11.render(f5);
		Shape10.render(f5);
	}

	public void renderModel(float f5) {

		Shape8.render(f5);
		Shape12.render(f5);
		Shape9.render(f5);
		Shape4.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape1.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape11.render(f5);
		Shape10.render(f5);
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

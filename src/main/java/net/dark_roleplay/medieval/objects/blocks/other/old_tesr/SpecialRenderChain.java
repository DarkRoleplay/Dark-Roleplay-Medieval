package net.dark_roleplay.medieval.objects.blocks.other.old_tesr;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.References;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderChain extends TileEntitySpecialRenderer<TileEntityChain> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_chain.png");

	private ModelChain model;

	public SpecialRenderChain() {
		this.model = new ModelChain();
	}

	@Override
	public void render(TileEntityChain tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
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

// Unimportant Stuff
class ModelChain extends ModelBase {

	// fields
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape18;
	ModelRenderer Shape15;
	ModelRenderer Shape14;
	ModelRenderer Shape13;
	ModelRenderer Shape12;
	ModelRenderer Shape11;
	ModelRenderer Shape10;
	ModelRenderer Shape9;
	ModelRenderer Shape8;
	ModelRenderer Shape7;
	ModelRenderer Shape6;
	ModelRenderer Shape5;
	ModelRenderer Shape4;
	ModelRenderer Shape3;
	ModelRenderer Shape2;
	ModelRenderer Shape1;

	public ModelChain() {
		textureWidth = 64;
		textureHeight = 32;

		Shape16 = new ModelRenderer(this, 30, 28);
		Shape16.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape16.setRotationPoint(0F, 21.5F, -1.5F);
		Shape16.setTextureSize(64, 32);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0.7853982F);
		Shape17 = new ModelRenderer(this, 30, 26);
		Shape17.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape17.setRotationPoint(-1.5F, 20.8F, -0.7F);
		Shape17.setTextureSize(64, 32);
		Shape17.mirror = true;
		setRotation(Shape17, 0.7853982F, 0F, 0F);
		Shape18 = new ModelRenderer(this, 0, 27);
		Shape18.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape18.setRotationPoint(-2.2F, 20.8F, 0F);
		Shape18.setTextureSize(64, 32);
		Shape18.mirror = true;
		setRotation(Shape18, 0F, 0.7853982F, 0F);
		Shape15 = new ModelRenderer(this, 4, 9);
		Shape15.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape15.setRotationPoint(-0.7F, 10F, -1.5F);
		Shape15.setTextureSize(64, 32);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0.7853982F, 0F);
		Shape14 = new ModelRenderer(this, 30, 24);
		Shape14.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape14.setRotationPoint(-1.5F, 18.6F, -0.7F);
		Shape14.setTextureSize(64, 32);
		Shape14.mirror = true;
		setRotation(Shape14, 0.7853982F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 30, 20);
		Shape13.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape13.setRotationPoint(0F, 16.5F, -1.5F);
		Shape13.setTextureSize(64, 32);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0.7853982F);
		Shape12 = new ModelRenderer(this, 30, 8);
		Shape12.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape12.setRotationPoint(-1.5F, 11.4F, -0.7F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0.7853982F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 4, 27);
		Shape11.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape11.setRotationPoint(0.8F, 20.8F, 0F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0.7853982F, 0F);
		Shape10 = new ModelRenderer(this, 0, 4);
		Shape10.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape10.setRotationPoint(-2.2F, 7.4F, 0F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0.7853982F, 0F);
		Shape9 = new ModelRenderer(this, 4, 4);
		Shape9.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape9.setRotationPoint(0.8F, 7.4F, 0F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0.7853982F, 0F);
		Shape8 = new ModelRenderer(this, 30, 12);
		Shape8.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape8.setRotationPoint(0F, 9.3F, -1.5F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0.7853982F);
		Shape7 = new ModelRenderer(this, 0, 9);
		Shape7.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape7.setRotationPoint(-0.7F, 10F, 1.5F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0.7853982F, 0F);
		Shape6 = new ModelRenderer(this, 4, 15);
		Shape6.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape6.setRotationPoint(-0.7F, 17.2F, -1.5F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0.7853982F, 0F);
		Shape5 = new ModelRenderer(this, 0, 15);
		Shape5.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape5.setRotationPoint(-0.7F, 17.2F, 1.5F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0.7853982F, 0F);
		Shape4 = new ModelRenderer(this, 30, 16);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape4.setRotationPoint(0F, 14.3F, -1.5F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0.7853982F);
		Shape3 = new ModelRenderer(this, 30, 10);
		Shape3.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape3.setRotationPoint(-1.5F, 13.6F, -0.7F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0.7853982F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 21);
		Shape2.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape2.setRotationPoint(-2.2F, 13.6F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0.7853982F, 0F);
		Shape1 = new ModelRenderer(this, 4, 21);
		Shape1.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape1.setRotationPoint(0.8F, 13.6F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0.7853982F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape15.render(f5);
		Shape14.render(f5);
		Shape13.render(f5);
		Shape12.render(f5);
		Shape11.render(f5);
		Shape10.render(f5);
		Shape9.render(f5);
		Shape8.render(f5);
		Shape7.render(f5);
		Shape6.render(f5);
		Shape5.render(f5);
		Shape4.render(f5);
		Shape3.render(f5);
		Shape2.render(f5);
		Shape1.render(f5);
	}

	public void renderModel(float f5) {

		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape15.render(f5);
		Shape14.render(f5);
		Shape13.render(f5);
		Shape12.render(f5);
		Shape11.render(f5);
		Shape10.render(f5);
		Shape9.render(f5);
		Shape8.render(f5);
		Shape7.render(f5);
		Shape6.render(f5);
		Shape5.render(f5);
		Shape4.render(f5);
		Shape3.render(f5);
		Shape2.render(f5);
		Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, Entity entity, float f4, float f5) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}

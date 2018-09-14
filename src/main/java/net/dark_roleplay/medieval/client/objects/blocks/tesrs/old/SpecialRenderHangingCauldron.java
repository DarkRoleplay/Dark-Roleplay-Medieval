package net.dark_roleplay.medieval.client.objects.blocks.tesrs.old;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityHangingCauldron;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderHangingCauldron extends TileEntitySpecialRenderer<TileEntityHangingCauldron> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_cauldron.png");

	private ModelCauldron model;

	public SpecialRenderHangingCauldron() {
		this.model = new ModelCauldron();
	}

	@Override
	public void render(TileEntityHangingCauldron tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
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
		facing++;

		GL11.glRotatef((facing + 1) * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}
}

class ModelCauldron extends ModelBase {

	// fields
	ModelRenderer Cauldron1;
	ModelRenderer Cauldron2;
	ModelRenderer Cauldron3;
	ModelRenderer Cauldron4;
	ModelRenderer Cauldron5;
	ModelRenderer Cauldron6;
	ModelRenderer Cauldron7;
	ModelRenderer Cauldron8;
	ModelRenderer Cauldron9;
	ModelRenderer Cauldron10;
	ModelRenderer Cauldron11;
	ModelRenderer Cauldron12;
	ModelRenderer Cauldron13;
	ModelRenderer Cauldron14;
	ModelRenderer Cauldron15;
	ModelRenderer Cauldron16;
	ModelRenderer Cauldron17;
	ModelRenderer Cauldron18;
	ModelRenderer Cauldron19;
	ModelRenderer Cauldron20;
	ModelRenderer Cauldron21;
	ModelRenderer Cauldron22;
	ModelRenderer Cauldron23;
	ModelRenderer Cauldron24;
	ModelRenderer Cauldron25;
	ModelRenderer Cauldron26;
	ModelRenderer Cauldron27;
	ModelRenderer Cauldron28;
	ModelRenderer Cauldron29;
	ModelRenderer Cauldron30;
	ModelRenderer Cauldron31;
	ModelRenderer Cauldron32;
	ModelRenderer Cauldron33;
	ModelRenderer Cauldron34;
	ModelRenderer Cauldron35;
	ModelRenderer Cauldron36;
	ModelRenderer Cauldron37;
	ModelRenderer Cauldron38;
	ModelRenderer Cauldron39;

	public ModelCauldron() {
		textureWidth = 128;
		textureHeight = 64;

		Cauldron1 = new ModelRenderer(this, 80, 56);
		Cauldron1.addBox(0F, 0F, 0F, 8, 1, 1);
		Cauldron1.setRotationPoint(-4F, 9F, -6F);
		Cauldron1.setTextureSize(128, 64);
		Cauldron1.mirror = true;
		setRotation(Cauldron1, 0F, 0F, 0F);
		Cauldron2 = new ModelRenderer(this, 0, 30);
		Cauldron2.addBox(0F, 0F, 0F, 6, 6, 1);
		Cauldron2.setRotationPoint(-3F, 12F, -7F);
		Cauldron2.setTextureSize(128, 64);
		Cauldron2.mirror = true;
		setRotation(Cauldron2, 0F, 0F, 0F);
		Cauldron3 = new ModelRenderer(this, 40, 16);
		Cauldron3.addBox(0F, 0F, 0F, 1, 8, 10);
		Cauldron3.setRotationPoint(-6F, 11F, -5F);
		Cauldron3.setTextureSize(128, 64);
		Cauldron3.mirror = true;
		setRotation(Cauldron3, 0F, 0F, 0F);
		Cauldron4 = new ModelRenderer(this, 40, 4);
		Cauldron4.addBox(0F, 0F, 0F, 1, 6, 6);
		Cauldron4.setRotationPoint(-7F, 12F, -3F);
		Cauldron4.setTextureSize(128, 64);
		Cauldron4.mirror = true;
		setRotation(Cauldron4, 0F, 0F, 0F);
		Cauldron5 = new ModelRenderer(this, 0, 57);
		Cauldron5.addBox(0F, 0F, 0F, 6, 1, 6);
		Cauldron5.setRotationPoint(-3F, 20F, -3F);
		Cauldron5.setTextureSize(128, 64);
		Cauldron5.mirror = true;
		setRotation(Cauldron5, 0F, 0F, 0F);
		Cauldron6 = new ModelRenderer(this, 40, 34);
		Cauldron6.addBox(0F, 0F, 0F, 1, 6, 6);
		Cauldron6.setRotationPoint(6F, 12F, -3F);
		Cauldron6.setTextureSize(128, 64);
		Cauldron6.mirror = true;
		setRotation(Cauldron6, 0F, 0F, 0F);
		Cauldron7 = new ModelRenderer(this, 0, 14);
		Cauldron7.addBox(0F, 0F, 0F, 6, 6, 1);
		Cauldron7.setRotationPoint(-3F, 12F, 6F);
		Cauldron7.setTextureSize(128, 64);
		Cauldron7.mirror = true;
		setRotation(Cauldron7, 0F, 0F, 0F);
		Cauldron8 = new ModelRenderer(this, 40, 46);
		Cauldron8.addBox(0F, 0F, 0F, 1, 8, 10);
		Cauldron8.setRotationPoint(5F, 11F, -5F);
		Cauldron8.setTextureSize(128, 64);
		Cauldron8.mirror = true;
		setRotation(Cauldron8, 0F, 0F, 0F);
		Cauldron9 = new ModelRenderer(this, 32, 8);
		Cauldron9.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron9.setRotationPoint(4F, 9F, -5F);
		Cauldron9.setTextureSize(128, 64);
		Cauldron9.mirror = true;
		setRotation(Cauldron9, 0F, 0F, 0F);
		Cauldron10 = new ModelRenderer(this, 62, 55);
		Cauldron10.addBox(0F, 0F, 0F, 1, 1, 8);
		Cauldron10.setRotationPoint(-5F, 10F, -4F);
		Cauldron10.setTextureSize(128, 64);
		Cauldron10.mirror = true;
		setRotation(Cauldron10, 0F, 0F, 0F);
		Cauldron11 = new ModelRenderer(this, 36, 8);
		Cauldron11.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron11.setRotationPoint(-5F, 9F, -5F);
		Cauldron11.setTextureSize(128, 64);
		Cauldron11.mirror = true;
		setRotation(Cauldron11, 0F, 0F, 0F);
		Cauldron12 = new ModelRenderer(this, 0, 11);
		Cauldron12.addBox(0F, 0F, 0F, 2, 2, 1);
		Cauldron12.setRotationPoint(-0.5F, 8.5F, 5.5F);
		Cauldron12.setTextureSize(128, 64);
		Cauldron12.mirror = true;
		setRotation(Cauldron12, 0F, 0F, 0F);
		Cauldron13 = new ModelRenderer(this, 0, 37);
		Cauldron13.addBox(0F, 0F, 0F, 10, 8, 1);
		Cauldron13.setRotationPoint(-5F, 11F, -6F);
		Cauldron13.setTextureSize(128, 64);
		Cauldron13.mirror = true;
		setRotation(Cauldron13, 0F, 0F, 0F);
		Cauldron14 = new ModelRenderer(this, 24, 20);
		Cauldron14.addBox(0F, 0F, 0F, 1, 1, 4);
		Cauldron14.setRotationPoint(0F, -0.5F, -6.8F);
		Cauldron14.setTextureSize(128, 64);
		Cauldron14.mirror = true;
		setRotation(Cauldron14, 0.5061455F, 0F, 0F);
		Cauldron15 = new ModelRenderer(this, 0, 21);
		Cauldron15.addBox(0F, 0F, 0F, 10, 8, 1);
		Cauldron15.setRotationPoint(-5F, 11F, 5F);
		Cauldron15.setTextureSize(128, 64);
		Cauldron15.mirror = true;
		setRotation(Cauldron15, 0F, 0F, 0F);
		Cauldron16 = new ModelRenderer(this, 24, 12);
		Cauldron16.addBox(0F, 0F, 0F, 1, 1, 7);
		Cauldron16.setRotationPoint(0F, -2.5F, -3.5F);
		Cauldron16.setTextureSize(128, 64);
		Cauldron16.mirror = true;
		setRotation(Cauldron16, 0F, 0F, 0F);
		Cauldron17 = new ModelRenderer(this, 24, 32);
		Cauldron17.addBox(0F, 0F, 0F, 1, 3, 1);
		Cauldron17.setRotationPoint(0F, 0.2F, 6.2F);
		Cauldron17.setTextureSize(128, 64);
		Cauldron17.mirror = true;
		setRotation(Cauldron17, 0.7853982F, 0F, 0F);
		Cauldron18 = new ModelRenderer(this, 30, 30);
		Cauldron18.addBox(0F, 0F, 0F, 1, 7, 1);
		Cauldron18.setRotationPoint(0F, 1.6F, 8F);
		Cauldron18.setTextureSize(128, 64);
		Cauldron18.mirror = true;
		setRotation(Cauldron18, 0F, 0F, 0F);
		Cauldron19 = new ModelRenderer(this, 30, 38);
		Cauldron19.addBox(0F, 0F, 0F, 1, 7, 1);
		Cauldron19.setRotationPoint(0F, 1.6F, -8.9F);
		Cauldron19.setTextureSize(128, 64);
		Cauldron19.mirror = true;
		setRotation(Cauldron19, 0F, 0F, 0F);
		Cauldron20 = new ModelRenderer(this, 24, 43);
		Cauldron20.addBox(0F, 0F, 0F, 1, 1, 2);
		Cauldron20.setRotationPoint(0F, 9.3F, 6.8F);
		Cauldron20.setTextureSize(128, 64);
		Cauldron20.mirror = true;
		setRotation(Cauldron20, 0.7853982F, 0F, 0F);
		Cauldron21 = new ModelRenderer(this, 62, 46);
		Cauldron21.addBox(0F, 0F, 0F, 1, 1, 8);
		Cauldron21.setRotationPoint(-6F, 9F, -4F);
		Cauldron21.setTextureSize(128, 64);
		Cauldron21.mirror = true;
		setRotation(Cauldron21, 0F, 0F, 0F);
		Cauldron22 = new ModelRenderer(this, 24, 40);
		Cauldron22.addBox(0F, 0F, 0F, 1, 1, 2);
		Cauldron22.setRotationPoint(0F, 10F, -7.5F);
		Cauldron22.setTextureSize(128, 64);
		Cauldron22.mirror = true;
		setRotation(Cauldron22, 2.356194F, 0F, 0F);
		Cauldron23 = new ModelRenderer(this, 24, 6);
		Cauldron23.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron23.setRotationPoint(0F, 9F, -7.5F);
		Cauldron23.setTextureSize(128, 64);
		Cauldron23.mirror = true;
		setRotation(Cauldron23, 0F, 0F, 0F);
		Cauldron24 = new ModelRenderer(this, 24, 4);
		Cauldron24.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron24.setRotationPoint(0F, 9F, 6.5F);
		Cauldron24.setTextureSize(128, 64);
		Cauldron24.mirror = true;
		setRotation(Cauldron24, 0F, 0F, 0F);
		Cauldron25 = new ModelRenderer(this, 0, 8);
		Cauldron25.addBox(0F, 0F, 0F, 2, 2, 1);
		Cauldron25.setRotationPoint(-0.5F, 8.5F, -6.5F);
		Cauldron25.setTextureSize(128, 64);
		Cauldron25.mirror = true;
		setRotation(Cauldron25, 0F, 0F, 0F);
		Cauldron26 = new ModelRenderer(this, 24, 36);
		Cauldron26.addBox(0F, 0F, 0F, 1, 3, 1);
		Cauldron26.setRotationPoint(0F, -0.5F, -6.8F);
		Cauldron26.setTextureSize(128, 64);
		Cauldron26.mirror = true;
		setRotation(Cauldron26, -0.7853982F, 0F, 0F);
		Cauldron27 = new ModelRenderer(this, 80, 58);
		Cauldron27.addBox(0F, 0F, 0F, 8, 1, 1);
		Cauldron27.setRotationPoint(-4F, 10F, -5F);
		Cauldron27.setTextureSize(128, 64);
		Cauldron27.mirror = true;
		setRotation(Cauldron27, 0F, 0F, 0F);
		Cauldron28 = new ModelRenderer(this, 24, 25);
		Cauldron28.addBox(0F, 0F, 0F, 1, 1, 4);
		Cauldron28.setRotationPoint(0F, -2.4F, 3.4F);
		Cauldron28.setTextureSize(128, 64);
		Cauldron28.mirror = true;
		setRotation(Cauldron28, -0.5061455F, 0F, 0F);
		Cauldron29 = new ModelRenderer(this, 0, 46);
		Cauldron29.addBox(0F, 0F, 0F, 10, 1, 10);
		Cauldron29.setRotationPoint(-5F, 19F, -5F);
		Cauldron29.setTextureSize(128, 64);
		Cauldron29.mirror = true;
		setRotation(Cauldron29, 0F, 0F, 0F);
		Cauldron30 = new ModelRenderer(this, 28, 10);
		Cauldron30.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron30.setRotationPoint(4F, 11F, 4F);
		Cauldron30.setTextureSize(128, 64);
		Cauldron30.mirror = true;
		setRotation(Cauldron30, 0F, 0F, 0F);
		Cauldron31 = new ModelRenderer(this, 24, 8);
		Cauldron31.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron31.setRotationPoint(-5F, 9F, 4F);
		Cauldron31.setTextureSize(128, 64);
		Cauldron31.mirror = true;
		setRotation(Cauldron31, 0F, 0F, 0F);
		Cauldron32 = new ModelRenderer(this, 32, 10);
		Cauldron32.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron32.setRotationPoint(4F, 11F, -5F);
		Cauldron32.setTextureSize(128, 64);
		Cauldron32.mirror = true;
		setRotation(Cauldron32, 0F, 0F, 0F);
		Cauldron33 = new ModelRenderer(this, 28, 8);
		Cauldron33.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron33.setRotationPoint(4F, 9F, 4F);
		Cauldron33.setTextureSize(128, 64);
		Cauldron33.mirror = true;
		setRotation(Cauldron33, 0F, 0F, 0F);
		Cauldron34 = new ModelRenderer(this, 36, 10);
		Cauldron34.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron34.setRotationPoint(-5F, 11F, -5F);
		Cauldron34.setTextureSize(128, 64);
		Cauldron34.mirror = true;
		setRotation(Cauldron34, 0F, 0F, 0F);
		Cauldron35 = new ModelRenderer(this, 62, 37);
		Cauldron35.addBox(0F, 0F, 0F, 1, 1, 8);
		Cauldron35.setRotationPoint(4F, 10F, -4F);
		Cauldron35.setTextureSize(128, 64);
		Cauldron35.mirror = true;
		setRotation(Cauldron35, 0F, 0F, 0F);
		Cauldron36 = new ModelRenderer(this, 24, 10);
		Cauldron36.addBox(0F, 0F, 0F, 1, 1, 1);
		Cauldron36.setRotationPoint(-5F, 11F, 4F);
		Cauldron36.setTextureSize(128, 64);
		Cauldron36.mirror = true;
		setRotation(Cauldron36, 0F, 0F, 0F);
		Cauldron37 = new ModelRenderer(this, 62, 28);
		Cauldron37.addBox(0F, 0F, 0F, 1, 1, 8);
		Cauldron37.setRotationPoint(5F, 9F, -4F);
		Cauldron37.setTextureSize(128, 64);
		Cauldron37.mirror = true;
		setRotation(Cauldron37, 0F, 0F, 0F);
		Cauldron38 = new ModelRenderer(this, 80, 60);
		Cauldron38.addBox(0F, 0F, 0F, 8, 1, 1);
		Cauldron38.setRotationPoint(-4F, 9F, 5F);
		Cauldron38.setTextureSize(128, 64);
		Cauldron38.mirror = true;
		setRotation(Cauldron38, 0F, 0F, 0F);
		Cauldron39 = new ModelRenderer(this, 80, 62);
		Cauldron39.addBox(0F, 0F, 0F, 8, 1, 1);
		Cauldron39.setRotationPoint(-4F, 10F, 4F);
		Cauldron39.setTextureSize(128, 64);
		Cauldron39.mirror = true;
		setRotation(Cauldron39, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Cauldron1.render(f5);
		Cauldron2.render(f5);
		Cauldron3.render(f5);
		Cauldron4.render(f5);
		Cauldron5.render(f5);
		Cauldron6.render(f5);
		Cauldron7.render(f5);
		Cauldron8.render(f5);
		Cauldron9.render(f5);
		Cauldron10.render(f5);
		Cauldron11.render(f5);
		Cauldron12.render(f5);
		Cauldron13.render(f5);
		Cauldron14.render(f5);
		Cauldron15.render(f5);
		Cauldron16.render(f5);
		Cauldron17.render(f5);
		Cauldron18.render(f5);
		Cauldron19.render(f5);
		Cauldron20.render(f5);
		Cauldron21.render(f5);
		Cauldron22.render(f5);
		Cauldron23.render(f5);
		Cauldron24.render(f5);
		Cauldron25.render(f5);
		Cauldron26.render(f5);
		Cauldron27.render(f5);
		Cauldron28.render(f5);
		Cauldron29.render(f5);
		Cauldron30.render(f5);
		Cauldron31.render(f5);
		Cauldron32.render(f5);
		Cauldron33.render(f5);
		Cauldron34.render(f5);
		Cauldron35.render(f5);
		Cauldron36.render(f5);
		Cauldron37.render(f5);
		Cauldron38.render(f5);
		Cauldron39.render(f5);
	}

	public void renderModel(float f5) {

		Cauldron1.render(f5);
		Cauldron2.render(f5);
		Cauldron3.render(f5);
		Cauldron4.render(f5);
		Cauldron5.render(f5);
		Cauldron6.render(f5);
		Cauldron7.render(f5);
		Cauldron8.render(f5);
		Cauldron9.render(f5);
		Cauldron10.render(f5);
		Cauldron11.render(f5);
		Cauldron12.render(f5);
		Cauldron13.render(f5);
		Cauldron14.render(f5);
		Cauldron15.render(f5);
		Cauldron16.render(f5);
		Cauldron17.render(f5);
		Cauldron18.render(f5);
		Cauldron19.render(f5);
		Cauldron20.render(f5);
		Cauldron21.render(f5);
		Cauldron22.render(f5);
		Cauldron23.render(f5);
		Cauldron24.render(f5);
		Cauldron25.render(f5);
		Cauldron26.render(f5);
		Cauldron27.render(f5);
		Cauldron28.render(f5);
		Cauldron29.render(f5);
		Cauldron30.render(f5);
		Cauldron31.render(f5);
		Cauldron32.render(f5);
		Cauldron33.render(f5);
		Cauldron34.render(f5);
		Cauldron35.render(f5);
		Cauldron36.render(f5);
		Cauldron37.render(f5);
		Cauldron38.render(f5);
		Cauldron39.render(f5);
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

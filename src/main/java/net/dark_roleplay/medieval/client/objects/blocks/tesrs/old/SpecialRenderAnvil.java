package net.dark_roleplay.medieval.client.objects.blocks.tesrs.old;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityAnvil;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderAnvil extends TileEntitySpecialRenderer<TileEntityAnvil> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_anvil.png");

	private ModelAnvil model;

	public SpecialRenderAnvil() {
		this.model = new ModelAnvil();
	}

	@Override  
	public void render(TileEntityAnvil tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 2F, (float) z + 0.5F);
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
	
		GL11.glRotatef((facing) * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		
		this.model.renderModel(0.08333333333333333333333333333333F);
	
		GL11.glPopMatrix();
	}

}

class ModelAnvil extends ModelBase {

	ModelRenderer Back5;
	ModelRenderer Base2;
	ModelRenderer Base4;
	ModelRenderer Front3;
	ModelRenderer Back2;
	ModelRenderer Head3;
	ModelRenderer Front1;
	ModelRenderer Front2;
	ModelRenderer Back3;
	ModelRenderer Back1;
	ModelRenderer Head1;
	ModelRenderer Head4;
	ModelRenderer Head2;
	ModelRenderer Base1;
	ModelRenderer Head5;
	ModelRenderer Back4;
	ModelRenderer Back7;
	ModelRenderer Back8;
	ModelRenderer Back6;
	ModelRenderer Base3;
	ModelRenderer Base5;
	ModelRenderer Hamer1;
	ModelRenderer Hamer2;
	ModelRenderer Hamer5;
	ModelRenderer Hamer4;
	ModelRenderer Hamer3;
	ModelRenderer Hamer6;

	public ModelAnvil() {
		textureWidth = 128;
		textureHeight = 64;

		Back5 = new ModelRenderer(this, 87, 13);
		Back5.addBox(0F, 0F, 0F, 1, 3, 2);
		Back5.setRotationPoint(1F, 13.5F, 6.5F);
		Back5.setTextureSize(128, 64);
		Back5.mirror = true;
		setRotation(Back5, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 26, 47);
		Base2.addBox(0F, 0F, 0F, 5, 1, 6);
		Base2.setRotationPoint(-2.5F, 21.5F, -3F);
		Base2.setTextureSize(128, 64);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 44, 39);
		Base4.addBox(0F, 0F, 0F, 1, 5, 3);
		Base4.setRotationPoint(0.8F, 17F, -1.5F);
		Base4.setTextureSize(128, 64);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Front3 = new ModelRenderer(this, 9, 3);
		Front3.addBox(-0.5F, 0F, -6F, 1, 1, 3);
		Front3.setRotationPoint(0F, 13.3F, -4.5F);
		Front3.setTextureSize(128, 64);
		Front3.mirror = true;
		setRotation(Front3, -0.1745329F, 0F, 0F);
		Back2 = new ModelRenderer(this, 53, 14);
		Back2.addBox(0F, 0F, 0F, 1, 2, 2);
		Back2.setRotationPoint(0.5F, 14F, 4.5F);
		Back2.setTextureSize(128, 64);
		Back2.mirror = true;
		setRotation(Back2, 0F, 0F, 0F);
		Head3 = new ModelRenderer(this, 54, 18);
		Head3.addBox(0F, 0F, 0F, 1, 3, 8);
		Head3.setRotationPoint(3F, 13.2F, -4F);
		Head3.setTextureSize(128, 64);
		Head3.mirror = true;
		setRotation(Head3, 0F, 0F, 0F);
		Front1 = new ModelRenderer(this, 6, 12);
		Front1.addBox(-2F, 0F, -2F, 4, 3, 3);
		Front1.setRotationPoint(0F, 13F, -4.5F);
		Front1.setTextureSize(128, 64);
		Front1.mirror = true;
		setRotation(Front1, -0.0872665F, 0F, 0F);
		Front2 = new ModelRenderer(this, 7, 7);
		Front2.addBox(-1.5F, 0F, -4F, 3, 2, 3);
		Front2.setRotationPoint(0F, 13.1F, -4.5F);
		Front2.setTextureSize(128, 64);
		Front2.mirror = true;
		setRotation(Front2, -0.122173F, 0F, 0F);
		Back3 = new ModelRenderer(this, 59, 13);
		Back3.addBox(0F, 0F, 0F, 2, 3, 2);
		Back3.setRotationPoint(-1F, 13.5F, 4.5F);
		Back3.setTextureSize(128, 64);
		Back3.mirror = true;
		setRotation(Back3, 0F, 0F, 0F);
		Back1 = new ModelRenderer(this, 67, 14);
		Back1.addBox(0F, 0F, 0F, 1, 2, 2);
		Back1.setRotationPoint(-1.5F, 14F, 4.5F);
		Back1.setTextureSize(128, 64);
		Back1.mirror = true;
		setRotation(Back1, 0F, 0F, 0F);
		Head1 = new ModelRenderer(this, 23, 29);
		Head1.addBox(0F, 0F, 0F, 6, 1, 8);
		Head1.setRotationPoint(-3F, 16.3F, -4F);
		Head1.setTextureSize(128, 64);
		Head1.mirror = true;
		setRotation(Head1, 0F, 0F, 0F);
		Head4 = new ModelRenderer(this, 4, 18);
		Head4.addBox(0F, 0F, 0F, 1, 3, 8);
		Head4.setRotationPoint(-4F, 13.2F, -4F);
		Head4.setTextureSize(128, 64);
		Head4.mirror = true;
		setRotation(Head4, 0F, 0F, 0F);
		Head2 = new ModelRenderer(this, 22, 16);
		Head2.addBox(0F, 0F, 0F, 7, 4, 9);
		Head2.setRotationPoint(-3.5F, 13F, -4.5F);
		Head2.setTextureSize(128, 64);
		Head2.mirror = true;
		setRotation(Head2, 0F, 0F, 0F);
		Base1 = new ModelRenderer(this, 22, 54);
		Base1.addBox(0F, 0F, 0F, 7, 2, 8);
		Base1.setRotationPoint(-3.5F, 22F, -4F);
		Base1.setTextureSize(128, 64);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Head5 = new ModelRenderer(this, 24, 7);
		Head5.addBox(0F, 0F, 0F, 6, 1, 8);
		Head5.setRotationPoint(-3F, 12.7F, -4F);
		Head5.setTextureSize(128, 64);
		Head5.mirror = true;
		setRotation(Head5, 0F, 0F, 0F);
		Back4 = new ModelRenderer(this, 78, 18);
		Back4.addBox(0F, 0F, 0F, 3, 1, 2);
		Back4.setRotationPoint(-1.5F, 16F, 6.5F);
		Back4.setTextureSize(128, 64);
		Back4.mirror = true;
		setRotation(Back4, 0F, 0F, 0F);
		Back7 = new ModelRenderer(this, 73, 13);
		Back7.addBox(0F, 0F, 0F, 1, 3, 2);
		Back7.setRotationPoint(-2F, 13.5F, 6.5F);
		Back7.setTextureSize(128, 64);
		Back7.mirror = true;
		setRotation(Back7, 0F, 0F, 0F);
		Back8 = new ModelRenderer(this, 79, 14);
		Back8.addBox(0F, 0F, 0F, 3, 3, 1);
		Back8.setRotationPoint(-1.5F, 13.5F, 7.7F);
		Back8.setTextureSize(128, 64);
		Back8.mirror = true;
		setRotation(Back8, 0F, 0F, 0F);
		Back6 = new ModelRenderer(this, 78, 11);
		Back6.addBox(0F, 0F, 0F, 3, 1, 2);
		Back6.setRotationPoint(-1.5F, 13F, 6.5F);
		Back6.setTextureSize(128, 64);
		Back6.mirror = true;
		setRotation(Back6, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 30, 38);
		Base3.addBox(0F, 0F, 0F, 3, 5, 4);
		Base3.setRotationPoint(-1.5F, 17F, -2F);
		Base3.setTextureSize(128, 64);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base5 = new ModelRenderer(this, 22, 39);
		Base5.addBox(0F, 0F, 0F, 1, 5, 3);
		Base5.setRotationPoint(-1.8F, 17F, -1.5F);
		Base5.setTextureSize(128, 64);
		Base5.mirror = true;
		setRotation(Base5, 0F, 0F, 0F);
		Hamer1 = new ModelRenderer(this, 0, 56);
		Hamer1.addBox(0F, 0F, -7F, 1, 1, 7);
		Hamer1.setRotationPoint(3F, 11.8F, 5F);
		Hamer1.setTextureSize(128, 64);
		Hamer1.mirror = true;
		setRotation(Hamer1, -0.0698132F, 0.6108652F, 0F);
		Hamer2 = new ModelRenderer(this, 4, 49);
		Hamer2.addBox(-1F, 0.1F, -9F, 3, 2, 2);
		Hamer2.setRotationPoint(3F, 11.2F, 5F);
		Hamer2.setTextureSize(128, 64);
		Hamer2.mirror = true;
		setRotation(Hamer2, -0.0872665F, 0.6108652F, 0F);
		Hamer5 = new ModelRenderer(this, 5, 53);
		Hamer5.addBox(-1F, 0.1F, -7.8F, 3, 2, 1);
		Hamer5.setRotationPoint(3F, 11.2F, 5F);
		Hamer5.setTextureSize(128, 64);
		Hamer5.mirror = true;
		setRotation(Hamer5, -0.0872665F, 0.6108652F, 0F);
		Hamer4 = new ModelRenderer(this, 5, 47);
		Hamer4.addBox(-1F, 0.1F, -9.2F, 3, 2, 1);
		Hamer4.setRotationPoint(3F, 11.2F, 5F);
		Hamer4.setTextureSize(128, 64);
		Hamer4.mirror = true;
		setRotation(Hamer4, -0.0872665F, 0.6108652F, 0F);
		Hamer3 = new ModelRenderer(this, 4, 44);
		Hamer3.addBox(-1F, 1.5F, -9F, 3, 1, 2);
		Hamer3.setRotationPoint(3F, 11F, 5F);
		Hamer3.setTextureSize(128, 64);
		Hamer3.mirror = true;
		setRotation(Hamer3, -0.0872665F, 0.6108652F, 0F);
		Hamer6 = new ModelRenderer(this, 4, 44);
		Hamer6.addBox(-1F, 0.1F, -9F, 3, 1, 2);
		Hamer6.setRotationPoint(3F, 11F, 5F);
		Hamer6.setTextureSize(128, 64);
		Hamer6.mirror = true;
		setRotation(Hamer6, -0.0872665F, 0.6108652F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Back5.render(f5);
		Base2.render(f5);
		Base4.render(f5);
		Front3.render(f5);
		Back2.render(f5);
		Head3.render(f5);
		Front1.render(f5);
		Front2.render(f5);
		Back3.render(f5);
		Back1.render(f5);
		Head1.render(f5);
		Head4.render(f5);
		Head2.render(f5);
		Base1.render(f5);
		Head5.render(f5);
		Back4.render(f5);
		Back7.render(f5);
		Back8.render(f5);
		Back6.render(f5);
		Base3.render(f5);
		Base5.render(f5);
		Hamer1.render(f5);
		Hamer2.render(f5);
		Hamer5.render(f5);
		Hamer4.render(f5);
		Hamer3.render(f5);
		Hamer6.render(f5);
	}

	public void renderModel(float f5) {

		Back5.render(f5);
		Base2.render(f5);
		Base4.render(f5);
		Front3.render(f5);
		Back2.render(f5);
		Head3.render(f5);
		Front1.render(f5);
		Front2.render(f5);
		Back3.render(f5);
		Back1.render(f5);
		Head1.render(f5);
		Head4.render(f5);
		Head2.render(f5);
		Base1.render(f5);
		Head5.render(f5);
		Back4.render(f5);
		Back7.render(f5);
		Back8.render(f5);
		Back6.render(f5);
		Base3.render(f5);
		Base5.render(f5);
		Hamer1.render(f5);
		Hamer2.render(f5);
		Hamer5.render(f5);
		Hamer4.render(f5);
		Hamer3.render(f5);
		Hamer6.render(f5);
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

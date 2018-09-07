package net.dark_roleplay.medieval.client.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.TileEntityHook;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderHook extends TileEntitySpecialRenderer<TileEntityHook> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_hook.png");

	private ModelHook model;

	public SpecialRenderHook() {
		this.model = new ModelHook();
	}

	@Override
	public void render(TileEntityHook tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.IRON_HOOK)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.3F, (float) z + 0.5F);
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

class ModelHook extends ModelBase {

	// fields
	ModelRenderer Hook1;
	ModelRenderer Hook3;
	ModelRenderer Hook4;
	ModelRenderer Hook5;
	ModelRenderer Hook6;
	ModelRenderer Hook7;
	ModelRenderer Hook8;
	ModelRenderer Hook9;
	ModelRenderer Hook10;
	ModelRenderer Hook11;
	ModelRenderer Chain1;
	ModelRenderer Chain2;

	public ModelHook() {
		textureWidth = 32;
		textureHeight = 32;

		Hook1 = new ModelRenderer(this, 4, 30);
		Hook1.addBox(0F, 0F, 0F, 2, 1, 1);
		Hook1.setRotationPoint(-0.5F, -1.5F, -0.5F);
		Hook1.setTextureSize(64, 32);
		Hook1.mirror = true;
		setRotation(Hook1, 0F, 0F, 0F);
		Hook3 = new ModelRenderer(this, 0, 28);
		Hook3.addBox(0F, 0F, 0F, 1, 1, 1);
		Hook3.setRotationPoint(1.5F, -2.5F, -0.5F);
		Hook3.setTextureSize(64, 32);
		Hook3.mirror = true;
		setRotation(Hook3, 0F, 0F, 0F);
		Hook4 = new ModelRenderer(this, 0, 30);
		Hook4.addBox(0F, 0F, 0F, 1, 1, 1);
		Hook4.setRotationPoint(1.7F, -2F, -0.5F);
		Hook4.setTextureSize(64, 32);
		Hook4.mirror = true;
		setRotation(Hook4, 0F, 0F, 0.7853982F);
		Hook5 = new ModelRenderer(this, 10, 26);
		Hook5.addBox(0F, 0F, 0F, 1, 3, 1);
		Hook5.setRotationPoint(-1.5F, -4.5F, -0.5F);
		Hook5.setTextureSize(64, 32);
		Hook5.mirror = true;
		setRotation(Hook5, 0F, 0F, 0F);
		Hook6 = new ModelRenderer(this, 6, 18);
		Hook6.addBox(0F, 0F, 0F, 2, 1, 2);
		Hook6.setRotationPoint(-0.8F, -8.6F, -1F);
		Hook6.setTextureSize(64, 32);
		Hook6.mirror = true;
		setRotation(Hook6, 0F, 0F, 0F);
		Hook7 = new ModelRenderer(this, 8, 21);
		Hook7.addBox(0F, 0F, 0F, 1, 2, 1);
		Hook7.setRotationPoint(-0.2F, -7.6F, -0.5F);
		Hook7.setTextureSize(64, 32);
		Hook7.mirror = true;
		setRotation(Hook7, 0F, 0F, 0F);
		Hook8 = new ModelRenderer(this, 8, 24);
		Hook8.addBox(0F, 0F, 0F, 2, 1, 1);
		Hook8.setRotationPoint(-1.4F, -4.7F, -0.5F);
		Hook8.setTextureSize(64, 32);
		Hook8.mirror = true;
		setRotation(Hook8, 0F, 0F, -0.7853982F);
		Hook9 = new ModelRenderer(this, 10, 30);
		Hook9.addBox(0F, 0F, 0F, 1, 1, 1);
		Hook9.setRotationPoint(-0.7F, -2F, -0.5F);
		Hook9.setTextureSize(64, 32);
		Hook9.mirror = true;
		setRotation(Hook9, 0F, 0F, 0.7853982F);
		Hook10 = new ModelRenderer(this, 0, 6);
		Hook10.addBox(0F, 0F, 0F, 5, 1, 5);
		Hook10.setRotationPoint(-2.4F, -9.6F, -2.5F);
		Hook10.setTextureSize(64, 32);
		Hook10.mirror = true;
		setRotation(Hook10, 0F, 0F, 0F);
		Hook11 = new ModelRenderer(this, 2, 12);
		Hook11.addBox(0F, 0F, 0F, 4, 2, 4);
		Hook11.setRotationPoint(-1.8F, -10.1F, -2F);
		Hook11.setTextureSize(64, 32);
		Hook11.mirror = true;
		setRotation(Hook11, 0F, 0F, 0F);
		Chain1 = new ModelRenderer(this, 5, 4);
		Chain1.addBox(0F, 0F, 0F, 1, 1, 1);
		Chain1.setRotationPoint(0.8F, -10.6F, 0F);
		Chain1.setTextureSize(64, 32);
		Chain1.mirror = true;
		setRotation(Chain1, 0F, 0.7853982F, 0F);
		Chain2 = new ModelRenderer(this, 11, 4);
		Chain2.addBox(0F, 0F, 0F, 1, 1, 1);
		Chain2.setRotationPoint(-2.2F, -10.6F, 0F);
		Chain2.setTextureSize(64, 32);
		Chain2.mirror = true;
		setRotation(Chain2, 0F, 0.7853982F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Hook1.render(f5);
		Hook3.render(f5);
		Hook4.render(f5);
		Hook5.render(f5);
		Hook6.render(f5);
		Hook7.render(f5);
		Hook8.render(f5);
		Hook9.render(f5);
		Hook10.render(f5);
		Hook11.render(f5);
		Chain1.render(f5);
		Chain2.render(f5);
	}

	public void renderModel(float f5) {

		Hook1.render(f5);
		Hook3.render(f5);
		Hook4.render(f5);
		Hook5.render(f5);
		Hook6.render(f5);
		Hook7.render(f5);
		Hook8.render(f5);
		Hook9.render(f5);
		Hook10.render(f5);
		Hook11.render(f5);
		Chain1.render(f5);
		Chain2.render(f5);
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

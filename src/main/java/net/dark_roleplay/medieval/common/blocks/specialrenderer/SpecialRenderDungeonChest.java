package net.dark_roleplay.medieval.common.blocks.specialrenderer;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
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

public class SpecialRenderDungeonChest extends TileEntitySpecialRenderer {

	public static Object instance;

	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/old_blocks/block_dungeon_chest.png");

	private ModelDungeonChest model;

	public SpecialRenderDungeonChest() {
		this.model = new ModelDungeonChest();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {

		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.DUNGEON_CHEST)){
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

			GL11.glRotatef(facing * 90 - 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
		}
	}

}

class ModelDungeonChest extends ModelBase {

	// fields
	ModelRenderer Chest10;
	ModelRenderer Chest9;
	ModelRenderer Chest8;
	ModelRenderer Chest7;
	ModelRenderer Chest6;
	ModelRenderer Chest1;
	ModelRenderer Chest2;
	ModelRenderer Chest3;
	ModelRenderer Chest4;
	ModelRenderer Chest5;

	public ModelDungeonChest() {
		textureWidth = 128;
		textureHeight = 64;

		Chest10 = new ModelRenderer(this, 56, 11);
		Chest10.addBox(-7F, -1F, 0F, 14, 1, 10);
		Chest10.setRotationPoint(0F, 13.5F, -5F);
		Chest10.setTextureSize(128, 64);
		Chest10.mirror = true;
		setRotation(Chest10, 0F, 0F, 0F);
		Chest9 = new ModelRenderer(this, 0, 22);
		Chest9.addBox(-7F, -1F, 0F, 14, 2, 12);
		Chest9.setRotationPoint(0F, 15F, -6F);
		Chest9.setTextureSize(128, 64);
		Chest9.mirror = true;
		setRotation(Chest9, 0F, 0F, 0F);
		Chest8 = new ModelRenderer(this, 0, 10);
		Chest8.addBox(-7F, -1F, 0F, 14, 1, 11);
		Chest8.setRotationPoint(0F, 14F, -5.5F);
		Chest8.setTextureSize(128, 64);
		Chest8.mirror = true;
		setRotation(Chest8, 0F, 0F, 0F);
		Chest7 = new ModelRenderer(this, 0, 0);
		Chest7.addBox(-7F, -1F, 0F, 14, 1, 6);
		Chest7.setRotationPoint(0F, 13F, -3F);
		Chest7.setTextureSize(128, 64);
		Chest7.mirror = true;
		setRotation(Chest7, 0F, 0F, 0F);
		Chest6 = new ModelRenderer(this, 0, 55);
		Chest6.addBox(0F, 0F, 0F, 12, 1, 8);
		Chest6.setRotationPoint(-6F, 23F, -4F);
		Chest6.setTextureSize(128, 64);
		Chest6.mirror = true;
		setRotation(Chest6, 0F, 0F, 0F);
		Chest1 = new ModelRenderer(this, 35, 40);
		Chest1.addBox(0F, 0F, 0F, 1, 8, 12);
		Chest1.setRotationPoint(6F, 16F, -6F);
		Chest1.setTextureSize(128, 64);
		Chest1.mirror = true;
		setRotation(Chest1, 0F, 0F, 0F);
		Chest2 = new ModelRenderer(this, 0, 37);
		Chest2.addBox(-1F, 0F, 0F, 2, 3, 1);
		Chest2.setRotationPoint(0F, 15F, -7F);
		Chest2.setTextureSize(128, 64);
		Chest2.mirror = true;
		setRotation(Chest2, 0F, 0F, 0F);
		Chest3 = new ModelRenderer(this, 0, 44);
		Chest3.addBox(0F, 0F, 0F, 12, 8, 1);
		Chest3.setRotationPoint(-6F, 16F, -6F);
		Chest3.setTextureSize(128, 64);
		Chest3.mirror = true;
		setRotation(Chest3, 0F, 0F, 0F);
		Chest4 = new ModelRenderer(this, 0, 44);
		Chest4.addBox(0F, 0F, 0F, 12, 8, 1);
		Chest4.setRotationPoint(-6F, 16F, 5F);
		Chest4.setTextureSize(128, 64);
		Chest4.mirror = true;
		setRotation(Chest4, 0F, 0F, 0F);
		Chest5 = new ModelRenderer(this, 35, 40);
		Chest5.addBox(0F, 0F, 0F, 1, 8, 12);
		Chest5.setRotationPoint(-7F, 16F, -6F);
		Chest5.setTextureSize(128, 64);
		Chest5.mirror = true;
		setRotation(Chest5, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Chest10.render(f5);
		Chest9.render(f5);
		Chest8.render(f5);
		Chest7.render(f5);
		Chest6.render(f5);
		Chest1.render(f5);
		Chest2.render(f5);
		Chest3.render(f5);
		Chest4.render(f5);
		Chest5.render(f5);
	}

	public void renderModel(float f) {

		Chest10.render(f);
		Chest9.render(f);
		Chest8.render(f);
		Chest7.render(f);
		Chest6.render(f);
		Chest1.render(f);
		Chest2.render(f);
		Chest3.render(f);
		Chest4.render(f);
		Chest5.render(f);
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

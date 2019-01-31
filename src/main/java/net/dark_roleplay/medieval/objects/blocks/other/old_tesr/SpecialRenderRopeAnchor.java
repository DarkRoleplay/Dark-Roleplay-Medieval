package net.dark_roleplay.medieval.objects.blocks.other.old_tesr;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpecialRenderRopeAnchor extends TileEntitySpecialRenderer<TileEntityRopeAnchor> {

	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/old_blocks/block_rope_anchor.png");

	private ModelRopeAnchor model;

	public SpecialRenderRopeAnchor() {
		this.model = new ModelRopeAnchor();
	}

	@Override
	public void render(TileEntityRopeAnchor tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){

			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);

			this.bindTexture(texture);

			this.model.renderBase(0.0625f);

			World worldIn = tileentity.getWorld();
			BlockPos pos = tileentity.getPos();

			Boolean North = worldIn.getBlockState(pos.add(0, -1, -1)).getBlock().equals(MedievalBlocks.ROPE);
			Boolean East = worldIn.getBlockState(pos.add(1, -1, 0)).getBlock().equals(MedievalBlocks.ROPE);
			Boolean South = worldIn.getBlockState(pos.add(0, -1, 1)).getBlock().equals(MedievalBlocks.ROPE);
			Boolean West = worldIn.getBlockState(pos.add(-1, -1, 0)).getBlock().equals(MedievalBlocks.ROPE);

			if(North){
				this.model.renderNorth(0.0625F);
			}
			if(East){
				this.model.renderEast(0.0625F);
			}
			if(South){
				this.model.renderSouth(0.0625F);
			}
			if(West){
				this.model.renderWest(0.0625F);
			}

			GL11.glPopMatrix();
	}

}

class ModelRopeAnchor extends ModelBase {

	// fields
	ModelRenderer Wood;
	ModelRenderer RopeEast1;
	ModelRenderer RopeNorth2;
	ModelRenderer RopeNorth;
	ModelRenderer RopeEast;
	ModelRenderer RopeWest1;
	ModelRenderer RopeSouth;
	ModelRenderer RopeSouth1;
	ModelRenderer RopeCenter;
	ModelRenderer RopeWest;

	public ModelRopeAnchor() {
		this.textureWidth = 32;
		this.textureHeight = 32;

		this.Wood = new ModelRenderer(this, 0, 0);
		this.Wood.addBox(-1.5F, 0F, -1.5F, 3, 5, 3);
		this.Wood.setRotationPoint(0F, 19F, 0F);
		this.Wood.setTextureSize(32, 32);
		this.Wood.mirror = true;
		this.setRotation(this.Wood, 0F, 0F, 0F);
		this.RopeEast1 = new ModelRenderer(this, 8, 19);
		this.RopeEast1.addBox(-1F, -0.3F, -1F, 2, 2, 2);
		this.RopeEast1.setRotationPoint(-8F, 24F, 0F);
		this.RopeEast1.setTextureSize(32, 32);
		this.RopeEast1.mirror = true;
		this.setRotation(this.RopeEast1, 0F, 0F, 2.216568F);
		this.RopeNorth2 = new ModelRenderer(this, 0, 19);
		this.RopeNorth2.addBox(-1F, -0.3F, -1F, 2, 2, 2);
		this.RopeNorth2.setRotationPoint(0F, 24F, -8F);
		this.RopeNorth2.setTextureSize(32, 32);
		this.RopeNorth2.mirror = true;
		this.setRotation(this.RopeNorth2, -2.216568F, 0F, 0F);
		this.RopeNorth = new ModelRenderer(this, 0, 23);
		this.RopeNorth.addBox(-1F, 0F, 0F, 2, 2, 7);
		this.RopeNorth.setRotationPoint(0F, 22F, -8.6F);
		this.RopeNorth.setTextureSize(32, 32);
		this.RopeNorth.mirror = true;
		this.setRotation(this.RopeNorth, 0.296706F, 0F, 0F);
		this.RopeEast = new ModelRenderer(this, 0, 15);
		this.RopeEast.addBox(0F, 0F, -1F, 7, 2, 2);
		this.RopeEast.setRotationPoint(-8.6F, 22F, 0F);
		this.RopeEast.setTextureSize(32, 32);
		this.RopeEast.mirror = true;
		this.setRotation(this.RopeEast, 0F, 0F, -0.296706F);
		this.RopeWest1 = new ModelRenderer(this, 8, 19);
		this.RopeWest1.addBox(-1F, -0.3F, -1F, 2, 2, 2);
		this.RopeWest1.setRotationPoint(8F, 24F, 0F);
		this.RopeWest1.setTextureSize(32, 32);
		this.RopeWest1.mirror = true;
		this.setRotation(this.RopeWest1, 0F, 0F, -2.216568F);
		this.RopeSouth = new ModelRenderer(this, 0, 23);
		this.RopeSouth.addBox(-1F, 0F, -7F, 2, 2, 7);
		this.RopeSouth.setRotationPoint(0F, 22F, 8.6F);
		this.RopeSouth.setTextureSize(32, 32);
		this.RopeSouth.mirror = true;
		this.setRotation(this.RopeSouth, -0.296706F, 0F, 0F);
		this.RopeSouth1 = new ModelRenderer(this, 0, 19);
		this.RopeSouth1.addBox(-1F, -1F, -0.3F, 2, 2, 2);
		this.RopeSouth1.setRotationPoint(0F, 24F, 8F);
		this.RopeSouth1.setTextureSize(32, 32);
		this.RopeSouth1.mirror = true;
		this.setRotation(this.RopeSouth1, 0.6457718F, 0F, 0F);
		this.RopeCenter = new ModelRenderer(this, 0, 9);
		this.RopeCenter.addBox(-2F, 0F, -2F, 4, 2, 4);
		this.RopeCenter.setRotationPoint(0F, 20F, 0F);
		this.RopeCenter.setTextureSize(32, 32);
		this.RopeCenter.mirror = true;
		this.setRotation(this.RopeCenter, 0F, 0F, 0F);
		this.RopeWest = new ModelRenderer(this, 0, 15);
		this.RopeWest.addBox(-7F, 0F, -1F, 7, 2, 2);
		this.RopeWest.setRotationPoint(8.6F, 22F, 0F);
		this.RopeWest.setTextureSize(32, 32);
		this.RopeWest.mirror = true;
		this.setRotation(this.RopeWest, 0F, 0F, 0.296706F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Wood.render(f5);
		this.RopeEast1.render(f5);
		this.RopeNorth2.render(f5);
		this.RopeNorth.render(f5);
		this.RopeEast.render(f5);
		this.RopeWest1.render(f5);
		this.RopeSouth.render(f5);
		this.RopeSouth1.render(f5);
		this.RopeCenter.render(f5);
		this.RopeWest.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderBase(float f5) {

		this.Wood.render(f5);
		this.RopeCenter.render(f5);
	}

	public void renderNorth(float f5) {

		this.RopeNorth2.render(f5);
		this.RopeNorth.render(f5);
	}

	public void renderEast(float f5) {

		this.RopeEast.render(f5);
		this.RopeEast1.render(f5);
	}

	public void renderSouth(float f5) {

		this.RopeSouth.render(f5);
		this.RopeSouth1.render(f5);
	}

	public void renderWest(float f5) {

		this.RopeWest.render(f5);
		this.RopeWest1.render(f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}

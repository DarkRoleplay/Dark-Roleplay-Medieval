package net.drpmedieval.common.blocks.specialrenderer;

import org.lwjgl.opengl.GL11;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SpecialRenderRopeAnchor  extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/oldBlocks/blockRopeAnchor.png");

	private ModelRopeAnchor model;

	public SpecialRenderRopeAnchor() {
		this.model = new ModelRopeAnchor();
	}
	
    @Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {
    	if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(DRPMedievalBlocks.ropeAnchor)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			this.bindTexture(texture);
			
			this.model.renderBase(0.0625f);
			
		    World worldIn = tileentity.getWorld();
		    BlockPos pos = tileentity.getPos();
			
		    Boolean North = worldIn.getBlockState(pos.add(0,-1,-1)).getBlock().equals(DRPMedievalBlocks.rope);
			Boolean East = worldIn.getBlockState(pos.add(1,-1,0)).getBlock().equals(DRPMedievalBlocks.rope);
			Boolean South = worldIn.getBlockState(pos.add(0,-1,1)).getBlock().equals(DRPMedievalBlocks.rope);
			Boolean West = worldIn.getBlockState(pos.add(-1,-1,0)).getBlock().equals(DRPMedievalBlocks.rope);
			
			
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

}

class ModelRopeAnchor extends ModelBase
{
  //fields
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
  
  public ModelRopeAnchor()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Wood = new ModelRenderer(this, 0, 0);
      Wood.addBox(-1.5F, 0F, -1.5F, 3, 5, 3);
      Wood.setRotationPoint(0F, 19F, 0F);
      Wood.setTextureSize(32, 32);
      Wood.mirror = true;
      setRotation(Wood, 0F, 0F, 0F);
      RopeEast1 = new ModelRenderer(this, 8, 19);
      RopeEast1.addBox(-1F, -0.3F, -1F, 2, 2, 2);
      RopeEast1.setRotationPoint(-8F, 24F, 0F);
      RopeEast1.setTextureSize(32, 32);
      RopeEast1.mirror = true;
      setRotation(RopeEast1, 0F, 0F, 2.216568F);
      RopeNorth2 = new ModelRenderer(this, 0, 19);
      RopeNorth2.addBox(-1F, -0.3F, -1F, 2, 2, 2);
      RopeNorth2.setRotationPoint(0F, 24F, -8F);
      RopeNorth2.setTextureSize(32, 32);
      RopeNorth2.mirror = true;
      setRotation(RopeNorth2, -2.216568F, 0F, 0F);
      RopeNorth = new ModelRenderer(this, 0, 23);
      RopeNorth.addBox(-1F, 0F, 0F, 2, 2, 7);
      RopeNorth.setRotationPoint(0F, 22F, -8.6F);
      RopeNorth.setTextureSize(32, 32);
      RopeNorth.mirror = true;
      setRotation(RopeNorth, 0.296706F, 0F, 0F);
      RopeEast = new ModelRenderer(this, 0, 15);
      RopeEast.addBox(0F, 0F, -1F, 7, 2, 2);
      RopeEast.setRotationPoint(-8.6F, 22F, 0F);
      RopeEast.setTextureSize(32, 32);
      RopeEast.mirror = true;
      setRotation(RopeEast, 0F, 0F, -0.296706F);
      RopeWest1 = new ModelRenderer(this, 8, 19);
      RopeWest1.addBox(-1F, -0.3F, -1F, 2, 2, 2);
      RopeWest1.setRotationPoint(8F, 24F, 0F);
      RopeWest1.setTextureSize(32, 32);
      RopeWest1.mirror = true;
      setRotation(RopeWest1, 0F, 0F, -2.216568F);
      RopeSouth = new ModelRenderer(this, 0, 23);
      RopeSouth.addBox(-1F, 0F, -7F, 2, 2, 7);
      RopeSouth.setRotationPoint(0F, 22F, 8.6F);
      RopeSouth.setTextureSize(32, 32);
      RopeSouth.mirror = true;
      setRotation(RopeSouth, -0.296706F, 0F, 0F);
      RopeSouth1 = new ModelRenderer(this, 0, 19);
      RopeSouth1.addBox(-1F, -1F, -0.3F, 2, 2, 2);
      RopeSouth1.setRotationPoint(0F, 24F, 8F);
      RopeSouth1.setTextureSize(32, 32);
      RopeSouth1.mirror = true;
      setRotation(RopeSouth1, 0.6457718F, 0F, 0F);
      RopeCenter = new ModelRenderer(this, 0, 9);
      RopeCenter.addBox(-2F, 0F, -2F, 4, 2, 4);
      RopeCenter.setRotationPoint(0F, 20F, 0F);
      RopeCenter.setTextureSize(32, 32);
      RopeCenter.mirror = true;
      setRotation(RopeCenter, 0F, 0F, 0F);
      RopeWest = new ModelRenderer(this, 0, 15);
      RopeWest.addBox(-7F, 0F, -1F, 7, 2, 2);
      RopeWest.setRotationPoint(8.6F, 22F, 0F);
      RopeWest.setTextureSize(32, 32);
      RopeWest.mirror = true;
      setRotation(RopeWest, 0F, 0F, 0.296706F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Wood.render(f5);
    RopeEast1.render(f5);
    RopeNorth2.render(f5);
    RopeNorth.render(f5);
    RopeEast.render(f5);
    RopeWest1.render(f5);
    RopeSouth.render(f5);
    RopeSouth1.render(f5);
    RopeCenter.render(f5);
    RopeWest.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderBase(float f5) {
	  Wood.render(f5);
	  RopeCenter.render(f5);
  }
  
  public void renderNorth(float f5){
	  RopeNorth2.render(f5);
	  RopeNorth.render(f5);
  }
  
  public void renderEast(float f5){
	  RopeEast.render(f5);
	  RopeEast1.render(f5);
  }
  public void renderSouth(float f5){
	  RopeSouth.render(f5);
	  RopeSouth1.render(f5);
  }
  public void renderWest(float f5){
	  RopeWest.render(f5);
	  RopeWest1.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}



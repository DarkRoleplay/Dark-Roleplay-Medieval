package net.dark_roleplay.medieval.testing.accessoires;

public class ModelBox{}/*  extends ModelBiped {
    public ModelRenderer BodyCenter;
    public ModelRenderer BodyBack;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer LegBL1;
    public ModelRenderer LegBL2;
    public ModelRenderer LegBL3;
    public ModelRenderer LegBR1;
    public ModelRenderer LegBR2;
    public ModelRenderer LegBR3;
    public ModelRenderer BodyFront;
    public ModelRenderer HeadMain;
    public ModelRenderer EarL1;
    public ModelRenderer EarL2;
    public ModelRenderer EarL3;
    public ModelRenderer EarR1;
    public ModelRenderer EarR2;
    public ModelRenderer EarR3;
    public ModelRenderer HeadFront;
    public ModelRenderer HeadSneeze1;
    public ModelRenderer HeadSneeze2;
    public ModelRenderer LegFL1;
    public ModelRenderer LegFL2;
    public ModelRenderer LegFR1;
    public ModelRenderer LegFR2;

    public ModelBox() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.BodyCenter = new ModelRenderer(this, 8, 11);
        this.BodyCenter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyCenter.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.BodyBack = new ModelRenderer(this, 9, 0);
        this.BodyBack.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.BodyBack.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 5);
        this.setRotationAngles(this.BodyBack, -0.05235987755982988F, 0.0F, 0.0F);
        this.BodyCenter.addChild(this.BodyBack);
        this.Tail1 = new ModelRenderer(this, 48, 43);
        this.Tail1.setRotationPoint(0.0F, -2.0F, 5.0F);
        this.Tail1.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
        this.setRotationAngles(this.Tail1, 1.2217304763960306F, 0.0F, 0.0F);
        this.BodyBack.addChild(this.Tail1);
        this.Tail2 = new ModelRenderer(this, 48, 51);
        this.Tail2.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Tail2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
        this.setRotationAngles(this.Tail2, -0.22689280275926282F, 0.0F, 0.0F);
        this.Tail1.addChild(this.Tail2);
        this.Tail3 = new ModelRenderer(this, 50, 59);
        this.Tail3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Tail3.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2);
        this.setRotationAngles(this.Tail3, -0.17453292519943295F, 0.0F, 0.0F);
        this.Tail2.addChild(this.Tail3);
        this.LegBL1 = new ModelRenderer(this, 52, 0);
        this.LegBL1.setRotationPoint(-3.0F, 0.0F, 2.5F);
        this.LegBL1.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3);
        this.setRotationAngles(this.LegBL1, -0.3490658503988659F, 0.0F, 0.0F);
        this.BodyBack.addChild(this.LegBL1);
        this.LegBL2 = new ModelRenderer(this, 54, 9);
        this.LegBL2.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.LegBL2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.setRotationAngles(this.LegBL2, 0.7853981633974483F, 0.0F, 0.0F);
        this.LegBL1.addChild(this.LegBL2);
        this.LegBL3 = new ModelRenderer(this, 54, 15);
        this.LegBL3.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.LegBL3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.setRotationAngles(this.LegBL3, -0.7853981633974483F, 0.0F, 0.0F);
        this.LegBL2.addChild(this.LegBL3);
        this.LegBR1 = new ModelRenderer(this, 40, 0);
        this.LegBR1.setRotationPoint(3.0F, 0.0F, 2.5F);
        this.LegBR1.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3);
        this.setRotationAngles(this.LegBR1, -0.3490658503988659F, 0.0F, 0.0F);
        this.BodyBack.addChild(this.LegBR1);
        this.LegBR2 = new ModelRenderer(this, 42, 9);
        this.LegBR2.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.LegBR2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.setRotationAngles(this.LegBR2, 0.7853981633974483F, 0.0F, 0.0F);
        this.LegBR1.addChild(this.LegBR2);
        this.LegBR3 = new ModelRenderer(this, 42, 15);
        this.LegBR3.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.LegBR3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.setRotationAngles(this.LegBR3, -0.7853981633974483F, 0.0F, 0.0F);
        this.LegBR2.addChild(this.LegBR3);
        this.BodyFront = new ModelRenderer(this, 9, 23);
        this.BodyFront.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.BodyFront.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 5);
        this.setRotationAngles(this.BodyFront, 0.05235987755982988F, 0.0F, 0.0F);
        this.BodyCenter.addChild(this.BodyFront);
        this.HeadMain = new ModelRenderer(this, 8, 34);
        this.HeadMain.setRotationPoint(0.0F, -2.0F, -5.0F);
        this.HeadMain.addBox(-3.5F, -4.5F, -5.0F, 7, 7, 5);
        this.setRotationAngles(this.HeadMain, -0.08726646259971647F, 0.0F, 0.0F);
        this.BodyFront.addChild(this.HeadMain);
        this.EarL1 = new ModelRenderer(this, 32, 41);
        this.EarL1.setRotationPoint(-3.0F, -4.5F, -1.0F);
        this.EarL1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 1);
        this.setRotationAngles(this.EarL1, 0.08726646259971647F, 0.0F, 0.0F);
        this.HeadMain.addChild(this.EarL1);
        this.EarL2 = new ModelRenderer(this, 32, 44);
        this.EarL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.EarL2.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1);
        this.EarL1.addChild(this.EarL2);
        this.EarL3 = new ModelRenderer(this, 33, 39);
        this.EarL3.setRotationPoint(0.5F, -2.0F, 0.0F);
        this.EarL3.addBox(-2.0F, -1.0F, -0.5F, 2, 1, 1);
        this.setRotationAngles(this.EarL3, 0.17453292519943295F, 0.0F, 0.0F);
        this.EarL1.addChild(this.EarL3);
        this.EarR1 = new ModelRenderer(this, 0, 41);
        this.EarR1.setRotationPoint(3.0F, -4.5F, -1.0F);
        this.EarR1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 1);
        this.setRotationAngles(this.EarR1, 0.08726646259971647F, 0.0F, 0.0F);
        this.HeadMain.addChild(this.EarR1);
        this.EarR2 = new ModelRenderer(this, 4, 44);
        this.EarR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.EarR2.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1);
        this.EarR1.addChild(this.EarR2);
        this.EarR3 = new ModelRenderer(this, 1, 39);
        this.EarR3.setRotationPoint(-0.5F, -2.0F, -0.5F);
        this.EarR3.addBox(0.0F, -1.0F, 0.0F, 2, 1, 1);
        this.setRotationAngles(this.EarR3, 0.17453292519943295F, 0.0F, 0.0F);
        this.EarR1.addChild(this.EarR3);
        this.HeadFront = new ModelRenderer(this, 13, 46);
        this.HeadFront.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.HeadFront.addBox(-3.0F, -4.0F, -1.0F, 6, 6, 1);
        this.HeadMain.addChild(this.HeadFront);
        this.HeadSneeze1 = new ModelRenderer(this, 15, 53);
        this.HeadSneeze1.setRotationPoint(0.0F, 0.5F, -1.0F);
        this.HeadSneeze1.addBox(-2.0F, -2.0F, -1.0F, 4, 3, 1);
        this.HeadFront.addChild(this.HeadSneeze1);
        this.HeadSneeze2 = new ModelRenderer(this, 16, 57);
        this.HeadSneeze2.setRotationPoint(0.0F, -0.5F, -1.0F);
        this.HeadSneeze2.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
        this.HeadSneeze1.addChild(this.HeadSneeze2);
        this.LegFL1 = new ModelRenderer(this, 54, 23);
        this.LegFL1.setRotationPoint(-3.0F, 0.0F, -3.0F);
        this.LegFL1.addBox(-1.0F, -1.5F, -1.5F, 2, 7, 3);
        this.setRotationAngles(this.LegFL1, 0.4363323129985824F, 0.0F, 0.0F);
        this.BodyFront.addChild(this.LegFL1);
        this.LegFL2 = new ModelRenderer(this, 55, 33);
        this.LegFL2.setRotationPoint(0.0F, 5.0F, 0.5F);
        this.LegFL2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.setRotationAngles(this.LegFL2, -0.7853981633974483F, 0.0F, 0.0F);
        this.LegFL1.addChild(this.LegFL2);
        this.LegFR1 = new ModelRenderer(this, 44, 23);
        this.LegFR1.setRotationPoint(3.0F, 0.0F, -3.0F);
        this.LegFR1.addBox(-1.0F, -1.5F, -1.5F, 2, 7, 3);
        this.setRotationAngles(this.LegFR1, 0.4363323129985824F, 0.0F, 0.0F);
        this.BodyFront.addChild(this.LegFR1);
        this.LegFR2 = new ModelRenderer(this, 45, 33);
        this.LegFR2.setRotationPoint(0.0F, 5.0F, 0.5F);
        this.LegFR2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.setRotationAngles(this.LegFR2, -0.7853981633974483F, 0.0F, 0.0F);
        this.LegFR1.addChild(this.LegFR2);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
    	super.render(entity, limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale);
	    setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale, entity);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.AND);
        this.BodyCenter.render(scale);
        GlStateManager.disableBlend();
        
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn){
    	this.HeadMain.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
    	this.HeadMain.rotateAngleX = headPitch / (180F / (float)Math.PI);
    	float f = 1.0f;
    	this.LegFL1.rotateAngleX = 0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.LegFR1.rotateAngleX = 0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.LegBR1.rotateAngleX = -0.3490658503988659F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.LegBL1.rotateAngleX = -0.3490658503988659F + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}*/
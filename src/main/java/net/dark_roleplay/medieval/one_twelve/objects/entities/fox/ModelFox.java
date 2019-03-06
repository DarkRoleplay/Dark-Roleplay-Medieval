package net.dark_roleplay.medieval.one_twelve.objects.entities.fox;

public class ModelFox {}/* extends AdvancedModel {

    public ModelRenderer bodyCenter;
    public ModelRenderer legBackLeft1;
    public ModelRenderer legBackRight1;
    public ModelRenderer headMain;
    public ModelRenderer legFrontLeft1;
    public ModelRenderer leftFrontRight1;

    public ModelFox() {
    	ModelRenderer bodyBack, bodyFront;
    	ModelRenderer tail1, tail2, tail3;
    	ModelRenderer legBackLeft2, legBackLeft3;
    	ModelRenderer legBackRight2, legBackRight3;
    	ModelRenderer earLeft1, earLeft2, earLeft3;
    	ModelRenderer earRight1, earRight2, earRight3;
    	ModelRenderer headFront;
        ModelRenderer headSneeze1, headSneeze2;
    	ModelRenderer legFrontLeft2;
    	ModelRenderer legFrontRight2;

        this.textureWidth = 64;
        this.textureHeight = 64;

       this.bodyCenter = new ModelRenderer(this, 8, 11);
       this.bodyCenter.setRotationPoint(0.0F, 0.0F, 0.0F);
       this.bodyCenter.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
       bodyBack = new ModelRenderer(this, 9, 0);
       bodyBack.setRotationPoint(0.0F, 0.0F, 3.0F);
       bodyBack.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 5);
       this.setRotationAngles(bodyBack, -0.05235987755982988F, 0.0F, 0.0F);
       this.bodyCenter.addChild(bodyBack);
       tail1 = new ModelRenderer(this, 48, 43);
       tail1.setRotationPoint(0.0F, -2.0F, 5.0F);
       tail1.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
       this.setRotationAngles(tail1, 1.2217304763960306F, 0.0F, 0.0F);
       bodyBack.addChild(tail1);
       tail2 = new ModelRenderer(this, 48, 51);
       tail2.setRotationPoint(0.0F, 5.0F, 0.0F);
       tail2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
       this.setRotationAngles(tail2, -0.22689280275926282F, 0.0F, 0.0F);
       tail1.addChild(tail2);
       tail3 = new ModelRenderer(this, 50, 59);
       tail3.setRotationPoint(0.0F, 5.0F, 0.0F);
       tail3.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2);
       this.setRotationAngles(tail3, -0.17453292519943295F, 0.0F, 0.0F);
       tail2.addChild(tail3);
       this.legBackLeft1 = new ModelRenderer(this, 52, 0);
       this.legBackLeft1.setRotationPoint(-3.0F, 0.0F, 2.5F);
       this.legBackLeft1.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3);
       this.setRotationAngles(this.legBackLeft1, -0.3490658503988659F, 0.0F, 0.0F);
       bodyBack.addChild(this.legBackLeft1);
       legBackLeft2 = new ModelRenderer(this, 54, 9);
       legBackLeft2.setRotationPoint(0.0F, 3.5F, 0.0F);
       legBackLeft2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
       this.setRotationAngles(legBackLeft2, 0.7853981633974483F, 0.0F, 0.0F);
       this.legBackLeft1.addChild(legBackLeft2);
       legBackLeft3 = new ModelRenderer(this, 54, 15);
       legBackLeft3.setRotationPoint(0.0F, 3.5F, 0.0F);
       legBackLeft3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
       this.setRotationAngles(legBackLeft3, -0.7853981633974483F, 0.0F, 0.0F);
       legBackLeft2.addChild(legBackLeft3);
       this.legBackRight1 = new ModelRenderer(this, 40, 0);
       this.legBackRight1.setRotationPoint(3.0F, 0.0F, 2.5F);
       this.legBackRight1.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3);
       this.setRotationAngles(this.legBackRight1, -0.3490658503988659F, 0.0F, 0.0F);
       bodyBack.addChild(this.legBackRight1);
       legBackRight2 = new ModelRenderer(this, 42, 9);
       legBackRight2.setRotationPoint(0.0F, 3.5F, 0.0F);
       legBackRight2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
       this.setRotationAngles(legBackRight2, 0.7853981633974483F, 0.0F, 0.0F);
       this.legBackRight1.addChild(legBackRight2);
       legBackRight3 = new ModelRenderer(this, 42, 15);
       legBackRight3.setRotationPoint(0.0F, 3.5F, 0.0F);
       legBackRight3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
       this.setRotationAngles(legBackRight3, -0.7853981633974483F, 0.0F, 0.0F);
       legBackRight2.addChild(legBackRight3);
       bodyFront = new ModelRenderer(this, 9, 23);
       bodyFront.setRotationPoint(0.0F, 0.0F, -3.0F);
       bodyFront.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 5);
       this.setRotationAngles(bodyFront, 0.05235987755982988F, 0.0F, 0.0F);
       this.bodyCenter.addChild(bodyFront);
       this.headMain = new ModelRenderer(this, 8, 34);
       this.headMain.setRotationPoint(0.0F, -2.0F, -5.0F);
       this.headMain.addBox(-3.5F, -4.5F, -5.0F, 7, 7, 5);
       this.setRotationAngles(this.headMain, -0.08726646259971647F, 0.0F, 0.0F);
       bodyFront.addChild(this.headMain);
       earLeft1 = new ModelRenderer(this, 32, 41);
       earLeft1.setRotationPoint(-3.0F, -4.5F, -1.0F);
       earLeft1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 0.5F);
       this.setRotationAngles(earLeft1, 0.08726646259971647F, 0.0F, 0.0F);
       this.headMain.addChild(earLeft1);
       earLeft2 = new ModelRenderer(this, 32, 44);
       earLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
       earLeft2.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 0.5F);
       earLeft1.addChild(earLeft2);
       earLeft3 = new ModelRenderer(this, 33, 39);
       earLeft3.setRotationPoint(0.5F, -2.0F, 0.0F);
       earLeft3.addBox(-2.0F, -1.0F, -0.5F, 2, 1, 0.5F);
       this.setRotationAngles(earLeft3, 0.17453292519943295F, 0.0F, 0.0F);
       earLeft1.addChild(earLeft3);
       earRight1 = new ModelRenderer(this, 0, 41);
       earRight1.setRotationPoint(3.0F, -4.5F, -1.0F);
       earRight1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 1);
       this.setRotationAngles(earRight1, 0.08726646259971647F, 0.0F, 0.0F);
       this.headMain.addChild(earRight1);
       earRight2 = new ModelRenderer(this, 4, 44);
       earRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
       earRight2.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1);
       earRight1.addChild(earRight2);
       earRight3 = new ModelRenderer(this, 1, 39);
       earRight3.setRotationPoint(-0.5F, -2.0F, -0.5F);
       earRight3.addBox(0.0F, -1.0F, 0.0F, 2, 1, 1);
       this.setRotationAngles(earRight3, 0.17453292519943295F, 0.0F, 0.0F);
       earRight1.addChild(earRight3);
       headFront = new ModelRenderer(this, 13, 46);
       headFront.setRotationPoint(0.0F, 0.0F, -5.0F);
       headFront.addBox(-3.0F, -4.0F, -1.0F, 6, 6, 1);
       this.headMain.addChild(headFront);
       headSneeze1 = new ModelRenderer(this, 15, 53);
       headSneeze1.setRotationPoint(0.0F, 0.5F, -1.0F);
       headSneeze1.addBox(-2.0F, -2.0F, -1.0F, 4, 3, 1);
       headFront.addChild(headSneeze1);
       headSneeze2 = new ModelRenderer(this, 16, 57);
       headSneeze2.setRotationPoint(0.0F, -0.5F, -1.0F);
       headSneeze2.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
       headSneeze1.addChild(headSneeze2);
       this.legFrontLeft1 = new ModelRenderer(this, 54, 23);
       this.legFrontLeft1.setRotationPoint(-3.0F, 0.0F, -3.0F);
       this.legFrontLeft1.addBox(-1.0F, -1.5F, -1.5F, 2, 7, 3);
       this.setRotationAngles(this.legFrontLeft1, 0.4363323129985824F, 0.0F, 0.0F);
       bodyFront.addChild(this.legFrontLeft1);
       legFrontLeft2 = new ModelRenderer(this, 55, 33);
       legFrontLeft2.setRotationPoint(0.0F, 5.0F, 0.5F);
       legFrontLeft2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
       this.setRotationAngles(legFrontLeft2, -0.7853981633974483F, 0.0F, 0.0F);
       this.legFrontLeft1.addChild(legFrontLeft2);
       this.leftFrontRight1 = new ModelRenderer(this, 44, 23);
       this.leftFrontRight1.setRotationPoint(3.0F, 0.0F, -3.0F);
       this.leftFrontRight1.addBox(-1.0F, -1.5F, -1.5F, 2, 7, 3);
       this.setRotationAngles(this.leftFrontRight1, 0.4363323129985824F, 0.0F, 0.0F);
       bodyFront.addChild(this.leftFrontRight1);
       legFrontRight2 = new ModelRenderer(this, 45, 33);
       legFrontRight2.setRotationPoint(0.0F, 5.0F, 0.5F);
       legFrontRight2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
       this.setRotationAngles(legFrontRight2, -0.7853981633974483F, 0.0F, 0.0F);
       this.leftFrontRight1.addChild(legFrontRight2);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
    	super.render(entity, limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale);
	    this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale, entity);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.AND);
        this.bodyCenter.render(scale);
        GlStateManager.disableBlend();

    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn){
    	this.headMain.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
    	this.headMain.rotateAngleX = headPitch / (180F / (float)Math.PI);
    	float f = 1.0f;
    	this.legFrontLeft1.rotateAngleX = 0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.leftFrontRight1.rotateAngleX = 0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.legBackRight1.rotateAngleX = -0.3490658503988659F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    	this.legBackLeft1.rotateAngleX = -0.3490658503988659F + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}*/
package net.dark_roleplay.medieval.one_twelve.objects.entities.fox;

public class RendererFox{}/*  extends RenderLiving<Fox>{

	public static final Factory FACTORY = new Factory();
	
	public RendererFox(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelFox(), 0.5F);
	}

    @Override
    protected void preRenderCallback(Fox entity, float f){
    	GL11.glScalef(0.75F, 0.75F, 0.75F);
    	GL11.glTranslatef(0.0F, 0.85F, 0.0F);
    }

    @Override
	public void doRender(Fox entity, double x, double y, double z, float entityYaw, float partialTicks){
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Fox entity) {
		return new ResourceLocation(References.MODID, "textures/entitys/fox/fox.png");
	}
	
	private static class Factory implements IRenderFactory<Fox> {
		@Override
		public Render<? super Fox> createRenderFor(RenderManager manager) {
			return new RendererFox(manager);
	    }
	}
}*/

package net.dark_roleplay.medieval.testing.blockstate_loading;

public class DelayedModel{}/*  extends DelayedBaker{

	private HashMap<String, ResourceLocation> models;
	private List<List<ResourceLocation>> modelGroups;
	
	private VertexFormat format;
	
	public DelayedModel(){
		
	}
	
	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		// TODO Auto-generated method stub
		new BakedQuad(createFace(0,0,0, 1,0,0, 1,1,0 ,0,1,0), 0, side, null, false, this.format);
		return null;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.format = format;
		return this;
	}
	
	public int[] createFace(double x1, double y1, double z1, double x2, double y2, double z2,double x3, double y3, double z3,double x4, double y4, double z4){
		int[] vertexData = new int[28];
		int[] cornerOne = vertexToInts(x1, y1, z1, (float)x1, (float)y1, null);
		int[] cornerTwo = vertexToInts(x2, y2, z2, (float)x1, (float)y1, null);
		int[] cornerThree = vertexToInts(x3, y3, z3, (float)x1, (float)y1, null);
		int[] cornerFour = vertexToInts(x4, y4, z4, (float)x1, (float)y1, null);
		
		for(int i = 0; i < cornerOne.length; i++){
			vertexData[i] = cornerOne[i];
		}
		for(int i = 0; i < cornerTwo.length; i++){
			vertexData[i + 7] = cornerTwo[i];
		}
		for(int i = 0; i < cornerThree.length; i++){
			vertexData[i + 14] = cornerThree[i];
		}
		for(int i = 0; i < cornerFour.length; i++){
			vertexData[i + 21] = cornerFour[i];
		}
		return vertexData;
	}
	
	public static int[] vertexToInts(double x, double y, double z, float u, float v, TextureAtlasSprite sprite) {
        return new int[] {
            Float.floatToRawIntBits((float) x),
            Float.floatToRawIntBits((float) y),
            Float.floatToRawIntBits((float) z),
            -1,
            Float.floatToRawIntBits(sprite.getInterpolatedU(u)),
            Float.floatToRawIntBits(sprite.getInterpolatedV(v)),
            0
        };
    }
}*/

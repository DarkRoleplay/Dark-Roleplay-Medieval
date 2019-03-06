package net.dark_roleplay.medieval.testing.blockstate_loading;

public class CustomBlockstateLoader{}/*  implements ICustomModelLoader{

	private IResourceManager manager;

	private HashMap<String, HashMap<String, JsonObject>> cache;

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		this.manager = resourceManager;
		SpecialRendererRoof.north = new HashMap<IBlockState, TextureAtlasSprite>();
		SpecialRendererRoof.east = new HashMap<IBlockState, TextureAtlasSprite>();
		SpecialRendererRoof.south = new HashMap<IBlockState, TextureAtlasSprite>();
		SpecialRendererRoof.west = new HashMap<IBlockState, TextureAtlasSprite>();
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
//		if(modelLocation instanceof ModelResourceLocation){
//			try{
//				manager.getResource(new ResourceLocation(modelLocation.getResourceDomain(), "drp/blockstates/" + modelLocation.getResourcePath() + ".json"));
//				return true;
//			}catch(IOException e){
//				return false;
//			}
//		}
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		System.out.println("SEARCH ME BIATCH : " + modelLocation);

		String domain = modelLocation.getNamespace();
		String path = modelLocation.getPath();
		JsonObject file;

		if(!this.cache.containsKey(domain)){
			this.cache.put(domain, new HashMap<String,JsonObject>());
		}

		if(!this.cache.get(domain).containsKey(path)){
			this.cache.get(domain).put(path, BlockStateLoader.getBlockState(new ResourceLocation(modelLocation.getNamespace(), "drp/blockstates/" + modelLocation.getPath() + ".json")));
		}

		JsonObject blockstate = this.cache.get(domain).get(path);

		return new DelayedModel();
	}

}*/

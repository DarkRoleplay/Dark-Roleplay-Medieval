package net.dark_roleplay.medieval.one_twelve.objects.other;

//import java.util.Collection;
//import java.util.List;
//import java.util.function.Function;
//
//import com.google.common.collect.ImmutableList;
//
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.BakedQuad;
//import net.minecraft.client.renderer.block.model.IBakedModel;
//import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
//import net.minecraft.client.renderer.block.model.ItemOverrideList;
//import net.minecraft.client.renderer.block.model.ModelRotation;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.client.renderer.vertex.VertexFormat;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.model.IModel;
//import net.minecraftforge.common.model.IModelState;
//import net.minecraftforge.common.model.TRSRTransformation;

//PORT to 1.13
public abstract class DelayedBaker{// implements IBakedModel, IModel{

//
//	//"Temporary" Hack, will be fixed some day
//
//	protected VertexFormat format;
//
//	protected Function<ResourceLocation, TextureAtlasSprite> textureGetter;
//
//	protected String particle;
//
//	protected void bakeInfo(VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> textureGetter, ResourceLocation particle){
//		this.format = format;
//		this.textureGetter = textureGetter;
//		this.particle = particle.getNamespace() + ":" + particle.getPath();
//	}
//
//	protected void addQuads(List<BakedQuad> quads, IModel model, int yRotate, int xRotate, IBlockState state, EnumFacing side, long rand){
//		TRSRTransformation transform = TRSRTransformation.from(ModelRotation.getModelRotation(xRotate, yRotate));
//		IBakedModel baked = model.bake(transform, this.format, this.textureGetter);
//		quads.addAll(baked.getQuads(state, side,  rand));
//	}
//
//	protected void addQuads(List<BakedQuad> quads, IModel model, IBlockState state, EnumFacing side, long rand){
//		this.addQuads(quads, model, 0, 0, state, side, rand);
//	}
//
//	@Override
//	public Collection<ResourceLocation> getDependencies(){ return ImmutableList.of(); }
//
//	@Override
//	public IModelState getDefaultState() { return TRSRTransformation.identity(); }
//
//	@Override
//	public boolean isAmbientOcclusion() { return true; }
//
//	@Override
//	public boolean isGui3d() { return true; }
//
//	@Override
//	public boolean isBuiltInRenderer() { return false; }
//
//	@Override
//	public TextureAtlasSprite getParticleTexture() { return Minecraft.getInstance().getTextureMapBlocks().getAtlasSprite(this.particle); }
//
//	@Override
//	public ItemCameraTransforms getItemCameraTransforms() { return ItemCameraTransforms.DEFAULT; }
//
//	@Override
//	public ItemOverrideList getOverrides() { return ItemOverrideList.NONE; }
//

}

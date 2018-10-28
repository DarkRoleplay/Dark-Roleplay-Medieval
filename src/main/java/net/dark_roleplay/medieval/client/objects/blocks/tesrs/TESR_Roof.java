package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Roof;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.FastTESR;

public class TESR_Roof extends FastTESR<TE_Roof> {

	public static Map<IBlockState, TextureAtlasSprite> north = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> east = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> south = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> west = new HashMap<IBlockState, TextureAtlasSprite>();

//	public static IBakedModel[] back = new IBakedModel[4];
//
//	static {
//		back[0] = ModelBlock;
//	}

	private BakedRoof model = null;

	@Override
	public void renderTileEntityFast(TE_Roof te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {
		BlockRendererDispatcher blockRenderDispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();

		World world = te.getWorld();
		BlockPos pos = te.getPos();

		IBlockState otherState = world.getBlockState(pos.down());

		if(!otherState.isFullCube()) return;

		if(!north.containsKey(otherState)) {

			IBakedModel modelOther = blockRenderDispatcher.getModelForState(otherState);
			north.put(otherState, modelOther.getQuads(otherState, EnumFacing.NORTH, 0L).get(0).getSprite());
			east.put(otherState, modelOther.getQuads(otherState, EnumFacing.EAST, 0L).get(0).getSprite());
			south.put(otherState, modelOther.getQuads(otherState, EnumFacing.SOUTH, 0L).get(0).getSprite());
			west.put(otherState, modelOther.getQuads(otherState, EnumFacing.WEST, 0L).get(0).getSprite());

		}

		EnumFacing facing = world.getBlockState(pos).getValue(BlockProperties.FACING_HORIZONTAL);

		TextureAtlasSprite sprite = north.get(otherState);
//		if(this.model == null) {
			this.model = new BakedRoof(facing, sprite, world.getBlockState(pos).getActualState(world, pos).getValue(BlockProperties.STAIR_TYPE));
//		}

//		System.out.println("T");
		BlockPos offset = pos;
		if(world.isAirBlock(pos.down())) return;
		buffer.setTranslation(x - offset.getX(), y - offset.getY() -1, z - offset.getZ());
		blockRenderDispatcher.getBlockModelRenderer().renderModel(world, this.model, world.getBlockState(pos), pos, buffer, true);


//
//		IBlockState state = world.getBlockState(pos);
//		state = state.getActualState(world, pos);
//
//		EnumFacing facing = state.getValue(BlockProperties.FACING_HORIZONTAL);
//		BlockProperties.StairType type = state.getValue(BlockProperties.STAIR_TYPE);
//		switch(type) {
//			case INNER_LEFT:
//				this.renderBack(facing.rotateY(), otherState, x, y, z, buffer, world, pos);
//				this.renderBack(facing, otherState, x, y, z, buffer, world, pos);
//				this.renderSide(facing.rotateY().rotateY(), otherState, x, y, z, false, buffer);
//				this.renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
//				break;
//			case INNER_RIGHT:
//				this.renderBack(facing, otherState, x, y, z, buffer, world, pos);
//				this.renderBack(facing.rotateYCCW(), otherState, x, y, z, buffer, world, pos);
//				this.renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
//				this.renderSide(facing.rotateY().rotateY(), otherState, x, y, z, true, buffer);
//				break;
//			case OUTER_LEFT:
//				this.renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
//				this.renderSide(facing, otherState, x, y, z, true, buffer);
//				break;
//			case OUTER_RIGHT:
//				this.renderSide(facing, otherState, x, y, z, false, buffer);
//				this.renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
//				break;
//			case STRAIGHT:
//				this.renderBack(facing, otherState, x, y, z, buffer, world, pos);
////				this.renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
////				this.renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
//				break;
//		}
	}

	/**
	 * Converts the vertex information to the int array format expected by
	 * BakedQuads.
	 *
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param z
	 *            z coordinate
	 * @param color
	 *            RGBA colour format - white for no effect, non-white to tint
	 *            the face with the specified colour
	 * @param texture
	 *            the texture to use for the face
	 * @param u
	 *            u-coordinate of the texture (0 - 16) corresponding to [x,y,z]
	 * @param v
	 *            v-coordinate of the texture (0 - 16) corresponding to [x,y,z]
	 * @return
	 */
	private static int[] vertexToInts(float x, float y, float z, int color, TextureAtlasSprite texture, float u, float v) {
		return new int[] { Float.floatToRawIntBits(x), Float.floatToRawIntBits(y), Float.floatToRawIntBits(z), color,
				Float.floatToRawIntBits(texture.getInterpolatedU(u)),
				Float.floatToRawIntBits(texture.getInterpolatedV(v)), 0 };
	}


	private static int[] createFullQuad(EnumFacing facing, TextureAtlasSprite sprite) {
		int[] output = new int[0];

		switch(facing) {
			case DOWN:
				break;
			case EAST:
				output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 0, 16));
				output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 16, 16));
				output = ArrayUtils.addAll(output, vertexToInts(0, 2, 1, -1, sprite, 16, 0));
				output = ArrayUtils.addAll(output, vertexToInts(0, 2, 0, -1, sprite, 0, 0));
				break;
			case NORTH:
				output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 0, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 16, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 2, 1, -1, sprite, 16, 0));
				output = ArrayUtils.addAll(output, vertexToInts(0, 2, 1, -1, sprite, 0, 0));
				break;
			case SOUTH:
				output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 16, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 0, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 2, 0, -1, sprite, 0, 0));
				output = ArrayUtils.addAll(output, vertexToInts(0, 2, 0, -1, sprite, 16, 0));
				break;
			case UP:
				break;
			case WEST:
				output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 16, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 0, 16));
				output = ArrayUtils.addAll(output, vertexToInts(1, 2, 1, -1, sprite, 0, 0));
				output = ArrayUtils.addAll(output, vertexToInts(1, 2, 0, -1, sprite, 16, 0));
				break;
			default:
				break;
		}

		return output;
	}

	private static int[] createTriangleQuad(EnumFacing facing, boolean inverted, TextureAtlasSprite sprite) {
		int[] output = new int[0];

		switch(facing) {
			case DOWN:
				break;
			case EAST:
				if(inverted) {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0, 2, 1, -1, sprite, 16, 0));
					output = ArrayUtils.addAll(output, vertexToInts(0, 1.5F, 0.5F, -1, sprite, 8, 8));
				}else {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0, 1.5F, 0.5F, -1, sprite, 8, 8));
					output = ArrayUtils.addAll(output, vertexToInts(0, 2, 0, -1, sprite, 0, 0));
				}
				break;
			case NORTH:
				if(inverted) {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 2, 1, -1, sprite, 16, 0));
					output = ArrayUtils.addAll(output, vertexToInts(0.5F, 1.5F, 1, -1, sprite, 8, 8));
				}else {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0.5F, 1.5F, 1, -1, sprite, 8, 8));
					output = ArrayUtils.addAll(output, vertexToInts(0, 2, 1, -1, sprite, 0, 0));
				}
				break;
			case SOUTH:
				if(inverted) {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(0.5F, 1.5F, 0, -1, sprite, 8, 8));
					output = ArrayUtils.addAll(output, vertexToInts(0, 2, 0, -1, sprite, 16, 0));
				}else {
					output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 2, 0, -1, sprite, 0, 0));
					output = ArrayUtils.addAll(output, vertexToInts(0.5F, 1.5F, 0, -1, sprite, 8, 8));
				}

				break;
			case UP:
				break;
			case WEST:
				if(inverted) {
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1.5F, 0.5F, -1, sprite, 8, 8));
					output = ArrayUtils.addAll(output, vertexToInts(1, 2, 0, -1, sprite, 16, 0));
				}else {
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 0, -1, sprite, 16, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1, 1, -1, sprite, 0, 16));
					output = ArrayUtils.addAll(output, vertexToInts(1, 2, 1, -1, sprite, 0, 0));
					output = ArrayUtils.addAll(output, vertexToInts(1, 1.5F, 0.5F, -1, sprite, 8, 8));
				}
				break;
			default:
				break;
		}

		return output;
	}

	private class BakedRoof implements IBakedModel{

		List<BakedQuad> facingCWQ = new ArrayList<BakedQuad>();
		List<BakedQuad> facingQ = new ArrayList<BakedQuad>();
		List<BakedQuad> facingCCWQ = new ArrayList<BakedQuad>();

		EnumFacing facing = null;

		public BakedRoof(EnumFacing facing, TextureAtlasSprite sprite, BlockProperties.StairType type) {
			this.facing = facing.getOpposite();



//			System.out.println(type);
			switch(type) {
				case INNER_LEFT:
					this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCWQ.add(new BakedQuad(createFullQuad(facing.rotateY(), sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					break;
				case INNER_RIGHT:
					this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCCWQ.add(new BakedQuad(createFullQuad(facing.rotateYCCW(), sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					break;
				case OUTER_LEFT:
					this.facingQ.add(new BakedQuad(createTriangleQuad(facing, false, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateY(), true, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					break;
				case OUTER_RIGHT:
					this.facingQ.add(new BakedQuad(createTriangleQuad(facing, true, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateYCCW(), false, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					break;
				case STRAIGHT:
					this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateY(), true, sprite),0, facing.rotateY(), sprite, true, DefaultVertexFormats.BLOCK));
					this.facingCCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateYCCW(), false, sprite),0, facing.rotateYCCW(), sprite, true, DefaultVertexFormats.BLOCK));
					break;
				default:
					break;
			}

//			if(facing == EnumFacing.SOUTH) {
//				this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, EnumFacing.SOUTH, sprite, true, DefaultVertexFormats.BLOCK));
//			}else if(facing == EnumFacing.EAST){
//				this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, EnumFacing.EAST, sprite, true, DefaultVertexFormats.BLOCK));
//			}else if(facing == EnumFacing.WEST){
//				this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
//			}else if(facing == EnumFacing.NORTH){
//				this.facingQ.add(new BakedQuad(createFullQuad(facing, sprite), 0, facing, sprite, true, DefaultVertexFormats.BLOCK));
//				this.facingCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateY(), true, sprite),0, facing.rotateY(), sprite, true, DefaultVertexFormats.BLOCK));
//				this.facingCCWQ.add(new BakedQuad(createTriangleQuad(facing.rotateYCCW(), false, sprite),0, facing.rotateYCCW(), sprite, true, DefaultVertexFormats.BLOCK));
//			}
		}

		@Override
		public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
			if(side == this.facing) return this.facingQ;
			else if(side == this.facing.rotateY()) return this.facingCWQ;
			else if(side == this.facing.rotateYCCW()) return this.facingCCWQ;
			return new ArrayList<BakedQuad>();
		}

		@Override
		public boolean isAmbientOcclusion() {
			return true;
		}

		@Override
		public boolean isGui3d() {
			return false;
		}

		@Override
		public boolean isBuiltInRenderer() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return null;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return null;
		}
	}
}

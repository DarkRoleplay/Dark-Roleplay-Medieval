package net.dark_roleplay.medieval.client.blocks.tesrs.roof;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.STAIR_TYPE;

import java.util.HashMap;
import java.util.Map;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.StairType;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.roof.TE_Roof;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.FastTESR;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TESR_Roof extends FastTESR<TE_Roof> {

	public static Map<IBlockState, TextureAtlasSprite> north = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> east = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> south = new HashMap<IBlockState, TextureAtlasSprite>();
	public static Map<IBlockState, TextureAtlasSprite> west = new HashMap<IBlockState, TextureAtlasSprite>();
	
	@Override
	public void renderTileEntityFast(TE_Roof te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {


		World world = te.getWorld();
		BlockPos pos = te.getPos();
		
		IBlockState otherState = world.getBlockState(pos.down());

		if(!otherState.getBlock().isFullCube(otherState)) {
			return;
		}
		
		if(!north.containsKey(otherState)) {
			BlockRendererDispatcher blockRenderDispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
	
			IBakedModel model = blockRenderDispatcher.getModelForState(otherState);
			north.put(otherState, model.getQuads(otherState, EnumFacing.NORTH, 0L).get(0).getSprite());
			east.put(otherState, model.getQuads(otherState, EnumFacing.EAST, 0L).get(0).getSprite());
			south.put(otherState, model.getQuads(otherState, EnumFacing.SOUTH, 0L).get(0).getSprite());
			west.put(otherState, model.getQuads(otherState, EnumFacing.WEST, 0L).get(0).getSprite());
		}
		
//		Minecraft.getMinecraft().Lig
		
		IBlockState state = world.getBlockState(pos);
//		System.out.println(state.getClass());
		state = state.getActualState(world, pos);
		
		EnumFacing facing = state.getValue(FACING);
		StairType type = state.getValue(STAIR_TYPE);
		
		int x2 = (int) x;
		int y2 = (int) y;
		int z2 = (int) z;
		
		
//		System.out.println("X: " + x + " Y: " + y + " Z: " + z );
		switch(type) {
			case INNER_LEFT:
				renderBack(facing.rotateY(), otherState, x, y, z, buffer, world, pos);
				renderBack(facing, otherState, x, y, z, buffer, world, pos);
				renderSide(facing.rotateY().rotateY(), otherState, x, y, z, false, buffer);
				renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
				break;
			case INNER_RIGHT:
				renderBack(facing, otherState, x, y, z, buffer, world, pos);
				renderBack(facing.rotateYCCW(), otherState, x, y, z, buffer, world, pos);
				renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
				renderSide(facing.rotateY().rotateY(), otherState, x, y, z, true, buffer);
				break;
			case OUTER_LEFT:
				renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
				renderSide(facing, otherState, x, y, z, true, buffer);
				break;
			case OUTER_RIGHT:
				renderSide(facing, otherState, x, y, z, false, buffer);
				renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
				break;
			case STRAIGHT:
				renderBack(facing, otherState, x, y, z, buffer, world, pos);
				renderSide(facing.rotateY(), otherState, x, y, z, false, buffer);
				renderSide(facing.rotateYCCW(), otherState, x, y, z, true, buffer);
				break;
		}
	}
	
	public void renderBack(EnumFacing facing, IBlockState state, double x, double y, double z, BufferBuilder buffer, World world, BlockPos pos) {
		
        EnumNeighborInfo info = EnumNeighborInfo.getNeighbourInfo(facing);
        
        pos = pos.offset(facing.getOpposite());
        int total = state.getPackedLightmapCoords(world, pos.offset(facing));
        
        int down = state.getPackedLightmapCoords(world, pos.offset(info.corners[0]));
        int top = state.getPackedLightmapCoords(world, pos.offset(info.corners[1]));
        int right = state.getPackedLightmapCoords(world, pos.offset(info.corners[2]));
        int left = state.getPackedLightmapCoords(world, pos.offset(info.corners[3]));

        int r1 = (int) ((total & 0xFFFF) * 0.75) ;
        int r2 = (int) ((total & 0xFFFF) * 0.75);
        int r3 = (int) ((total & 0xFFFF) * 0.75);
        int r4 = (int) ((total & 0xFFFF) * 0.75);
        
        int l1 = (int) ((total >> 16) * 0.8); 
        int l2 = (int) ((total >> 16) * 0.8); 
        int l3 = (int) ((total >> 16) * 0.8); 
        int l4 = (int) ((total >> 16) * 0.8); 
        
//        if(r1 > l1) l1 = 1; else r1 = 0;
//        if(r2 > l2) l2 = 1; else r2 = 0;
//        if(r3 > l3) l3 = 1; else r3 = 0;
//        if(r4 > l4) l4 = 1; else r4 = 0;
        
        
//        System.out.println(r1);
		TextureAtlasSprite sprite = facing == EnumFacing.NORTH ? north.get(state) : facing == EnumFacing.EAST ? east.get(state) : facing == EnumFacing.WEST ? west.get(state) : south.get(state);
		switch(facing) {
			case EAST:                                                                                          
				buffer.pos(x	, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).lightmap(l1, r1).endVertex();
				buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).lightmap(l2, r2).endVertex();
				buffer.pos(x	, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).lightmap(l3, r3).endVertex();
				buffer.pos(x	, y + 1	, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).lightmap(l4, r4).endVertex();
				break;                                                                                                                     
			case NORTH:                                                                                                        
				buffer.pos(x + 1, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).lightmap(l1, r1).endVertex();
				buffer.pos(x	, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).lightmap(l2, r2).endVertex();
				buffer.pos(x	, y + 1	, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).lightmap(l3, r3).endVertex();
				buffer.pos(x + 1, y + 1	, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).lightmap(l4, r4).endVertex();
				break;                                                                                          
			case SOUTH:                                                                                                        
				buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).lightmap(l1, r1).endVertex();
				buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).lightmap(l2, r2).endVertex();
				buffer.pos(x + 1, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).lightmap(l3, r3).endVertex();
				buffer.pos(x	, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).lightmap(l4, r4).endVertex();
				break;                                                                                                                        
			case WEST:                                                                                                                        
				buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).lightmap(l1, r1).endVertex();
				buffer.pos(x + 1, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).lightmap(l2, r2).endVertex();
				buffer.pos(x + 1, y + 1	, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).lightmap(l3, r3).endVertex();
				buffer.pos(x + 1, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).lightmap(l4, r4).endVertex();
				break;                                                                                          
			default:
				break;
		}
	}
	
	public void renderSide(EnumFacing facing, IBlockState state, double x, double y, double z, boolean invert, BufferBuilder buffer) {
		TextureAtlasSprite sprite = facing == EnumFacing.NORTH ? north.get(state) : facing == EnumFacing.EAST ? east.get(state) : facing == EnumFacing.WEST ? west.get(state) : south.get(state);
		if(invert) {
			switch(facing) {
				case EAST:
					buffer.pos(x	, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					break;                                                                                        
				case NORTH:                                                                                       
					buffer.pos(x + 1, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y + 1	, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					break;                                                                                        
				case SOUTH:                                                                                       
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					break;                                                                                        
				case WEST:                                                                                        
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y + 1	, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					break;
				default:
					break;
			}
		}else {
			switch(facing) {
				case EAST:
					buffer.pos(x	, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x	, y + 1	, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).tex(100, 1).endVertex();
					break;                                                                                                    
				case NORTH:                                                                                                   
					buffer.pos(x + 1, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x	, y		, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y + 1	, z + 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).tex(100, 1).endVertex();
					break;                                                                                                    
				case SOUTH:                                                                                                   
					buffer.pos(x	, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x	, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).tex(100, 1).endVertex();
					break;                                                                                                    
				case WEST:                                                                                                    
					buffer.pos(x + 1, y		, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMaxV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y		, z	+ 1	).color(1f, 1f, 1f, 1f).tex(sprite.getMaxU(), sprite.getMinV()).tex(100, 1).endVertex();
					buffer.pos(x + 1, y + 1	, z		).color(1f, 1f, 1f, 1f).tex(sprite.getMinU(), sprite.getMinV()).tex(100, 1).endVertex();
					break;
				default:
					break;
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public static enum EnumNeighborInfo {
        DOWN(new EnumFacing[]{EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH}),
        UP(new EnumFacing[]{EnumFacing.EAST, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.SOUTH}), 
        NORTH(new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.EAST, EnumFacing.WEST}),
        SOUTH(new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.WEST, EnumFacing.EAST}),
        WEST(new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH}), 
        EAST(new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.SOUTH, EnumFacing.NORTH});

        private static final EnumNeighborInfo[] VALUES = new EnumNeighborInfo[6];
    	
        private final EnumFacing[] corners;

        private EnumNeighborInfo(EnumFacing[] corners){
            this.corners = corners;
        }
        
        public static EnumNeighborInfo getNeighbourInfo(EnumFacing facing){
            return VALUES[facing.getIndex()];
        }
        
        static{
            VALUES[EnumFacing.DOWN.getIndex()] = DOWN;
            VALUES[EnumFacing.UP.getIndex()] = UP;
            VALUES[EnumFacing.NORTH.getIndex()] = NORTH;
            VALUES[EnumFacing.SOUTH.getIndex()] = SOUTH;
            VALUES[EnumFacing.WEST.getIndex()] = WEST;
            VALUES[EnumFacing.EAST.getIndex()] = EAST;
        }
    }

}

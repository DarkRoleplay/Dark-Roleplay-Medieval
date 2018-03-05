package net.dark_roleplay.medieval.common.blocks.building;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.blocks.decorative.lecterns.LargeLectern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Timbering extends Block{

	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool RIGHT = PropertyBool.create("right");
	public static final PropertyBool LEFT = PropertyBool.create("left");
	
	public final Map<EntityPlayer, ClickInfo> clicks = new WeakHashMap<EntityPlayer, ClickInfo>();
	public static final Map<String, List<TimberRecipe>> recipes = new HashMap<String, List<TimberRecipe>>();
	
	static {
		recipes.put("clean", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP, ClickLoc.BOTTOM, "vertical"));
			add(new TimberRecipe(ClickLoc.LEFT, ClickLoc.RIGHT, "horizontal"));
			add(new TimberRecipe(ClickLoc.BOTTOM_LEFT, ClickLoc.TOP_RIGHT, "diagonal_bt"));
			add(new TimberRecipe(ClickLoc.TOP_LEFT, ClickLoc.BOTTOM_RIGHT, "diagonal_tb"));
			add(new TimberRecipe(ClickLoc.BOTTOM, ClickLoc.TOP_RIGHT, "double_diagonal_t_bt"));
			add(new TimberRecipe(ClickLoc.BOTTOM_LEFT, ClickLoc.TOP, "double_diagonal_b_bt"));
			add(new TimberRecipe(ClickLoc.BOTTOM, ClickLoc.TOP_LEFT, "double_diagonal_t_tb"));
			add(new TimberRecipe(ClickLoc.TOP, ClickLoc.BOTTOM_RIGHT, "double_diagonal_b_tb"));
			add(new TimberRecipe(ClickLoc.BOTTOM_LEFT, ClickLoc.RIGHT, "double_diagonal_l_lr"));
			add(new TimberRecipe(ClickLoc.LEFT, ClickLoc.TOP_RIGHT, "double_diagonal_r_lr"));
			add(new TimberRecipe(ClickLoc.TOP_LEFT, ClickLoc.RIGHT, "double_diagonal_l_rl"));
			add(new TimberRecipe(ClickLoc.LEFT, ClickLoc.BOTTOM_RIGHT, "double_diagonal_r_rl"));
		}});
		
		recipes.put("diagonal_bt", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP_LEFT, ClickLoc.BOTTOM_RIGHT, "cross"));
		}});

		recipes.put("diagonal_tb", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.BOTTOM_LEFT, ClickLoc.TOP_RIGHT, "cross"));
		}});
		
		recipes.put("double_diagonal_t_bt", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP_LEFT, ClickLoc.BOTTOM, "arrow_b"));
		}});

		recipes.put("double_diagonal_t_tb", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.BOTTOM, ClickLoc.TOP_RIGHT, "arrow_b"));
		}});
		

		recipes.put("double_diagonal_b_bt", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP, ClickLoc.BOTTOM_RIGHT, "arrow_t"));
		}});
		

		recipes.put("double_diagonal_b_tb", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP, ClickLoc.BOTTOM_LEFT, "arrow_t"));
		}});
		recipes.put("double_diagonal_l_lr", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.TOP_LEFT, ClickLoc.RIGHT, "arrow_r"));
		}});

		recipes.put("double_diagonal_l_rl", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.BOTTOM_LEFT, ClickLoc.RIGHT, "arrow_r"));
		}});
		

		recipes.put("double_diagonal_r_lr", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.LEFT, ClickLoc.BOTTOM_RIGHT, "arrow_l"));
		}});
		

		recipes.put("double_diagonal_r_rl", new ArrayList<TimberRecipe>() {{
			add(new TimberRecipe(ClickLoc.LEFT, ClickLoc.TOP_RIGHT, "arrow_l"));
		}});
	}
	
	public Timbering(String name) {
		super(Material.ROCK);
		this.setRegistryName(name);
		this.fullBlock = true;
		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(RIGHT, false).withProperty(DOWN, false).withProperty(LEFT, false));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState()
				.withProperty(UP, (meta & 8) == 8)
				.withProperty(DOWN, (meta & 4) == 4)
				.withProperty(RIGHT, (meta & 2) == 2)
				.withProperty(LEFT, (meta & 1) == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(state.getValue(UP)) meta |= 8;
		if(state.getValue(DOWN)) meta |= 4;
		if(state.getValue(RIGHT)) meta |= 2;
		if(state.getValue(LEFT)) meta |= 1;
		
		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, UP, DOWN, RIGHT, LEFT);
	}
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(player.getHeldItem(hand).getItem().getRegistryName().toString().endsWith("_wood_beam")) {
			
			if(world.isRemote)
				return true;
		
			if(clicks.containsKey(player)) {
				ClickInfo info = clicks.get(player);

				
				if(!info.equals(pos)) {
					this.clicks.replace(player, new ClickInfo(pos, ClickLoc.getLoc(facing, hitX, hitY, hitZ)));
					return true;
				}

				clicks.remove(player);				
				ClickLoc pos1 = info.getLoc();
				ClickLoc pos2 = ClickLoc.getLoc(facing, hitX, hitY, hitZ);
				String[] types = state.getBlock().getRegistryName().getResourcePath().split("_timbering_");
				String[] itemTypes = player.getHeldItem(hand).getItem().getRegistryName().getResourcePath().split("_wood_beam");
				
				if(this.getRegistryName().getResourcePath().contains("clean") && (!state.getValue(UP) && !state.getValue(DOWN) && !state.getValue(RIGHT) && !state.getValue(LEFT))) {
					if(!types[0].equals(itemTypes[0])) {
						IBlockState newState = Block.REGISTRY.getObject(new ResourceLocation(state.getBlock().getRegistryName().toString().replace(types[0], itemTypes[0]))).getDefaultState();
						world.setBlockState(pos, newState);
						state = newState;
						types = state.getBlock().getRegistryName().getResourcePath().split("_timbering_");
					}
				}else if(!types[0].equals(itemTypes[0])) {
					return false;
				}

				
				boolean succes = false;
				if(!state.getValue(UP) && ((pos1 == ClickLoc.TOP_LEFT && pos2 == ClickLoc.TOP_RIGHT) || (pos1 == ClickLoc.TOP_RIGHT && pos2 == ClickLoc.TOP_LEFT))) {
					world.setBlockState(pos, state.withProperty(UP, true));
					succes = true;
				}else if(!state.getValue(RIGHT) && ((pos1 == ClickLoc.BOTTOM_RIGHT && pos2 == ClickLoc.TOP_RIGHT) || (pos1 == ClickLoc.TOP_RIGHT && pos2 == ClickLoc.BOTTOM_RIGHT))) {
					world.setBlockState(pos, state.withProperty(RIGHT, true));
					succes = true;
				}else if(!state.getValue(LEFT) && ((pos1 == ClickLoc.TOP_LEFT && pos2 == ClickLoc.BOTTOM_LEFT) || (pos1 == ClickLoc.BOTTOM_LEFT && pos2 == ClickLoc.TOP_LEFT))) {
					world.setBlockState(pos, state.withProperty(LEFT, true));
					succes = true;
				}else if(!state.getValue(DOWN) && ((pos1 == ClickLoc.BOTTOM_LEFT && pos2 == ClickLoc.BOTTOM_RIGHT) || (pos1 == ClickLoc.BOTTOM_RIGHT && pos2 == ClickLoc.BOTTOM_LEFT))) {
					world.setBlockState(pos, state.withProperty(DOWN, true));
					succes = true;
				}else if(Timbering.recipes.containsKey(types[1])) {
					List<TimberRecipe> recipes = Timbering.recipes.get(types[1]);
					for(TimberRecipe recipe : recipes) {
						if(recipe.equals(pos1, pos2)) {
							world.setBlockState(pos, Block.REGISTRY.getObject(
										new ResourceLocation(state.getBlock().getRegistryName().getResourceDomain(), types[0] + "_timbering_" + recipe.getOutput())
									)
									.getDefaultState().withProperty(UP, state.getValue(UP))
									.withProperty(DOWN, state.getValue(DOWN))
									.withProperty(LEFT, state.getValue(LEFT))
									.withProperty(RIGHT, state.getValue(RIGHT)));
							succes = true;
							break;
						}
					}
				}
				if(succes && !player.capabilities.isCreativeMode) {
					player.getHeldItem(hand).shrink(1);
				}
				return true;
			}else {
				this.clicks.put(player, new ClickInfo(pos, ClickLoc.getLoc(facing, hitX, hitY, hitZ)));
				return true;
			}
		}
        return false;
    }
	
	public static class TimberRecipe {
		private ClickLoc loc1;
		private ClickLoc loc2;
		private String output;
		
		public TimberRecipe(ClickLoc loc1, ClickLoc loc2, String output) {
			this.loc1 = loc1;
			this.loc2 = loc2;
			this.output = output;
		}
		
		public boolean equals(ClickLoc loc1, ClickLoc loc2) {
			return (this.loc1 == loc1 && this.loc2 == loc2) || (this.loc1 == loc2 && this.loc2 == loc1);
		}
		
		public String getOutput() {
			return this.output;
		}
	}
	
	public static class ClickInfo {
		BlockPos pos;
		ClickLoc loc;
		
		public ClickInfo(BlockPos pos, ClickLoc loc) {
			this.pos = pos;
			this.loc = loc;
		}
		
		public boolean equals(BlockPos pos){
			return this.pos.equals(pos);
		}
		
		public ClickLoc getLoc() {
			return this.loc;
		}
	}
	
	public static enum ClickLoc{
		TOP_LEFT,
		TOP,
		TOP_RIGHT,
		RIGHT,
		BOTTOM_RIGHT,
		BOTTOM,
		BOTTOM_LEFT,
		LEFT,
		CENTER;
		
		public static ClickLoc getLoc(EnumFacing facing, float hitX, float hitY, float hitZ) {
			ClickLoc[] locations = getLocationsForHeight(hitY);
			switch(facing) {
				case EAST:					
					return hitZ < 0.25F ? locations[2] : hitZ > 0.75F ? locations[0] : locations[1];
				case NORTH:
					return hitX < 0.25F ? locations[0] : hitX > 0.75F ? locations[2] : locations[1];
				case SOUTH:
					return hitX < 0.25F ? locations[0] : hitX > 0.75F ? locations[2] : locations[1];
				case WEST:
					return hitZ < 0.25F ? locations[2] : hitZ > 0.75F ? locations[0] : locations[1];
				default:
					return null;
			}
		}
		
		private static ClickLoc[] getLocationsForHeight(float hitY) {
			if(hitY > 0.75F) {
				return new ClickLoc[] {TOP_LEFT, TOP, TOP_RIGHT};
			}else if(hitY < 0.25F) {
				return new ClickLoc[] {BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT};
			}else {
				return new ClickLoc[] {LEFT, CENTER, RIGHT};
			}
		}
	}
}

package net.dark_roleplay.medieval.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTest extends Block{

	public BlockTest() {
		super(Material.IRON);
		this.setRegistryName("test");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        world.setBlockToAir(pos);
        onBlockDestroyedByExplosion(world, pos, explosion);
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 8, true);
    }

}

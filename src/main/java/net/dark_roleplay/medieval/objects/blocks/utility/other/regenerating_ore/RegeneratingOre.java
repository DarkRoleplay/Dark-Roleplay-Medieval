package net.dark_roleplay.medieval.objects.blocks.utility.other.regenerating_ore;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.ORE_COUNT;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.ORE_LIMIT;

import java.util.Map;
import java.util.Random;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.variables.wrappers.IntegerWrapper;
import net.dark_roleplay.medieval.holders.configs.Miscellaneous;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegeneratingOre extends DRPBlock{

	Block ore = null;
	IBlockState oreState = null;

	IntegerWrapper regenTime = null;

	public RegeneratingOre(String name, BlockSettings settings, int toolLevel, IntegerWrapper regenTime) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(ORE_LIMIT, 3));
		this.regenTime = regenTime;
		this.setHarvestLevel("pickaxe", toolLevel);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items){
		items.add(new ItemStack(this, 1, 4));
		items.add(new ItemStack(this, 1, 10));
		items.add(new ItemStack(this, 1, 15));
	}

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){return Items.AIR;}

	@Override
    public int quantityDropped(Random random) {return 0; }

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){return ItemStack.EMPTY;}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ORE_LIMIT, Math.max(meta % 4, 1)).withProperty(ORE_COUNT, ((meta & 0b1100) >> 2) % 4);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(ORE_LIMIT) + ((state.getValue(ORE_COUNT) << 2) & 0b1100);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ORE_LIMIT, ORE_COUNT);
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
		int ore = state.getValue(ORE_COUNT);
		if(ore <= 0 && !player.isCreative()) {
			world.markAndNotifyBlock(pos, null, state, state, world.isRemote ? 11 : 3);
			return false;
		}else if(ore <= 0 && player.isCreative()) {
			this.onBlockHarvested(world, pos, state, player);
			return world.setBlockState(pos, Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
		}

        this.onBlockHarvested(world, pos, state, player);
        if(!world.isUpdateScheduled(pos, state.getBlock()))
        	world.scheduleBlockUpdate(pos, state.getBlock(), Miscellaneous.REGEN_TIME_IRON, 0);
        return world.setBlockState(pos, state.withProperty(ORE_COUNT, ore - 1), world.isRemote ? 11 : 3);
    }

	public void setOre(Block ore) {
		this.ore = ore;
		this.oreState = ore.getDefaultState();
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		if(!world.isRemote) return;
		ItemStack heldItem = player.getHeldItemMainhand();
		int fortune = 0;

		ItemStack minedStack = ItemStack.EMPTY;
		if(heldItem.isItemEnchanted()) {
			Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(heldItem);
			if(enchantments.get(Enchantments.FORTUNE) != null) {
				fortune = enchantments.get(Enchantments.FORTUNE);
				minedStack = new ItemStack(this.ore.getItemDropped(this.oreState, player.getRNG(), fortune), this.ore.quantityDroppedWithBonus(fortune, player.getRNG()), this.ore.damageDropped(this.oreState));
			}

			if(enchantments.get(Enchantments.SILK_TOUCH) != null) {
				minedStack = this.ore.getItem(world, pos, this.oreState);
			}
		}else {
			minedStack = new ItemStack(this.ore.getItemDropped(this.oreState, player.getRNG(), fortune), this.ore.quantityDroppedWithBonus(fortune, player.getRNG()), this.ore.damageDropped(this.oreState));
		}

		if(!player.addItemStackToInventory(minedStack)) {
			world.spawnEntity(new EntityItem(world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), minedStack));
		}

		player.addExperience(this.ore.getExpDrop(this.oreState, world, pos, fortune));
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		int ore = state.getValue(ORE_COUNT);
		int oreLimit = state.getValue(ORE_LIMIT);

		world.setBlockState(pos, state.withProperty(ORE_COUNT, Math.min(ore + 1, oreLimit)), world.isRemote ? 11 : 3);
		if(ore + 1 < oreLimit)
			world.scheduleBlockUpdate(pos, state.getBlock(), this.regenTime.get(), 0);
    }

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getStateFromMeta((meta + 1) % 4).withProperty(ORE_COUNT, (meta + 1) % 4);
    }

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return ItemStack.EMPTY;
	}
}

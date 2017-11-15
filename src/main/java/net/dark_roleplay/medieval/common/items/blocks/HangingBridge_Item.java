package net.dark_roleplay.medieval.common.items.blocks;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges.HangingBridge;
import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class HangingBridge_Item extends DRPItem{
	
	public HangingBridge_Item(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}

	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote)
			return EnumActionResult.SUCCESS;

		ItemStack stack = player.getHeldItem(hand);
		
		NBTTagCompound comp = new NBTTagCompound();
		
		if(stack.getTagCompound() == null){
			stack.setTagCompound(comp);
		}else{
			comp = stack.getTagCompound();
		}
		
		
		if(player.isSneaking()){
			if(comp.hasKey("pos1X")){
				comp.removeTag("pos1X");
				comp.removeTag("pos1Y");
				comp.removeTag("pos1Z");
				player.sendMessage(new TextComponentString("Position has been cleared!"));
			}
			stack.setTagCompound(comp);
			
			return EnumActionResult.SUCCESS;
		}
		
		
		if(!comp.hasKey("pos1X")){
			comp.setInteger("pos1X", pos.getX());
			comp.setInteger("pos1Y", pos.getY());
			comp.setInteger("pos1Z", pos.getZ());
			stack.setTagCompound(comp);
			player.sendMessage(new TextComponentString("First Position set to: " + pos.getX() + "|" + pos.getY() + "|" + pos.getZ()));
		}else{
			BlockPos pos2 = new BlockPos(comp.getInteger("pos1X"), comp.getInteger("pos1Y"), comp.getInteger("pos1Z"));
			
			if(pos.getY() != pos2.getY()){
				player.sendMessage(new TextComponentString("Booth ends of the Hangingbridge need to be on the same level!"));
				stack.setTagCompound(null);
				return EnumActionResult.SUCCESS;
			}
			
			int dist = (int) pos.getDistance(pos2.getX(), pos2.getY(), pos2.getZ());
			if(dist > 65){
				comp.removeTag("pos1X");
				comp.removeTag("pos1Y");
				comp.removeTag("pos1Z");
				stack.setTagCompound(comp);
				player.sendMessage(new TextComponentString("The Distance is to big! (maximum 64 blocks yours is: " + dist + "Blocks"));
				stack.setTagCompound(null);
				return EnumActionResult.SUCCESS;
			}else if((pos.getX() != pos2.getX()) && (pos.getZ() != pos2.getZ())) {
				player.sendMessage(new TextComponentString("Hanging Bridges cannot be placed diagonally!"));
				stack.setTagCompound(null);
				return EnumActionResult.SUCCESS;
			}else if(stack.getCount() < (dist -1) && !player.capabilities.isCreativeMode){
				player.sendMessage(new TextComponentString("You are missing " + (dist-1 - stack.getCount()) + " Hangingbridges!"));
				stack.setTagCompound(null);
				return EnumActionResult.SUCCESS;
			}else{
				int posX1 = pos.getX();
				int posX2 = pos2.getX();
				int posZ1 = pos.getZ();
				int posZ2 = pos2.getZ();
				int length = posX1 == posX2 ? posZ1 > posZ2 ? posZ1 - posZ2 : posZ2 - posZ1 : posX1 > posX2 ? posX1 - posX2 : posX2 - posX1;
						
				double offsetX1 = length/2d;
				double offsetX2 = length/2d;
				
				double x1 = Math.pow(offsetX1, 2);
				double x2 = Math.pow(offsetX2, 2);
				
				double y1 = -offsetX1;
				double y2 = offsetX2;
				
				double r1 = (length/2);
				double r2 = (length/2);
				
				double x3 = x1 * Math.abs(y2);
				double x4 = x2 * Math.abs(y1);
				
				double y3 = y1 * Math.abs(y2);
				double y4 = y2 * Math.abs(y1);
				
				double r3 = r1 * Math.abs(y2);
				double r4 = r2 * Math.abs(y1);
				
				double x5 = x3 + x4;
				double r5 = r3 + r4;
				
				double a = r5 / x5;
				double b = ((a * x1) - r1) / -y1;
				
				//Can Place bridge
				for(int i = 1; i < (length); i ++){
					int drop = (int) ((a * Math.pow(i - (length/2), 2)) + ((b * i) - (length/2)));
					BlockPos placePos;
					if(posX1 == posX2){
						placePos = posZ1 > posZ2 ? pos2.add(0,-Math.abs(drop / 16),i) : pos.add(0, -Math.abs(drop / 16),i);
					}else{
						placePos = posX1 > posX2 ? pos2.add(i,-Math.abs(drop / 16),0) : pos.add(i, -Math.abs(drop / 16),0);
					}
					if(!world.isAirBlock(placePos)){
						player.sendMessage(new TextComponentString("Path is Obstructed! Cannot place Bridge here!"));
						stack.setTagCompound(null);
						return EnumActionResult.SUCCESS;
					}
				}
				
				//Place Bridge
				for(int i = 1; i < (length); i ++){
					int drop = (int) ((a * Math.pow(i - (length/2), 2)) + ((b * i) - (length/2)));
					
					IBlockState state;
					BlockPos placePos;
					if(posX1 == posX2){
						placePos = posZ1 > posZ2 ? pos2.add(0,-Math.abs(drop / 16),i) : pos.add(0, -Math.abs(drop / 16),i);
						
						if(((drop % 16) / 8) == 0){
							world.setBlockState(placePos, state = DRPMedievalBlocks.HANGING_BRIDGE_TOP.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X).withProperty(HangingBridge.HEIGHT, 7 - Math.abs(drop % 8)));
						}else{
							world.setBlockState(placePos, state = DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X).withProperty(HangingBridge.HEIGHT, 7 - Math.abs(drop % 8)));
						}
						world.markAndNotifyBlock(placePos, world.getChunkFromBlockCoords(placePos), world.getBlockState(placePos), state, 3);
					}else{
						placePos = posX1 > posX2 ? pos2.add(i,-Math.abs(drop / 16),0) : pos.add(i, -Math.abs(drop / 16),0);
						if(((drop % 16) / 8) == 0){
							world.setBlockState(placePos, state =  DRPMedievalBlocks.HANGING_BRIDGE_TOP.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.Z).withProperty(HangingBridge.HEIGHT, 7 - Math.abs(drop % 8)));
						}else{
							world.setBlockState(placePos, state =  DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.Z).withProperty(HangingBridge.HEIGHT, 7 - Math.abs(drop % 8)));
						}
						world.markAndNotifyBlock(placePos, world.getChunkFromBlockCoords(placePos), world.getBlockState(placePos), state, 3);
					}
				}
			
				stack.shrink(dist-1);
				stack.setTagCompound(null);
			}
		}

		
        return EnumActionResult.SUCCESS;
    }
	
}

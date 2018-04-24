package net.dark_roleplay.medieval.common.crafting;

import java.util.List;
import java.util.UUID;

import net.dark_roleplay.drpcore.api.old.crafting.simple_recipe.SimpleCrafter;
import net.dark_roleplay.drpcore.api.old.crafting.simple_recipe.SimpleRecipe;
import net.dark_roleplay.drpcore.api.old.events.player.Event_PlayerCraft;
import net.dark_roleplay.medieval.api.items.IKey;
import net.dark_roleplay.medieval.api.items.ILock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class LockKeyCrafter extends SimpleCrafter{

	@Override
	public void initializeCrafting(EntityPlayer player, SimpleRecipe recipe, int multiplier) {
		List<ItemStack> inv = player.inventory.mainInventory;

		ItemStack[] ingredients = recipe.getMainIngredients();
		NonNullList<ItemStack> invCopy = NonNullList.<ItemStack>withSize(36, ItemStack.EMPTY);
		for (int i = 0; i < inv.size(); i++) {
			invCopy.set(i, inv.get(i).copy());
		}
		boolean[] missingStacks = hasMaterials(invCopy, ingredients.clone(), recipe.getIgnoreMeta(), multiplier);

		for (int i = 0; i < missingStacks.length; i++) {
			if (!missingStacks[i]) {
				player.sendStatusMessage(new TextComponentString("You are missing the following Item (or more): " + ingredients[i].getDisplayName()), true);
				return;
			}
		}

		consumeMaterials(player, ingredients.clone(), recipe.getIgnoreMeta(), multiplier);
		ItemStack[] outs = recipe.getMainOutput();
		UUID id = UUID.randomUUID();
		for(int i = 0; i < multiplier; i++){
			for (ItemStack s : outs) {
				ItemStack copy = s.copy();
				if(copy.getItem() instanceof ILock){
					System.out.println("LOCK FOUND UUID = " + id.toString());
					((ILock)copy.getItem()).setUUID(copy, id);
				}else if(copy.getItem() instanceof IKey){
					((IKey)copy.getItem()).setUUID(copy, id);
				}
				if (!player.inventory.addItemStackToInventory(copy)) {
					player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ, copy));
				}
			}
		}
		MinecraftForge.EVENT_BUS.post(new Event_PlayerCraft(player, recipe));
		player.openContainer.detectAndSendChanges();
	}
	
}

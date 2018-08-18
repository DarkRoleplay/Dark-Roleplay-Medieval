package net.dark_roleplay.medieval.common.objects.items;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.item.ItemStack;

public class FlintKnife extends DRPItem{

	public FlintKnife(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
		this.setMaxDamage(64);
		this.setHasSubtypes(false);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack){
        return stack.getItem() == this;
    }
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack){
		
        if (!hasContainerItem(itemStack)){
            return ItemStack.EMPTY;
        }
        
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() - 1);
        if(stack.getItemDamage() < 0)
        	return ItemStack.EMPTY;
        return stack.copy();
    }
}

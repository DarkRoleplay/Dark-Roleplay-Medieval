package net.dark_roleplay.medieval.client.objects.blocks.tesrs.helper;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_UniversalShelf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ShelfRenderInformation {

	private ItemMap[] slots = new ItemMap[0];

	private RenderItem itemRenderer;

	public ShelfRenderInformation(TE_UniversalShelf te, RenderItem itemRenderer, Vec3d... offsets) {
		IItemHandler invHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		this.slots = new ItemMap[invHandler.getSlots()];
		for(int i = 0; i < invHandler.getSlots(); i++) {
			this.slots[i] = new ItemMap(ItemStack.EMPTY, null, offsets[i]);
		}
		this.itemRenderer = itemRenderer;
	}

	public ItemMap[] getSlots() {
		return this.slots;
	}

	public class ItemMap{
		public ItemStack stack;
		public IBakedModel model;
		public Vec3d offset;

		public ItemMap(ItemStack stack, IBakedModel model, Vec3d offset){
			this.stack = stack;
			this.model = model;
			this.offset = offset;
		}

		public void refresh(ItemStack stack, World world){
//			this.offset = new Vec3d(0.7, 0.22, -0.2);// new Vec3d(0.1, 0.5, 0.1), new Vec3d(0.5, 0.1, 0.1), new Vec3d(0.5, 0.5, 0.1)
			if(this.stack.equals(stack)){
				return;
			}else{
				this.model = ShelfRenderInformation.this.itemRenderer.getItemModelWithOverrides(stack, world, (EntityLivingBase)null);
				this.stack = stack;
			}
		}

		public void render(){
			if(this.stack != null && this.model != null){
				GL11.glPushMatrix();
				GlStateManager.translate(this.offset.x, this.offset.y, this.offset.z);
				GlStateManager.scale(0.3F,0.3F, 0.3F);
				ShelfRenderInformation.this.itemRenderer.renderItem(this.stack, ForgeHooksClient.handleCameraTransforms(this.model, ItemCameraTransforms.TransformType.NONE, false));
				GL11.glPopMatrix();
			}
		}
	}
}

package net.dark_roleplay.medieval.client.objects.blocks.tesrs;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.shelf.Shelf;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.shelf.TE_Shelf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class TESR_Shelf  extends TileEntitySpecialRenderer<TE_Shelf> {

    private RenderItem itemRenderer;
	
    private ItemMap slot1 = new ItemMap(ItemStack.EMPTY, null);
    private ItemMap slot2 = new ItemMap(ItemStack.EMPTY, null);
    private ItemMap slot3 = new ItemMap(ItemStack.EMPTY, null);
    private ItemMap slot4 = new ItemMap(ItemStack.EMPTY, null);
    
	public TESR_Shelf(RenderItem itemRenderer) {
		this.itemRenderer = itemRenderer;
	}

	@Override  
	public void render(TE_Shelf te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		
		Vec3d playerPos = Minecraft.getMinecraft().player.getPositionEyes(partialTicks);
		BlockPos tePos = te.getPos();
		
		IBlockState state  = te.getWorld().getBlockState(te.getPos());
		if(!(state.getBlock() instanceof Shelf))
			return;
		
		EnumFacing facing = (EnumFacing) state.getValue(BlockProperties.FACING);
		
		if(facing == EnumFacing.NORTH){
			if(playerPos.z >= tePos.getZ())
				return;
		}else if(facing == EnumFacing.EAST){
			if(playerPos.x <= tePos.getX() + 1)
				return;
		}else if(facing == EnumFacing.SOUTH){
			if(playerPos.z <= tePos.getZ() + 1)
				return;
		}else if(facing == EnumFacing.WEST){
			if(playerPos.x >= tePos.getX())
				return;
		}
		
		if(this.itemRenderer == null)
			this.itemRenderer = Minecraft.getMinecraft().getRenderItem();
		
		IItemHandler invHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		slot1.refresh(invHandler.getStackInSlot(0), te.getWorld());
		slot2.refresh(invHandler.getStackInSlot(1), te.getWorld());
		slot3.refresh(invHandler.getStackInSlot(2), te.getWorld());
		slot4.refresh(invHandler.getStackInSlot(3), te.getWorld());

        Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		
		GL11.glPushMatrix();
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.alphaFunc(516, 0.1F);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        GL11.glPushMatrix();
        switch(facing){
			case EAST:
				GlStateManager.translate(x + 0.75, y + 0.30, z + 0.75);
				GlStateManager.rotate(-90F, 0F, 1F, 0F);
	        	slot1.render();
				GlStateManager.translate(-0.5, 0, 0);
	        	slot2.render();				
	        	GlStateManager.translate(0.5, 0.45, 0);
	        	slot4.render();				
	        	GlStateManager.translate(-0.5, 0, 0);
	        	slot3.render();
				break;
			case NORTH:
				GlStateManager.translate(x + 0.75, y + 0.30, z + 0.25);
	        	slot1.render();
				GlStateManager.translate(-0.5, 0, 0);
	        	slot2.render();				
	        	GlStateManager.translate(0.5, 0.45, 0);
	        	slot3.render();				
	        	GlStateManager.translate(-0.5, 0, 0);
	        	slot4.render();
				break;
			case SOUTH:
				GlStateManager.translate(x + 0.25, y + 0.30, z + 0.75);
				GlStateManager.rotate(180F, 0F, 1F, 0F);
	        	slot1.render();
				GlStateManager.translate(-0.5, 0, 0);
	        	slot2.render();				
	        	GlStateManager.translate(0.5, 0.45, 0);
	        	slot3.render();				
	        	GlStateManager.translate(-0.5, 0, 0);
	        	slot4.render();
				break;
			case WEST:
				GlStateManager.translate(x + 0.25, y + 0.30, z + 0.75);
				GlStateManager.rotate(90F, 0F, 1F, 0F);
	        	slot1.render();
				GlStateManager.translate(0.5, 0, 0);
	        	slot2.render();				
	        	GlStateManager.translate(-0.5, 0.45, 0);
	        	slot4.render();				
	        	GlStateManager.translate(0.5, 0, 0);
	        	slot3.render();
				break;
			default:
				break;
        }
        GL11.glPopMatrix();
        
        GlStateManager.disableBlend();
        GL11.glPopMatrix();
	}
	
	public class ItemMap{
		public ItemStack stack;
		public IBakedModel model;
		
		public ItemMap(ItemStack stack, IBakedModel model){
			this.stack = stack;
			this.model = model;
		}
		
		public void refresh(ItemStack stack, World world){
			if(this.stack.equals(stack)){
				return;
			}else{
				this.model = TESR_Shelf.this.itemRenderer.getItemModelWithOverrides(stack, world, (EntityLivingBase)null);
				this.stack = stack;
			}
		}
		
		public void render(){
			if(stack != null && model != null){
				GL11.glPushMatrix();
				GlStateManager.scale(0.3F,0.3F, 0.3F);
				TESR_Shelf.this.itemRenderer.renderItem(stack, ForgeHooksClient.handleCameraTransforms(this.model, ItemCameraTransforms.TransformType.NONE, false));
				GL11.glPopMatrix();
			}
		}
	}
}

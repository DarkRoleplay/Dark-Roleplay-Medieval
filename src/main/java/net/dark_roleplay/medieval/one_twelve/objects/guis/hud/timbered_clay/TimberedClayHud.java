package net.dark_roleplay.medieval.one_twelve.objects.guis.hud.timbered_clay;

public class TimberedClayHud{//  extends Hud{
//
//	private boolean enabled = true;
//
//	public TimberedClayHud(ResourceLocation registryName) {
//		super(registryName);
//		this.posX = 0;
//		this.posY = 0;
//		this.alignment = ALIGNMENT.LEFT;
//	}
//
//	@Override
//	public void render(int width, int height, float partialTicks) {
//			if(!this.enabled) return;
//		if(TimberedClay.clicks.containsKey(Minecraft.getInstance().player)) {
//			ClickInfo info = TimberedClay.clicks.get(Minecraft.getInstance().player);
//
//			int baseX = this.alignment.getBaseX(width, 0) + this.posX;
//			int baseY = this.alignment.getBaseY(height, 0) + this.posY;
//
//			IBlockState state = Minecraft.getInstance().world.getBlockState(info.getPos());
//
//			if(!(state.getBlock() instanceof TimberedClay)) return;
//
//			String[] types = state.getBlock().getRegistryName().getPath().split("_timbered_clay_");
//			if(TimberedClay.recipes.containsKey(types[1])) {
//				List<TimberRecipe> recipes = TimberedClay.recipes.get(types[1]).stream().filter(rec -> rec.getLoc1() == info.getLoc() || rec.getLoc2() == info.getLoc()).collect(Collectors.toList());
//				int amount = recipes.size();
//
//				int yOffset = -((amount * 18) / 2);
//
//				int i = 0;
////				Hud.drawCenteredRect(10, baseY + yOffset, 4, 0D, 0xFFDDDDDD);
//
//				float[] mult1 = this.getMultipliers(info.getLoc());
//				for(TimberRecipe recipe : recipes) {
//					recipe.getLoc1();
//
//					float[] mult2 = this.getMultipliers(recipe.getLoc1() == info.getLoc() ? recipe.getLoc2() : recipe.getLoc1());
//					Hud.drawCenteredRect(baseX + 8, baseY + 8 + yOffset + (i * 18), 9, 0D, 0xAF000000);
//
//					drawLine((baseX + 3 + (int)(mult1[0] * 10)), baseY + 3 + yOffset + (i * 18) + (int)(mult1[1] * 10), baseX + 3 + (int)(mult2[0] * 10), baseY + 3 + yOffset + (i * 18) + (int)(mult2[1] * 10), 0xFFFFFFAA);
//					Hud.drawCenteredRect(baseX + 3 + (int)(mult1[0] * 10), baseY + 3 + yOffset + (i * 18) + (int)(mult1[1] * 10), 2, 0D, 0xFFFFAAAA);
//					Hud.drawCenteredRect(baseX + 3 + (int)(mult2[0] * 10), baseY + 3 + yOffset + (i * 18) + (int)(mult2[1] * 10), 2, 0D, 0xFFAAFFAA);
//
//
////					float[] mult3 = this.getMultipliers(recipe.getLoc1());
////					Hud.drawCenteredRect(baseX + 3 + (int)(mult3[0] * 10), baseY + 3 + yOffset + (i * 18) + (int)(mult3[1] * 10), 2, 0D, 0xFFFFAAAA);
//
////					this.drawRect((int) (this.posX + (mult1[0] * 12)), (int) (this.posY + yOffset + (mult1[1] * 12)), (int) (this.posX + (mult1[0] * 12) + 4), (int) (this.posY + yOffset + (mult1[1] * 12) + 4(), 0xFFDDDDDD);
//					i++;
//				}
//			}
//		}
//	}
//
//	private float[] getMultipliers(ClickLoc loc) {
//		float[] multipliers;
//
//		switch(loc) {
//			case BOTTOM:
//				multipliers = new float[] {0.5F, 1.0F};
//				break;
//			case BOTTOM_LEFT:
//				multipliers = new float[] {0.0F, 1.0F};
//				break;
//			case BOTTOM_RIGHT:
//				multipliers = new float[] {1.0F, 1.0F};
//				break;
//			case CENTER:
//				multipliers = new float[] {0.5F, 0.5F};
//				break;
//			case LEFT:
//				multipliers = new float[] {0.0F, 0.5F};
//				break;
//			case RIGHT:
//				multipliers = new float[] {1.0F, 0.5F};
//				break;
//			case TOP:
//				multipliers = new float[] {0.5F, 0.0F};
//				break;
//			case TOP_LEFT:
//				multipliers = new float[] {0.0F, 0.0F};
//				break;
//			case TOP_RIGHT:
//				multipliers = new float[] {1.0F, 0.0F};
//				break;
//			default:
//				multipliers = new float[] {0.0F, 0.0F};
//				break;
//		}
//
//		return multipliers;
//	}
//
//	@Override
//	public JsonObject writeToDefaultConfig() {
//		JsonObject obj = super.writeToDefaultConfig();
//		obj.addProperty("enabled", true);
//		return obj;
//	}
//
//	@Override
//	public void readFromConfig(JsonObject obj){
//		super.readFromConfig(obj);
//		this.enabled = obj.has("enabled") ? obj.get("enabled").getAsBoolean() : true;
//	}
}

package net.dark_roleplay.medieval.objects.enums;

import net.minecraft.util.IStringSerializable;

public class TorchHolderEnums{
	
	public static enum Addons implements IStringSerializable{
		NONE("none"),
		LIGHTER("lighter"),
		LEVER("lever"),
		PULLED_LEVER("pulled_lever"),
		HIDDEN_LEVER("hidden_lever"),
		PULLED_HIDDEN_LEVER("pulled_hidden_lever");

		private String name;
		
		private Addons(String name) {
			this.name = name;
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
	
	public static enum Torch implements IStringSerializable{
		NONE("none"),
		UNLIT("unlit"),
		LIT("lit");
		
		private String name;
		
		private Torch(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}
}
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
		
		public boolean isLever() {
			return this == LEVER || this == PULLED_LEVER || this == HIDDEN_LEVER || this == PULLED_HIDDEN_LEVER;
		}
		
		public boolean isPulledLever() {
			return this == PULLED_LEVER || this == PULLED_HIDDEN_LEVER;
		}
		
		public Addons toggleLever() {
			if(this == LEVER) return PULLED_LEVER;
			else if(this == PULLED_LEVER) return LEVER;
			else if(this == HIDDEN_LEVER) return PULLED_HIDDEN_LEVER;
			else if(this == PULLED_HIDDEN_LEVER) return HIDDEN_LEVER;
			return this;
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
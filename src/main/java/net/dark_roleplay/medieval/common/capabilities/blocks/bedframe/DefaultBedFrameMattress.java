package net.dark_roleplay.medieval.common.capabilities.blocks.bedframe;

import net.dark_roleplay.medieval.common.blocks.helper.EnumMattressType;

public class DefaultBedFrameMattress implements IBedFrameMattress{

	private EnumMattressType mattress = EnumMattressType.NONE;
	
	@Override
	public void setMattress(EnumMattressType mattress) {
		this.mattress = mattress;
	}

	@Override
	public EnumMattressType getMattress() {
		return this.mattress;
	}
	
}

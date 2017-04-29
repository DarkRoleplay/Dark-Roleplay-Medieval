package net.dark_roleplay.medieval.common.capabilities.blocks.bedframe;

import net.dark_roleplay.medieval.common.blocks.helper.EnumMattressType;

public interface IBedFrameMattress {

	public void setMattress(EnumMattressType mattress);
	
	public EnumMattressType getMattress();
}

package net.drpmedieval.common.capabilities.blocks.bedframe;

import net.drpmedieval.common.blocks.helper.EnumMattressType;

public interface IBedFrameMattress {

	public void setMattress(EnumMattressType mattress);
	
	public EnumMattressType getMattress();
}

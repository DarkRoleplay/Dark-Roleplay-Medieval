package net.drpmedieval.client.gui;


public enum Note {
	//((short) -3, (short)0,1f,f),
	FULL_NONE((short) 100, (short)0,0f,0.0f),
	FULL_1_FIS((short) -3, (short)0,1f,0.5f),
	FULL_1_G((short) -2, (short)0,1f,0.53f),
	FULL_1_GIS((short) -1, (short)0,1f,0.56f),
	FULL_1_A((short) 0, (short)0,1f,0.6f),
	FULL_1_B((short) 1, (short)0,1f,0.63f),
	FULL_1_H((short) 2, (short)0,1f,0.67f),
	FULL_1_C((short) -3, (short)0,1f,0.7f),
	FULL_1_CIS((short) -2, (short)0,1f,0.75f),
	FULL_1_D((short) -1, (short)0,1f,0.8f),
	FULL_1_DIS((short) 0, (short)0,1f,0.85f),
	FULL_1_E((short) 1, (short)0,1f,0.9f),
	FULL_1_F((short) 2, (short)0,1f,0.95f),
	
	FULL_2_FIS((short) -3, (short)0,1f,1.0f),
	FULL_2_G((short) -2, (short)0,1f,1.05f),
	FULL_2_GIS((short) -1, (short)0,1f,1.1f),
	FULL_2_A((short) 0, (short)0,1f,1.2f),
	FULL_2_B((short) 1, (short)0,1f,1.25f),
	FULL_2_H((short) 2, (short)0,1f,1.32f),
	FULL_2_C((short) -3, (short)0,1f,1.4f),
	FULL_2_CIS((short) -2, (short)0,1f,1.5f),
	FULL_2_D((short) -1, (short)0,1f,1.6f),
	FULL_2_DIS((short) 0, (short)0,1f,1.7f),
	FULL_2_E((short) 1, (short)0,1f,1.8f),
	FULL_2_F((short) 2, (short)0,1f,1.9f),
			
	FULL_3_FIS((short) -3, (short)0,1f,2.0f),
	
	FULL_C((short)-3,(short)0,1f,0.5f),
	FULL_A((short)-2,(short)0,1f,0.6f);

	
	private short lane;
	private short type;
	private float volume;
	private float pitch;
	
	private Note(short lane, short type, float volume, float pitch){
		this.lane = lane;
		this.type = type;
		this.volume = volume;
		this.pitch = pitch;
	}
	
	public short getType(){
		return this.type;
	}
	
	public short getLane(){
		return this.lane;
	}
	
	private short getVolume(){
		return this.getVolume();
	}
	
	private float getPitch(){
		return this.getPitch();
	}
}


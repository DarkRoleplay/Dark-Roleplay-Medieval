package net.dark_roleplay.medieval.testing.entity_models;

import net.minecraft.client.renderer.BufferBuilder;

public class Model implements IBetterModel{

	int[] vertexOrder = new int[] {
		0, 1, 2, 3,
		1, 2, 5, 6
	};
	int[][] vertices = new int[0][];

	int w = 16, h = 16;
	public Model() {
		this.vertices = new int[8][];

		this.vertices[0] = vertexToInts(0, 0, 0, -1, 0, 0, this.w, this.h);
		this.vertices[1] = vertexToInts(1, 0, 0, -1, 1, 0, this.w, this.h);
		this.vertices[2] = vertexToInts(1, 1, 0, -1, 1, 1, this.w, this.h);
		this.vertices[3] = vertexToInts(0, 1, 0, -1, 0, 1, this.w, this.h);
		this.vertices[4] = vertexToInts(0, 0, 1, -1, 0, 0, this.w, this.h);
		this.vertices[5] = vertexToInts(1, 0, 1, -1, 1, 0, this.w, this.h);
		this.vertices[6] = vertexToInts(1, 1, 1, -1, 1, 1, this.w, this.h);
		this.vertices[7] = vertexToInts(0, 1, 1, -1, 0, 1, this.w, this.h);
	}

	@Override
	public void render(BufferBuilder buffer) {
		for(int i = 0; i < this.vertexOrder.length; i++)
			buffer.addVertexData(this.vertices[this.vertexOrder[i]]);
	}

	private static int[] vertexToInts(float x, float y, float z, int color, int u, int v, int texWidht, int texHeight) {
		return new int[] { Float.floatToRawIntBits(x), Float.floatToRawIntBits(y), Float.floatToRawIntBits(z),
			Float.floatToRawIntBits((1f / texWidht) * u),
			Float.floatToRawIntBits((1f / texHeight) * v),
			color
		};
	}


//	private static int[] createFullQuad(EnumFacing facing, TextureAtlasSprite sprite) {
//		int[] output = new int[0];
//
//		output = ArrayUtils.addAll(output, vertexToInts(0, 1, 0, -1, sprite, 0, 16));
//		output = ArrayUtils.addAll(output, vertexToInts(0, 1, 1, -1, sprite, 16, 16));
//		output = ArrayUtils.addAll(output, vertexToInts(0, 2, 1, -1, sprite, 16, 0));
//		output = ArrayUtils.addAll(output, vertexToInts(0, 2, 0, -1, sprite, 0, 0));
//
//		return output;
//	}
}

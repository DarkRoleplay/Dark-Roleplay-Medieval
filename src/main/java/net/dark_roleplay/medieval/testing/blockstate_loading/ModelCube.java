package net.dark_roleplay.medieval.testing.blockstate_loading;

public class ModelCube{}//  {
//	/**
//	 * The (x,y,z) vertex positions and (u,v) texture coordinates for each of
//	 * the 8 points on a cube
//	 */
//	private final PositionTextureVertex[] vertexPositions;
//	/** An array of 6 TexturedQuads, one for each face of a cube */
//	private final TextureQuad[] quadList;
//	/** X vertex coordinate of lower box corner */
//	public final float posX1;
//	/** Y vertex coordinate of lower box corner */
//	public final float posY1;
//	/** Z vertex coordinate of lower box corner */
//	public final float posZ1;
//	/** X vertex coordinate of upper box corner */
//	public final float posX2;
//	/** Y vertex coordinate of upper box corner */
//	public final float posY2;
//	/** Z vertex coordinate of upper box corner */
//	public final float posZ2;
//	public String boxName;
//
//	public ModelCube(ModelRenderer renderer, int texU, int texV, float x, float y, float z, float dx, float dy, float dz, float delta) {
//		this(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
//	}
//
//	public ModelCube(ModelRenderer renderer, int texU, int texV, float x, float y, float z, float dx, float dy, float dz, float delta, boolean mirror) {
//		this.posX1 = x;
//		this.posY1 = y;
//		this.posZ1 = z;
//		this.posX2 = x + (float) dx;
//		this.posY2 = y + (float) dy;
//		this.posZ2 = z + (float) dz;
//		this.vertexPositions = new PositionTextureVertex[8];
//		this.quadList = new TextureQuad[6];
//		float f = x + (float) dx;
//		float f1 = y + (float) dy;
//		float f2 = z + (float) dz;
//		x = x - delta;
//		y = y - delta;
//		z = z - delta;
//		f = f + delta;
//		f1 = f1 + delta;
//		f2 = f2 + delta;
//
//		if (mirror) {
//			float f3 = f;
//			f = x;
//			x = f3;
//		}
//
//		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(x, y, z, 0.0F, 0.0F);
//		PositionTextureVertex positiontexturevertex = new PositionTextureVertex(f, y, z, 0.0F, 8.0F);
//		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f, f1, z, 8.0F, 8.0F);
//		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(x, f1, z, 8.0F, 0.0F);
//		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(x, y, f2, 0.0F, 0.0F);
//		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(f, y, f2, 0.0F, 8.0F);
//		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(f, f1, f2, 8.0F, 8.0F);
//		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(x, f1, f2, 8.0F, 0.0F);
//		this.vertexPositions[0] = positiontexturevertex7;
//		this.vertexPositions[1] = positiontexturevertex;
//		this.vertexPositions[2] = positiontexturevertex1;
//		this.vertexPositions[3] = positiontexturevertex2;
//		this.vertexPositions[4] = positiontexturevertex3;
//		this.vertexPositions[5] = positiontexturevertex4;
//		this.vertexPositions[6] = positiontexturevertex5;
//		this.vertexPositions[7] = positiontexturevertex6;
//		this.quadList[0] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex4, positiontexturevertex, positiontexturevertex1, positiontexturevertex5 },
//				(float) Math.ceil(texU + dz + dx), (float) Math.ceil(texV + dz), texU + dz + dx + dz, texV + dz + dy, renderer.textureWidth,
//				renderer.textureHeight);
//		this.quadList[1] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex7, positiontexturevertex3, positiontexturevertex6, positiontexturevertex2 },
//				(float) Math.ceil(texU), (float) Math.ceil(texV + dz), texU + dz, texV + dz + dy, renderer.textureWidth, renderer.textureHeight);
//		this.quadList[2] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex4, positiontexturevertex3, positiontexturevertex7, positiontexturevertex },
//				(float) Math.ceil(texU + dz), (float) Math.ceil(texV), texU + dz + dx, texV + dz, renderer.textureWidth, renderer.textureHeight);
//		this.quadList[3] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex1, positiontexturevertex2, positiontexturevertex6, positiontexturevertex5 },
//				(float) Math.ceil(texU + dz + dx), (float) Math.ceil(texV + dz), texU + dz + dx + dx, texV, renderer.textureWidth, renderer.textureHeight);
//		this.quadList[4] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex, positiontexturevertex7, positiontexturevertex2, positiontexturevertex1 },
//				(float) Math.ceil(texU + dz), (float) Math.ceil(texV + dz), texU + dz + dx, texV + dz + dy, renderer.textureWidth, renderer.textureHeight);
//		this.quadList[5] = new TextureQuad(
//				new PositionTextureVertex[] { positiontexturevertex3, positiontexturevertex4, positiontexturevertex5, positiontexturevertex6 },
//				(float) Math.ceil(texU + dz + dx + dz), (float) Math.ceil(texV + dz), texU + dz + dx + dz + dx, texV + dz + dy, renderer.textureWidth,
//				renderer.textureHeight);
//
//		if (mirror) {
//			for (TextureQuad texturedquad : this.quadList) {
//				texturedquad.flipFace();
//			}
//		}
//	}
//
//	@SideOnly(Side.CLIENT)
//	public void render(BufferBuilder renderer, float scale) {
//		for (TextureQuad texturedquad : this.quadList) {
//			texturedquad.draw(renderer, scale);
//		}
//	}
//
//	public ModelCube setBoxName(String name) {
//		this.boxName = name;
//		return this;
//	}
//}
package net.dark_roleplay.medieval.testing.blocks.hanging_bridge_v2;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.math.Vec3d;

public class RopeBridgeModel{

	List<TexturedVertex> vertices = new ArrayList<TexturedVertex>();

	public RopeBridgeModel(Vec3d posA1, Vec3d posA2, Vec3d posB1, Vec3d posB2) {
		posA1 = posA1.add(new Vec3d(1,1,1));
		posA2 = posA2.add(new Vec3d(1,1,1));
		posB1 = posB1.add(new Vec3d(1,1,1));
		posB2 = posB2.add(new Vec3d(1,1,1));
		 this.addHandel(posA1, posA2);
		 this.addHandel(posB1, posB2);
	}

	private void addHandel(Vec3d posA, Vec3d posB) {
		float width = 0.0625f;
		TextureAtlasSprite rope = Minecraft.getInstance().getTextureMap().getAtlasSprite("drpmedieval:blocks/rope");

		Vec3d size = posB.subtract(posA);
		double distance = size.length();
		for(double i = 0d; i < distance; i++) {

			float u0 = rope.getMinU();
			float u1 = rope.getMinU() + (((rope.getMaxU() - rope.getMinU()) / 16) * 2);
			float u2 = rope.getMinU() + (((rope.getMaxU() - rope.getMinU()) / 16) * 4);
			float u3 = rope.getMinU() + (((rope.getMaxU() - rope.getMinU()) / 16) * 6);
			float u4 = rope.getMinU() + (((rope.getMaxU() - rope.getMinU()) / 16) * 8);
			float uMax = rope.getMaxU();

			float v0 = rope.getMinV();
			float v1 = rope.getMinV() + (((rope.getMaxV() - rope.getMinV()) / 16) * 2);
			float v2 = rope.getMinV() + (((rope.getMaxV() - rope.getMinV()) / 16) * 4);
			float v3 = rope.getMinV() + (((rope.getMaxV() - rope.getMinV()) / 16) * 6);
			float v4 = rope.getMinV() + (((rope.getMaxV() - rope.getMinV()) / 16) * 8);
			float vMax = rope.getMaxV();

			Vec3d part1 = posA.add(new Vec3d((size.x / distance) * (i - 1), (size.y / distance) * (i - 1), (size.z / distance) * (i - 1)));
			Vec3d part2 = posA.add(new Vec3d((size.x / distance) * i, (size.y / distance) * i, (size.z / distance) * i));
			this.addHorizontalColon(part1, part2, u0, u1, u2, u3, u4, v0, vMax, width);
			this.addVerticalColon(part1, part1.add(new Vec3d(0, -1, 0)), u0, u1, u2, u3, u4, v0, vMax, width);
		}
	}

	private void addHorizontalColon(Vec3d pos1, Vec3d pos2, float u0, float u1, float u2, float u3, float u4, float v0, float v1, float width) {
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y - width, pos1.z - width, u0, v0));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y - width, pos2.z - width, u0, v1));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y + width, pos2.z - width, u1, v1));
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y + width, pos1.z - width, u1, v0));

		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y - width, pos2.z - width, u2, v0));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y - width, pos1.z - width, u2, v1));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y + width, pos1.z - width, u3, v1));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y + width, pos2.z - width, u3, v0));

		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y + width, pos1.z - width, u1, v0));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y + width, pos2.z - width, u1, v1));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y + width, pos2.z - width, u2, v1));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y + width, pos1.z - width, u2, v0));

		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y - width, pos2.z - width, u3, v0));
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y - width, pos1.z - width, u3, v1));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y - width, pos1.z - width, u4, v1));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y - width, pos2.z - width, u4, v0));
	}

	private void addVerticalColon(Vec3d pos1, Vec3d pos2, float u0, float u1, float v0, float v1, float v2, float v3, float v4, float width) {
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y - width, pos1.z - width, u0, v0));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y - width, pos2.z - width, u0, v1));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y + width, pos2.z - width, u1, v1));
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y + width, pos1.z - width, u1, v0));

		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y - width, pos2.z - width, u0, v1));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y - width, pos1.z - width, u0, v2));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y + width, pos1.z - width, u1, v2));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y + width, pos2.z - width, u1, v1));

		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y + width, pos1.z - width, u0, v2));
		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y + width, pos2.z - width, u0, v3));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y + width, pos2.z - width, u1, v3));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y + width, pos1.z - width, u1, v2));

		this.vertices.add(new TexturedVertex(pos2.x - width, pos2.y - width, pos2.z - width, u0, v3));
		this.vertices.add(new TexturedVertex(pos1.x - width, pos1.y - width, pos1.z - width, u0, v4));
		this.vertices.add(new TexturedVertex(pos1.x + width, pos1.y - width, pos1.z - width, u1, v4));
		this.vertices.add(new TexturedVertex(pos2.x + width, pos2.y - width, pos2.z - width, u1, v3));
	}

	public List<TexturedVertex> getQuads() {
		return this.vertices;
	}

	public static class TexturedVertex{

		public float x, y, z;
		public float u, v;

		public TexturedVertex(double x, double y, double z, float u, float v) {
			this.x = (float) x;
			this.y = (float) y;
			this.z = (float) z;
			this.u = u;
			this.v = v;
		}
	}
}

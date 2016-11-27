package com.mtautumn.edgequest.window.layers;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import com.mtautumn.edgequest.Projectile;
import com.mtautumn.edgequest.window.Renderer;

public class Projectiles {
	public static void draw(Renderer r) {
		Color.white.bind();
		for( int i = 0; i < r.dataManager.savable.projectiles.size(); i++) {
			Projectile projectile = r.dataManager.savable.projectiles.get(i);
			if (projectile.level == r.dataManager.savable.dungeonLevel) {
				if (projectile.level == - 1 || (projectile.dungeonX == r.dataManager.savable.dungeonX && projectile.dungeonY == r.dataManager.savable.dungeonY)) {
					drawProjectile(r.textureManager.getTexture(projectile.texture), projectile.x, projectile.y, -projectile.angle, r);
				}
			}
		}
	}
	private static void drawProjectile(Texture texture, double posX, double posY, double rotation, Renderer r) {
		if (texture != null) {
			double blockSize = r.dataManager.settings.blockSize;
			double pixelsX = (float) ((posX - (r.dataManager.system.screenX - (Double.valueOf(r.dataManager.settings.screenWidth)/2.0)/blockSize))*blockSize);
			double pixelsY = (float) ((posY - (r.dataManager.system.screenY - (Double.valueOf(r.dataManager.settings.screenHeight)/2.0)/blockSize))*blockSize);
			r.drawTexture(texture, (float) (pixelsX - blockSize / 2.0), (float) (pixelsY - blockSize / 2.0), (float) blockSize, (float) blockSize, (float) rotation);
		}
	}
}
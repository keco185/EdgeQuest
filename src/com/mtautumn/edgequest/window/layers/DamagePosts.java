package com.mtautumn.edgequest.window.layers;

import org.newdawn.slick.Color;

import com.mtautumn.edgequest.DamagePost;
import com.mtautumn.edgequest.window.Renderer;

public class DamagePosts {
	public static void draw(Renderer r) {
		Color.white.bind();
		for( int i = 0; i < r.dataManager.savable.damagePosts.size(); i++) {
			DamagePost post = r.dataManager.savable.damagePosts.get(i);
			if (post.level == r.dataManager.savable.dungeonLevel) {
				if (post.level == - 1 || (post.dungeonX == r.dataManager.savable.dungeonX && post.dungeonY == r.dataManager.savable.dungeonY)) {
					drawPost(post.getX(), post.getY(), post.damage, r);
				}
			}
		}
	}
	private static void drawPost(double x, double y, int damage, Renderer r) {
		double blockSize = r.dataManager.settings.blockSize;
		float pixelsX = (float) ((x - (r.dataManager.system.screenX - (Double.valueOf(r.dataManager.settings.screenWidth)/2.0)/blockSize))*blockSize);
		float pixelsY = (float) ((y - (r.dataManager.system.screenY - (Double.valueOf(r.dataManager.settings.screenHeight)/2.0)/blockSize))*blockSize);
		r.damageFont.drawString(pixelsX, pixelsY, Integer.toString(damage), Color.red);
	}
}
package com.mtautumn.edgequest.window.layers;

import org.newdawn.slick.Color;

import com.mtautumn.edgequest.window.Renderer;

public class MouseItem {
	public static void draw(Renderer r) {
		drawItem(r);
	}
	private static void drawItem(Renderer r) {
		if (r.dataManager.savable.mouseItem.getItemCount() > 0) {
			int posX = (int) (r.dataManager.system.mousePosition.getX() - (int)(24 * r.dataManager.system.uiZoom));
			int posY = (int) (r.dataManager.system.mousePosition.getY() - (int)(24 * r.dataManager.system.uiZoom));
			r.drawTexture(r.dataManager.system.blockIDMap.get(r.dataManager.savable.mouseItem.getItemID()).getItemImg(r.dataManager.savable.time), posX, posY, (int)(48 * r.dataManager.system.uiZoom), (int)(48 * r.dataManager.system.uiZoom));
			if (r.dataManager.savable.mouseItem.getItemCount() > 1) {
				r.backpackFont.drawString(posX, posY, "" + r.dataManager.savable.mouseItem.getItemCount(), Color.black);
			}
		}
		
	}
	
}

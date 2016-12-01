package com.mtautumn.edgequest.window.layers;

import org.newdawn.slick.Color;

import com.mtautumn.edgequest.ConsoleManager.Line;
import com.mtautumn.edgequest.window.Renderer;

public class Console {
	private static final int consoleWidth = 500;
	private static final int consoleHeight = 200;
	private static final int lineCount = 8;
	public static void draw(Renderer r) {
		Color.white.bind();
		int screenWidth = r.dataManager.settings.screenWidth;
		r.fillRect(screenWidth - (int)((10 + consoleWidth) * r.dataManager.system.uiZoom),(int)(10 * r.dataManager.system.uiZoom), (int)(consoleWidth * r.dataManager.system.uiZoom), (int)(consoleHeight * r.dataManager.system.uiZoom), 0.7f, 0.7f, 0.7f, 0.9f);
		Line[] lines = r.dataManager.consoleManager.getNewestLines(lineCount);
		for (int i = 0; i < lineCount; i++) {
			Line line = lines[i];
			if (line != null) {
				r.font.drawString(screenWidth - (int) (consoleWidth * r.dataManager.system.uiZoom),(int)((consoleHeight -  (i + 1) * consoleHeight / (lineCount + 1) - 10) * r.dataManager.system.uiZoom), line.getText(), line.color);
			}
		}
		r.font.drawString(screenWidth - (int)(consoleWidth * r.dataManager.system.uiZoom),(int)((consoleHeight - 10) * r.dataManager.system.uiZoom), r.dataManager.system.consoleText);
	}
}

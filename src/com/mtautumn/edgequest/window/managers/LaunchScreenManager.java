package com.mtautumn.edgequest.window.managers;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.mtautumn.edgequest.data.DataManager;


public class LaunchScreenManager {
	public ArrayList<MenuButton> buttonIDArray = new ArrayList<MenuButton>();
	DataManager dataManager;
	public LaunchScreenManager(DataManager dataManager) {
		this.dataManager = dataManager;
		buttonIDArray.add(new MenuButton(1,-247,-36,197,73,"newGame", "New Game"));
		buttonIDArray.add(new MenuButton(2,50,-36,197,73,"loadGame", "Load Game"));
	}
	public void buttonPressed(int posX, int posY) {
		for (int i = 0; i < buttonIDArray.size(); i++) {
			MenuButton button = buttonIDArray.get(i);
			if (posX > button.getPosX(dataManager.settings.screenWidth) && posX < button.getPosX(dataManager.settings.screenWidth) + button.getWidth() && posY > button.getPosY(dataManager.settings.screenHeight) && posY < button.getPosY(dataManager.settings.screenHeight) + button.getHeight()) {
				runButtonAction(button.name);
			}
		}
	}
	private void runButtonAction(String name) {
		dataManager.system.buttonActionQueue.add(name);
	}
	public class MenuButton {
		private int posX = 0;
		private int posY = 0;
		private int width = 0;
		private int height = 0;
		public int id = -1;
		public Texture buttonImage;
		public String name = "";
		public String displayName = "";
		public MenuButton(int id, int posX, int posY, int width, int height, String name, String displayName) {
			this.posX = posX;
			this.posY = posY;
			this.width = width;
			this.height = height;
			this.name = name;
			this.id = id;
			this.displayName = displayName;
			try {
				this.buttonImage = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("textures/menuButton.png"));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		public int getPosX(int screenWidth) {
			return screenWidth / 2 + (int)(posX * dataManager.system.uiZoom);
		}
		public int getPosY(int screenHeight) {
			return screenHeight / 2 + (int)(posY * dataManager.system.uiZoom);
		}
		public int getX() {
			return (int) (posX * dataManager.system.uiZoom);
		}
		public int getY() {
			return (int) (posY * dataManager.system.uiZoom);
		}
		public int getWidth() {
			return (int)(width * dataManager.system.uiZoom);
		}
		public int getHeight() {
			return (int)(height * dataManager.system.uiZoom);
		}
	}

}

/* Basically creates all of the blocks and items for the game. It also creates
 * hash maps which can be used to look up a block/item given its id or name
 */
package com.mtautumn.edgequest;

import java.util.HashMap;
import java.util.Map;

import com.mtautumn.edgequest.data.DataManager;

public class DefineBlockItems {
	public static Map<Short, BlockItem> blockIDMap = new HashMap<Short, BlockItem>();
	public static Map<String, BlockItem> blockNameMap = new HashMap<String, BlockItem>();
	public static void setDefinitions(DataManager dataManager) {
		noneDefinition();
		noTextureDefinition();
		grassDefinition();
		dirtDefinition();
		stoneDefinition();
		sandDefinition();
		snowDefinition();
		waterDefinition();
		groundDefinition();
		iceDefinition();
		lanternDefinition();
		daggerDefinition();
		pistolDefinition();
		bulletDefinition();
		
		torchDefinition();
		lilyPadDefinition();
		treeDefinition();

		dungeonDefinition();
		dungeonUpDefinition();
		dataManager.system.blockIDMap = blockIDMap;
		dataManager.system.blockNameMap = blockNameMap;
	}
	private static void noneDefinition() {
		BlockItem none = new BlockItem(-1, true, true, "none", new int[]{0} , new int[]{0});
		addToMaps(none);
	}
	private static void noTextureDefinition() {
		BlockItem noTexture = new BlockItem(0, true, true, "noTexture", new int[]{0} , new int[]{0});
		addToMaps(noTexture);
	}
	private static void grassDefinition() {
		BlockItem grass = new BlockItem(1, true, false, "grass", new int[]{0} , new int[]{0});
		grass.replacedBy = "dirt";
		addToMaps(grass);
	}
	private static void dirtDefinition() {
		BlockItem dirt = new BlockItem(2, true, false, "dirt", new int[]{0} , new int[]{0});
		addToMaps(dirt);
	}
	private static void stoneDefinition() {
		BlockItem stone = new BlockItem(3, true, false, "stone", new int[]{0} , new int[]{0});
		addToMaps(stone);
	}
	private static void sandDefinition() {
		BlockItem sand = new BlockItem(4, true, false, "sand", new int[]{0} , new int[]{0});
		addToMaps(sand);
	}
	private static void snowDefinition() {
		BlockItem snow = new BlockItem(5, true, false, "snow", new int[]{0} , new int[]{0});
		snow.canHavePrints = true;
		snow.melts = true;
		snow.meltsInto = "grass";
		snow.replacedBy = "grass";
		addToMaps(snow);
	}
	private static void waterDefinition() {
		BlockItem water = new BlockItem(6, true, false, "water", new int[]{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1} , null);
		water.isLiquid = true;
		water.isPassable = true;
		water.hardness = -1;
		addToMaps(water);
	}
	private static void groundDefinition() {
		BlockItem ground = new BlockItem(7, true, false, "ground", new int[]{0} , null);
		ground.hardness = -1;
		addToMaps(ground);
	}
	private static void iceDefinition() {
		BlockItem ice = new BlockItem(8, true, true, "ice", new int[]{0} , new int[]{0});
		ice.melts = true;
		ice.meltsInto = "water";
		ice.replacedBy = "water";
		addToMaps(ice);
	}
	private static void lanternDefinition() {
		BlockItem lantern = new BlockItem(9, false, true, "lantern", null , new int[]{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1});
		lantern.maxFuel = 100;
		lantern.isStackable = false;
		addToMaps(lantern);
	}
	private static void daggerDefinition() {
		BlockItem dagger = new BlockItem(10, false, true, "dagger", null , new int[]{0});
		dagger.isStackable = false;
		dagger.isWeapon = true;
		dagger.maxDamage = 4;
		dagger.range = 0.8;
		dagger.weaponSpread = 1.2;
		dagger.maxHealth = 50;
		dagger.projectile = "dagger0";
		dagger.speed = 0.3;
		addToMaps(dagger);
	}
	private static void pistolDefinition() {
		BlockItem pistol = new BlockItem(11, false, true, "pistol", null , new int[]{0});
		pistol.isStackable = false;
		pistol.isWeapon = true;
		pistol.maxDamage = 8;
		pistol.range = 10;
		pistol.maxHealth = 50;
		pistol.projectile = "bullet";
		pistol.ammo = "bullet";
		pistol.speed = 2;
		addToMaps(pistol);
	}
	private static void bulletDefinition() {
		BlockItem bullet = new BlockItem(12, false, true, "bullet", null , new int[]{0});
		addToMaps(bullet);
	}
	private static void torchDefinition() {
		BlockItem torch = new BlockItem(100, true, true, "torch", new int[]{0} , new int[]{0});
		torch.isLightSource = true;
		torch.isHot = true;
		torch.isPassable = true;
		torch.isSolid = false;
		addToMaps(torch);
	}
	private static void lilyPadDefinition() {
		BlockItem lilyPad = new BlockItem(101, true, true, "lilyPad", new int[]{0} , new int[]{0});
		lilyPad.isPassable = true;
		lilyPad.isSolid = false;
		addToMaps(lilyPad);
	}
	private static void treeDefinition() {
		BlockItem tree = new BlockItem(102, true, false, "tree", new int[]{0} , null);
		tree.isSolid = false;
		addToMaps(tree);
	}
	private static void dungeonDefinition() {
		BlockItem dungeon = new BlockItem(200, true, false, "dungeon", new int[]{0} , null);
		dungeon.hardness = -1;
		dungeon.isPassable = true;
		dungeon.isSolid = false;
		addToMaps(dungeon);
	}
	private static void dungeonUpDefinition() {
		BlockItem dungeonUp = new BlockItem(201, true, false, "dungeonUp", new int[]{0} , null);
		dungeonUp.hardness = -1;
		dungeonUp.isPassable = true;
		dungeonUp.isSolid = false;
		addToMaps(dungeonUp);
	}

	private static void addToMaps(BlockItem blockItem) {
		blockIDMap.put(blockItem.getID(), blockItem);
		blockNameMap.put(blockItem.getName(), blockItem);
	}
}


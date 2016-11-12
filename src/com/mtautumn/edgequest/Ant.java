package com.mtautumn.edgequest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.mtautumn.edgequest.data.DataManager;

public class Ant extends Entity {
	private static final long serialVersionUID = 1L;
	long lastUpdate;
	private int lastX = 0;
	private int lastY = 0;

	public Ant(double posX, double posY, byte rotation, DataManager dm, int dungeonLevel, int[] dungeon) {
		super("ant",EntityType.passiveCreature, posX, posY, rotation, dm);
		this.dungeonLevel = dungeonLevel;
		this.dungeon = dungeon;
		super.stillAnimation = new int[]{0,0,0,0,1,1,1,1};
		super.walkAnimation = new int[]{0,0,0,1,1,1,2,2,2,3,3,3,4,4,4};
		lastUpdate = System.currentTimeMillis();
		super.moveSpeed = 0.05;
	}
	public Ant() {
		super();
		super.stillAnimation = new int[]{0,1};
		super.walkAnimation = new int[]{0,1,2,3,4};
		super.moveSpeed = 0.05;
	}
	public void update() {
		if (Math.random() > 0.99) {
			double rand = Math.random();
			if (rand < 0.33333333) {
				lastX = -1;
			} else if (rand < 0.66666667) {
				lastX = 0;
			} else {
				lastX = 1;
			}
		}
		if (Math.random() > 0.99) {
			double rand = Math.random();
			if (rand < 0.33333333) {
				lastY = -1;
			} else if (rand < 0.66666667) {
				lastY = 0;
			} else {
				lastY = 1;
			}
		}
		setX(getX() + lastX * moveSpeed);
		setY(getY() + lastY * moveSpeed);
		super.updateRotation(lastX, lastY);
		if (dungeonLevel == -1) {
			if (dm.world.ou.isStructBlock((int) getX(), (int) getY())) {
				if (dm.system.blockIDMap.get(dm.world.ou.getStructBlock((int) getX(), (int) getY())).hardness > -1) {
					dm.world.ou.removeStructBlock((int) getX(), (int) getY());
					dm.blockUpdateManager.updateBlock((int) getX(), (int) getY());
				}
			}
		} else {
			if (dm.savable.dungeonMap.get(dungeon[0]+","+dungeon[1]).isStructureBlock(dungeonLevel, (int) getX(), (int) getY())) {
				if (dm.system.blockIDMap.get(dm.savable.dungeonMap.get(dungeon[0]+","+dungeon[1]).getStructureBlock(dungeonLevel, (int) getX(), (int) getY())).hardness > -1) {
					dm.savable.dungeonMap.get(dungeon[0]+","+dungeon[1]).removeStructureBlock(dungeonLevel, (int) getX(), (int) getY());
					dm.blockUpdateManager.updateBlock((int) getX(), (int) getY());
				}
			}
		}
		super.update();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
	}
	public void initializeClass(DataManager dm) {
		super.initializeClass(dm);
	}
}
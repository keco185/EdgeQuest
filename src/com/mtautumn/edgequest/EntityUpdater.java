package com.mtautumn.edgequest;

import com.mtautumn.edgequest.Entity.EntityType;
import com.mtautumn.edgequest.data.DataManager;

public class EntityUpdater extends Thread{
	DataManager dm;
	public EntityUpdater(DataManager dm) {
		this.dm = dm;
	}
	public void run() {
		while(dm.system.running) {
			try {
				for (int i = 0; i < dm.savable.entities.size(); i++) {
					if (dm.savable.entities.get(i).getType() != EntityType.character && dm.savable.entities.get(i).dungeonLevel == dm.characterManager.characterEntity.dungeonLevel) {
						if (dm.savable.entities.get(i).distanceToPlayer() < 100) {
							dm.savable.entities.get(i).update();
							if (dm.savable.entities.get(i).health <= 0) {
								dm.savable.entities.remove(i);
								i--;
							}
						}
					}
				}
				Thread.sleep(dm.settings.tickLength);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

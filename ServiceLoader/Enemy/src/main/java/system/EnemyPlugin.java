package system;

import data.Entity;
import data.GameData;
import data.World;
import data.entityparts.MovingPart;
import data.entityparts.PositionPart;
import services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

	private Entity player;

	public EnemyPlugin() {
	}

	@Override
	public void start(GameData gameData, World world) {

		// Add entities to the world
		player = createPlayerShip(gameData);
		world.addEntity(player);
	}

	private Entity createPlayerShip(GameData gameData) {

		float deacceleration = 10;
		float acceleration = 200;
		float maxSpeed = 300;
		float rotationSpeed = 5;
		float x = (float) (Math.random() * gameData.getDisplayWidth() / 2);
		float y = 0;
		float radians = 3.1415f / 2;

		Entity enemyShip = new Enemy();
		enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
		enemyShip.add(new PositionPart(x, y, radians));

		return enemyShip;
	}

	@Override
	public void stop(GameData gameData, World world) {
		// Remove entities
		world.removeEntity(player);
	}

}
package dpete17.sdu.enemy;

import dpete17.sdu.common.data.Entity;
import dpete17.sdu.common.data.GameData;
import dpete17.sdu.common.data.World;
import dpete17.sdu.common.data.entityparts.MovingPart;
import dpete17.sdu.common.data.entityparts.PositionPart;
import dpete17.sdu.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IGamePluginService.class)
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
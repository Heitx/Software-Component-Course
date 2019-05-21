package dpete17.system;

import dpete17.data.Entity;
import dpete17.data.GameData;
import dpete17.data.World;
import dpete17.data.entityparts.MovingPart;
import dpete17.data.entityparts.PositionPart;
import dpete17.services.IGamePluginService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AsteroidPlugin implements IGamePluginService {

	private List<Entity> asteroids;

	public AsteroidPlugin() {
		asteroids = new ArrayList<>();
	}

	@Override
	public void start(GameData gameData, World world) {

		// Add entities to the world

		for (int i = 0; i < 1; i++) {
			Entity asteroid = createAsteroid(gameData);

			asteroids.add(asteroid);
			world.addEntity(asteroid);
		}
	}

	private Entity createAsteroid(GameData gameData) {
		float deacceleration = 10;
		float acceleration = 200;
		float maxSpeed = 200;
		float rotationSpeed = 10;
		float x = (float) (Math.random() * gameData.getDisplayWidth());
		float y = gameData.getDisplayHeight();
		float radians = (float) (Math.random() * Math.PI * 2);

		Entity asteroid = new Asteroid();
		MovingPart movingPart = new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed);
		movingPart.setUp(true);

		asteroid.add(movingPart);
		asteroid.add(new PositionPart(x, y, radians));

		return asteroid;
	}

	@Override
	public void stop(GameData gameData, World world) {
		// Remove entities
		for (Entity asteroid : asteroids) {
			world.removeEntity(asteroid);
		}
	}
}
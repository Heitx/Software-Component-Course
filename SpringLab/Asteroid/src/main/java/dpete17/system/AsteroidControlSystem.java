package dpete17.system;

import dpete17.data.Entity;
import dpete17.data.GameData;
import dpete17.data.World;
import dpete17.data.entityparts.MovingPart;
import dpete17.data.entityparts.PositionPart;
import dpete17.services.IEntityProcessingService;
import org.springframework.stereotype.Service;

@Service
public class AsteroidControlSystem implements IEntityProcessingService {
	@Override
	public void process(GameData gameData, World world) {
		for (Entity asteroid : world.getEntities(Asteroid.class)) {
			PositionPart positionPart = asteroid.getPart(PositionPart.class);
			MovingPart movingPart = asteroid.getPart(MovingPart.class);

			movingPart.process(gameData, asteroid);
			positionPart.process(gameData, asteroid);

			updateShape(asteroid);
		}
	}

	private void updateShape(Entity entity) {
		final int SIDES = 7;

		float shapex[] = new float[SIDES];
		float shapey[] = new float[SIDES];

		PositionPart positionPart = entity.getPart(PositionPart.class);
		float x = positionPart.getX();
		float y = positionPart.getY();
		float radians = positionPart.getRadians();

		for (int i = 0; i < shapex.length; i++) {
			shapex[i] = (float) (x + Math.cos(radians - i * 2 * Math.PI / SIDES) * 16);
			shapey[i] = (float) (y + Math.sin(radians - i * 2 * Math.PI / SIDES) * 16);
		}

		entity.setShapeX(shapex);
		entity.setShapeY(shapey);
	}
}
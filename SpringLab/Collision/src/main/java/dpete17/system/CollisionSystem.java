package dpete17.system;

import dpete17.data.Entity;
import dpete17.data.GameData;
import dpete17.data.World;
import dpete17.services.IPostEntityProcessingService;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CollisionSystem implements IPostEntityProcessingService {
	public CollisionSystem() {

	}

	@Override
	public void process(GameData gameData, World world) {
		Set<Entity> entities = new HashSet<>(world.getEntities());

		for(Entity entity : world.getEntities()) {
			Region entityRegion = getMinAndMaxCoords(entity);

			for (Entity other : entities) {
				Region nextRegion = getMinAndMaxCoords(other);

				if(entityRegion.collides(nextRegion)) {
					if(entity.getClass() != other.getClass()) {
						world.removeEntity(entity);
						world.removeEntity(other);
					}
				}
			}

			entities.remove(entity);
		}
	}

	private Region getMinAndMaxCoords(Entity entity) {
		float minX = Float.MAX_VALUE; float maxX = Float.MIN_VALUE;
		for(float x : entity.getShapeX()) {
			if(x < minX) minX = x;
			if(x > maxX) maxX = x;
		}

		float minY = Float.MAX_VALUE; float maxY = Float.MIN_VALUE;
		for(float y : entity.getShapeY()) {
			if(y < minY) minY = y;
			if(y > maxY) maxY = y;
		}

		return new Region(minX, maxX, minY, maxY);
	}
}

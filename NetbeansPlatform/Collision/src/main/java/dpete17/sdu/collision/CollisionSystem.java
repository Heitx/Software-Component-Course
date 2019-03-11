package dpete17.sdu.collision;

import dpete17.sdu.common.data.Entity;
import dpete17.sdu.common.data.GameData;
import dpete17.sdu.common.data.World;
import dpete17.sdu.common.services.IGamePluginService;
import dpete17.sdu.common.services.IPostEntityProcessingService;

import java.util.*;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IPostEntityProcessingService.class)
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

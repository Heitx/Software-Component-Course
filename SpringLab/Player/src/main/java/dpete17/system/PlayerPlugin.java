package dpete17.system;

import dpete17.data.Entity;
import dpete17.data.GameData;
import dpete17.data.World;
import dpete17.data.entityparts.MovingPart;
import dpete17.data.entityparts.PositionPart;
import org.springframework.stereotype.Service;
import dpete17.services.IGamePluginService;

@Service
public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
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
        float x = gameData.getDisplayWidth() >> 1;
        float y = gameData.getDisplayHeight() >> 1;
        float radians = 3.1415f / 2;
        
        Entity playerShip = new Player();
        MovingPart movingPart = new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed);
        movingPart.setUp(true);

        playerShip.add(movingPart);
        playerShip.add(new PositionPart(x, y, radians));
        
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}

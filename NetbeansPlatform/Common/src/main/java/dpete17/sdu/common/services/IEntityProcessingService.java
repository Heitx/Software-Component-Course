package dpete17.sdu.common.services;

import dpete17.sdu.common.data.GameData;
import dpete17.sdu.common.data.World;

public interface IEntityProcessingService {

    /**
     * Executed on every frame of the game.
     * @param gameData data about the game
     * @param world current world that is being operated on
     */
    void process(GameData gameData, World world);
}

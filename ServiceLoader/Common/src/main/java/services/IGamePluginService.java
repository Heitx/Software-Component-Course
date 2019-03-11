package services;

import data.GameData;
import data.World;

public interface IGamePluginService {
    /**
     * When the game starts, this function will be executed.
     * @param gameData data about the game
     * @param world current world that is being operated on
     */
    void start(GameData gameData, World world);

    /**
     * When the game ends, this function will be executed.
     * @param gameData data about the game
     * @param world current world that is being operated on
     */
    void stop(GameData gameData, World world);
}

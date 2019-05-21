package dpete17.services;

import dpete17.data.GameData;
import dpete17.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService  {
	/**
	 * Executed whenever the standardize processing service is finished.
	 * @param gameData data about the game
	 * @param world current world that is being operated on
	 */
	void process(GameData gameData, World world);
}

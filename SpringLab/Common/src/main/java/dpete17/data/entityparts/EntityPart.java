package dpete17.data.entityparts;

import dpete17.data.Entity;
import dpete17.data.GameData;

/**
 *
 * @author Alexander
 */
public interface EntityPart {
    void process(GameData gameData, Entity entity);
}

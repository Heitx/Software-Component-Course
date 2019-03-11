package dpete17.sdu.common.data.entityparts;

import dpete17.sdu.common.data.Entity;
import dpete17.sdu.common.data.GameData;

/**
 *
 * @author Alexander
 */
public interface EntityPart {
    void process(GameData gameData, Entity entity);
}

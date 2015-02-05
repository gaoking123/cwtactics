package net.wolfTec.wtEngine.gamelogic;

import net.wolfTec.wtEngine.Constants;
import net.wolfTec.wtEngine.model.Unit;

public interface TransportLogic extends BaseLogic {

	/**
	 * @return true if the unit with id tid is a transporter, else false.
	 */
	default boolean isTransportUnit(Unit unit) {
		return (unit.getType().maxloads > 0);
	}

	/**
	 * Has a transporter unit with id tid loaded units?
	 * 
	 * @return {boolean} true if yes, else false.
	 */
	default boolean hasLoads(Unit unit) {
		for (int i = 0, e = Constants.MAX_UNITS; i < e; i++) {
			if (unit == getGameRound().getUnit(i).getLoadedIn()) return true;
		}
		return false;
	}

}

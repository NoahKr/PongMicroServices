package minor.infosupport.arena.services;

import minor.infosupport.arena.entities.Arena;
import minor.infosupport.arena.entities.ArenaSide;
import minor.infosupport.arena.entities.Position;
import org.springframework.stereotype.Service;

@Service
public class ArenaService {

	private Arena arena;

	public ArenaService() {
		this.arena = new Arena();
	}

	public ArenaSide collision(Position position) {
		if (position.getX() == arena.getLeftBound()) {
			return ArenaSide.LEFT;
		} else if (position.getX() == arena.getRightBound()) {
			return ArenaSide.RIGHT;
		} else if (position.getY() == arena.getTopBound()) {
			return ArenaSide.TOP;
		} else if (position.getY() == arena.getBottomBound()) {
			return ArenaSide.BOTTOM;
		}

		return null;
	}

}

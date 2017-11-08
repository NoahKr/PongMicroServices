package minor.infosupport.player.services;

import minor.infosupport.player.entities.Player;
import minor.infosupport.player.entities.Position;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	private Player[] players;

	public PlayerService() {
		players = new Player[] {
				new Player()
						.setId(1)
						.setPosition(new Position()
								.setX(-5)
								.setY(4))
						.setSize(4),
				new Player()
						.setId(2)
						.setPosition(new Position()
								.setX(5)
								.setY(0))
						.setSize(4)
		};
	}

	public boolean collision(Position position) {
		for (Player player : players) {
			if (player.getPosition().getX() == position.getX() &&
					player.getPosition().getY() + player.getSize() > position.getY() &&
					player.getPosition().getY() - player.getSize() < position.getY()) {
				return true;
			}
		}

		return false;
	}

}

package minor.infosupport.player.services;

import minor.infosupport.player.entities.Player;
import minor.infosupport.player.entities.Position;
import minor.infosupport.player.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public boolean collision(Position position) {
		Iterable<Player> players = playerRepository.findAll();

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

package minor.infosupport.player;

import minor.infosupport.player.entities.Player;
import minor.infosupport.player.entities.Position;
import minor.infosupport.player.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayerApplication implements CommandLineRunner {

	@Autowired
	PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		playerRepository.save(new Player()
				.setId(1)
				.setPosition(new Position()
						.setX(-5)
						.setY(0))
				.setSize(4));
		playerRepository.save(new Player()
				.setId(2)
				.setPosition(new Position()
						.setX(5)
						.setY(0))
				.setSize(4));
	}
}

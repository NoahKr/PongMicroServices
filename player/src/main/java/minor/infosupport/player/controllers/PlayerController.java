package minor.infosupport.player.controllers;

import minor.infosupport.player.entities.Player;
import minor.infosupport.player.entities.Position;
import minor.infosupport.player.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

	private final PlayerRepository playerRepository;

	@Autowired
	public PlayerController(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@GetMapping
	@ResponseBody
	public Iterable<Player> getAll() {
		return playerRepository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Player get(@PathVariable long id) {
		return playerRepository.findOne(id);
	}

	@GetMapping("/{id}/position")
	@ResponseBody
	public ResponseEntity<Position> getPosition(@PathVariable long id) {
		Player player = playerRepository.findOne(id);

		if (player == null || player.getPosition() == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(player.getPosition());
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Player> post(@RequestBody Player player) {
		return ResponseEntity.ok(playerRepository.save(player));
	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Player> put(@PathVariable long id, @RequestBody Player player) {
		if (player.getId() == id) {
			return ResponseEntity.ok(playerRepository.save(player));
		}

		return ResponseEntity.notFound().build();
	}


}

package minor.infosupport.game.controllers;

import minor.infosupport.game.events.senders.GameRestartedSender;
import minor.infosupport.game.events.senders.GameStartedSender;
import minor.infosupport.game.events.senders.GameStoppedSender;
import minor.infosupport.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/start")
	public ResponseEntity<String> start() {
		this.gameService.startGame();
		return ResponseEntity.ok("started");
	}

	@PostMapping("/reset")
	public ResponseEntity<String> restart() {
		this.gameService.resetGame();
		return ResponseEntity.ok("resetted");
	}

	@PostMapping("/stop")
	public ResponseEntity<String> stop() {
		this.gameService.stopGame();
		return ResponseEntity.ok("stopped");
	}

	@PostMapping("/replay")
	public ResponseEntity<String> replay() {
		this.gameService.replayGame();
		return ResponseEntity.ok("replay");
	}

}

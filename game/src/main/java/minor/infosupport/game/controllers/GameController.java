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

	@PostMapping("/restart")
	public ResponseEntity<String> restart() {
		this.gameService.restartGame();
		return ResponseEntity.ok("restarted");
	}

	@PostMapping("/stop")
	public ResponseEntity<String> stop() {
		this.gameService.stopGame();
		return ResponseEntity.ok("stopped");
	}

}

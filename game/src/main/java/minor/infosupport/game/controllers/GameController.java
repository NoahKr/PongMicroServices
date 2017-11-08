package minor.infosupport.game.controllers;

import minor.infosupport.game.events.senders.GameRestartedSender;
import minor.infosupport.game.events.senders.GameStartedSender;
import minor.infosupport.game.events.senders.GameStoppedSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameStartedSender gameStartedSender;

	@Autowired
	private GameRestartedSender gameRestartedSender;

	@Autowired
	private GameStoppedSender gameStoppedSender;

	@PostMapping("/start")
	public ResponseEntity<String> start() {
		gameStartedSender.send();
		return ResponseEntity.ok("started");
	}

	@PostMapping("/restart")
	public ResponseEntity<String> restart() {
		gameRestartedSender.send();
		return ResponseEntity.ok("restarted");
	}

	@PostMapping("/stop")
	public ResponseEntity<String> stop() {
		gameStoppedSender.send();
		return ResponseEntity.ok("stopped");
	}

}

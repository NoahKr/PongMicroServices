package minor.infosupport.game.services;

import minor.infosupport.game.events.senders.GameRestartedSender;
import minor.infosupport.game.events.senders.GameStartedSender;
import minor.infosupport.game.events.senders.GameStoppedSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class GameService {

    @Autowired
    private GameStartedSender gameStartedSender;

    @Autowired
    private GameRestartedSender gameRestartedSender;

    @Autowired
    private GameStoppedSender gameStoppedSender;

    private HashMap<String, String> gameEvents;

    public GameService() {
        gameEvents = new HashMap<>();
    }

    public void startGame() {
        gameStartedSender.send();
    }

    public void restartGame() {
        gameRestartedSender.send();
    }

    public void stopGame() {
        gameStoppedSender.send();
    }

    public void addGameEvent(String eventKey, String message) {
        this.gameEvents
    }

}

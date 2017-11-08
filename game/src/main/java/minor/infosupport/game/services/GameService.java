package minor.infosupport.game.services;

import minor.infosupport.game.events.senders.GameRestartedSender;
import minor.infosupport.game.events.senders.GameStartedSender;
import minor.infosupport.game.events.senders.GameStoppedSender;
import minor.infosupport.game.events.senders.ReplayGameSender;
import minor.infosupport.game.models.GameEvent;
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

    @Autowired
    private ReplayGameSender replayGameSender;

    private ArrayList<GameEvent> gameEvents;

    public GameService() {
        gameEvents = new ArrayList<>();
    }

    public void startGame() {
        gameStartedSender.send();
    }

    public void stopGame() {
        gameStoppedSender.send();
    }

    public void resetGame() {
        this.gameEvents = new ArrayList<>();
    }

    public void replayGame() {
        try {
            ArrayList<GameEvent> replayEvents = new ArrayList<>(this.gameEvents);
            replayGameSender.send(replayEvents);
            this.gameEvents = new ArrayList<>();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addGameEvent(long timestamp, String eventKey, String eventMessage) {
        this.gameEvents.add(new GameEvent(timestamp, eventKey, eventMessage));
    }


}

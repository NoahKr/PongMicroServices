package minor.infosupport.game.events.senders;

import minor.infosupport.game.models.GameEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * This is a special sender that doesn't send it's own events but replays the events of the previously played game.
 */
@Component
public class ReplayGameSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate template;

    public void send(ArrayList<GameEvent> gameEvents) throws InterruptedException {
        logger.debug("Game replay started!");

        for (int i = 0; i < gameEvents.size(); i++) {
            long delayBetweenEvents = 0L;
            GameEvent currentEvent = gameEvents.get(i);

            if ((i + 1) < gameEvents.size()) {
                long currentTimestamp = currentEvent.getTimestamp();
                long nextTimestamp = gameEvents.get(i + 1).getTimestamp();

                delayBetweenEvents = nextTimestamp - currentTimestamp;
            }

            TimeUnit.MILLISECONDS.sleep(delayBetweenEvents);
            template.convertAndSend("pong", currentEvent.getEventKey(), currentEvent.getEventMessage());
        }
    }

}

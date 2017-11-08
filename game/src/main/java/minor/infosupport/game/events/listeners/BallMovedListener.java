package minor.infosupport.game.events.listeners;

import minor.infosupport.game.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class BallMovedListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GameService gameService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "pong",
                    type = ExchangeTypes.TOPIC,
                    durable = "true"),
            key = "ball.moved"))
    public void listen(@Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String eventKey, String eventMessage) {
        logger.debug(eventKey + ": " + eventMessage);

        long timestamp = System.currentTimeMillis();
        this.gameService.addGameEvent(timestamp, eventKey, eventMessage);
    }
}

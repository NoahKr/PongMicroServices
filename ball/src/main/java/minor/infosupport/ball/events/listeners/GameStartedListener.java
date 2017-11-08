package minor.infosupport.ball.events.listeners;

import minor.infosupport.ball.services.BallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameStartedListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BallService ballService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "pong",
                    type = ExchangeTypes.TOPIC,
                    durable = "true"),
            key = "game.started"))
    public void listen(String message) {
        ballService.startGame();
        logger.debug(message);
    }
}
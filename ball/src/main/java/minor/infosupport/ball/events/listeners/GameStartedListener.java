package minor.infosupport.ball.events.listeners;

import minor.infosupport.ball.events.events.GameStartedEvent;
import minor.infosupport.ball.services.BallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GameStartedListener implements ApplicationListener<GameStartedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BallService ballService;
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue,
//            exchange = @Exchange(
//                    value = "pong",
//                    type = ExchangeTypes.TOPIC,
//                    durable = "true"),
//            key = "game.started"))
//    public void listen(String message) {
//        logger.debug(message);
//        ballService.startGame();
//    }

    @Override
    public void onApplicationEvent(GameStartedEvent event) {
        System.out.println("Godverdomme wtf");
        System.out.println(event);
        logger.debug(event.getMessage());
//        ballService.startGame();
    }
}



package minor.infosupport.ball.events.senders;

import com.google.gson.Gson;
import minor.infosupport.ball.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BallMovedSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate template;

    public void send(Position position) {
        String message = new Gson().toJson(position);
        template.convertAndSend("pong", "ball.moved", message);
        logger.debug(message);
    }

}
package minor.infosupport.ball.events.senders;

import com.google.gson.Gson;
import minor.infosupport.ball.events.receivers.BallDeflectedReceiver;
import minor.infosupport.ball.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BallMovedSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate template;

    @Autowired
	private TopicExchange exchange;

    public void send(Position position) {
        // Serialization
        Gson gson = new Gson();
        String json = gson.toJson(position);

        template.convertAndSend(exchange.getName(), "ball.moved", json);
        logger.debug(json);
    }

}
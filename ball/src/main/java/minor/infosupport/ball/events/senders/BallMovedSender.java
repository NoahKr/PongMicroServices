package minor.infosupport.ball.events.senders;

import com.google.gson.Gson;
import minor.infosupport.ball.events.receivers.BallDeflectedReceiver;
import minor.infosupport.ball.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BallMovedSender {

    private final Logger logger = LoggerFactory.getLogger(BallDeflectedReceiver.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("ballMoved")
    private Queue queue;

    int dots = 0;
    int count = 0;

    public void send(Position position) {
        // Serialization
        Gson gson = new Gson();
        String json = gson.toJson(position);

        template.convertAndSend(queue.getName(), json);
        logger.debug("Sent " + queue.getName() + ":" + json);
    }

}
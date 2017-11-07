package minor.infosupport.ball.events.senders;

import com.google.gson.Gson;
import minor.infosupport.ball.models.Position;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BallMovedSender {

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
        System.out.println("Sent " + queue.getName() + ":" + json);
    }

}
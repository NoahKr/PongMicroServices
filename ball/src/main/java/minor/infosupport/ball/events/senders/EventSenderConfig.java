package minor.infosupport.ball.events.senders;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventSenderConfig {

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("pong");
    }

    @Bean
    public BallMovedSender ballMovedSender() {
        return new BallMovedSender();
    }

}
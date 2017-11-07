package minor.infosupport.ball.events.senders;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventSenderConfig {

    @Bean
    public FanoutExchange ballMovedFanout() {
        return new FanoutExchange("ball.moved");
    }

    @Bean
    public BallMovedSender ballMovedSender() {
        return new BallMovedSender();
    }

}
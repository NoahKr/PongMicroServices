package minor.infosupport.ball.events.senders;



import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventSenderConfig {

    @Bean
    public Queue ballMoved() {
        return new Queue("ball.moved");
    }

    @Bean
    public BallMovedSender ballMovedSender() {
        return new BallMovedSender();
    }
}
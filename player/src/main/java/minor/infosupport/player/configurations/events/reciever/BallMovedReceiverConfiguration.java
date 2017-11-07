package minor.infosupport.player.configurations.events;

import minor.infosupport.player.events.receivers.BallMovedReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallMovedReceiverConfiguration {

	@Bean
	public Queue ballMoved() {
		return new Queue("ball.moved");
	}

	@Bean
	public BallMovedReceiver receiver() {
		return new BallMovedReceiver();
	}

}
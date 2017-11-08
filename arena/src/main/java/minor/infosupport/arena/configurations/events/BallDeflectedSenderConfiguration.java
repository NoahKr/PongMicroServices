package minor.infosupport.arena.configurations.events;

import minor.infosupport.arena.events.senders.BallDeflectedSender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallDeflectedSenderConfiguration {

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("pong");
	}

	@Bean
	public BallDeflectedSender ballDeflectedSender() {
		return new BallDeflectedSender();
	}

}

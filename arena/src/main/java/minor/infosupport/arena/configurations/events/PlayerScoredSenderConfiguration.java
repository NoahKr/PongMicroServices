package minor.infosupport.arena.configurations.events;

import minor.infosupport.arena.events.senders.BallDeflectedSender;
import minor.infosupport.arena.events.senders.PlayerScoredSender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerScoredSenderConfiguration {

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("pong");
	}

	@Bean
	public PlayerScoredSender playerScoredSender() {
		return new PlayerScoredSender();
	}

}

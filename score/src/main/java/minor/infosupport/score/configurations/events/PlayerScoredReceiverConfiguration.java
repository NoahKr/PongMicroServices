package minor.infosupport.score.configurations.events;

import minor.infosupport.score.events.receivers.PlayerScoredReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerScoredReceiverConfiguration {

	@Bean
	public Queue playerScored() {
		return new Queue("player.scored");
	}

	@Bean
	public PlayerScoredReceiver receiver() {
		return new PlayerScoredReceiver();
	}

}
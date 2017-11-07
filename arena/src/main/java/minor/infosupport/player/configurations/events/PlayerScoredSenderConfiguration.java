package minor.infosupport.player.configurations.events;

import minor.infosupport.player.events.senders.BallDeflectedSender;
import minor.infosupport.player.events.senders.PlayerScoredSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerScoredSenderConfiguration {

	@Bean
	public Queue playerScored() {
		return new Queue("player.scored");
	}

	@Bean
	public PlayerScoredSender playerScoredSender() {
		return new PlayerScoredSender();
	}

}

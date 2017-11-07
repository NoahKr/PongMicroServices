package minor.infosupport.player.configurations.events.sender;

import minor.infosupport.player.events.senders.PlayerMovedSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerMovedSenderConfiguration {

	@Bean
	public Queue playerMoved() {
		return new Queue("player.moved");
	}

	@Bean
	public PlayerMovedSender playerMovedSender() {
		return new PlayerMovedSender();
	}

}
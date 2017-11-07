package minor.infosupport.player.configurations.events;

import minor.infosupport.player.events.senders.BallDeflectedSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallDeflectedSenderConfiguration {

	@Bean
	public Queue ballDeflected() {
		return new Queue("ball.deflected");
	}

	@Bean
	public BallDeflectedSender ballDeflectedSender() {
		return new BallDeflectedSender();
	}

}

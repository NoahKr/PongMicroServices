package minor.infosupport.ball.events.receivers;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventReceiverConfig {

	@Bean
	public Queue ballDeflected() {
		return new Queue("ball.deflected");
	}

	@Bean
	public BallDeflectedReceiver ballDeflectedReceiver() {
		return new BallDeflectedReceiver();
	}
}

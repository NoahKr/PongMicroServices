package minor.infosupport.ball.events.receivers;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventReceiverConfig {

	@Bean
	public BallDeflectedReceiver ballDeflectedReceiver() {
		return new BallDeflectedReceiver();
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("pong");
	}

	@Bean
	public Queue ballDeflectedQueue() {
		return new AnonymousQueue();
	}

	@Bean public Binding ballDeflectedBinding(TopicExchange topic,
											  Queue ballDeflected) {
		return BindingBuilder.bind(ballDeflected)
				.to(topic).with("#.deflected");
	}

}

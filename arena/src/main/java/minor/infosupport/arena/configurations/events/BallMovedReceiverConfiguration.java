package minor.infosupport.arena.configurations.events;

import minor.infosupport.arena.events.receivers.BallMovedReceiver;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallMovedReceiverConfiguration {

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("pong");
	}

	@Bean
	public Queue ballMovedQueue() {
		return new AnonymousQueue();
	}

	@Bean public Binding ballMovedBinding(TopicExchange topic,
								   Queue ballMovedQueue) {
		return BindingBuilder.bind(ballMovedQueue)
				.to(topic).with("ball.moved");
	}

	@Bean
	public BallMovedReceiver receiver() {
		return new BallMovedReceiver();
	}

}
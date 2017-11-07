package minor.infosupport.arena.configurations.events;

import minor.infosupport.arena.events.receivers.BallMovedReceiver;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallMovedReceiverConfiguration {

	@Bean
	public FanoutExchange ballMovedFanout() {
		return new FanoutExchange("ball.moved");
	}

	@Bean
	public Queue ballMovedQueue() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding ballMovedBinding(FanoutExchange ballMovedFanout, Queue ballMovedQueue) {
		return BindingBuilder.bind(ballMovedQueue).to(ballMovedFanout);
	}

	@Bean
	public BallMovedReceiver receiver() {
		return new BallMovedReceiver();
	}

}
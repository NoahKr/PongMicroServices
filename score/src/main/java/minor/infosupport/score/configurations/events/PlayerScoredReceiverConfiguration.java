package minor.infosupport.score.configurations.events;

import minor.infosupport.score.events.receivers.PlayerScoredReceiver;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerScoredReceiverConfiguration {

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("pong");
	}

	@Bean
	public Queue playerScoredQueue() {
		return new AnonymousQueue();
	}

	@Bean public Binding playerScoredBinding(TopicExchange topic,
										  Queue playerScoredQueue) {
		return BindingBuilder.bind(playerScoredQueue)
				.to(topic).with("player.scored");
	}

	@Bean
	public PlayerScoredReceiver receiver() {
		return new PlayerScoredReceiver();
	}


}
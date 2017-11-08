package minor.infosupport.player.events.senders;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerMovedSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange exchange;

	public void send() {
		template.convertAndSend(exchange.getName(), "player.moved", "TEST");
	}

}

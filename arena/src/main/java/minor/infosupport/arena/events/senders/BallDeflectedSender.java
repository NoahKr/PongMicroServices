package minor.infosupport.arena.events.senders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BallDeflectedSender {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange exchange;

	public void send(String message) {
		template.convertAndSend(exchange.getName(), "ball.deflected", message);
		logger.debug(message);
	}

}

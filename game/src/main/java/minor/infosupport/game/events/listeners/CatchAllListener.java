package minor.infosupport.game.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class CatchAllListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(
					value = "pong",
					type = ExchangeTypes.TOPIC,
					durable = "true"),
			key = "#"))
	public void listen(@Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key, String message) {
		logger.debug("Key: " + key);
		logger.debug("Message" + message);
	}
}

package minor.infosupport.game.events.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CatchAllListener {

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(
					value = "pong",
					type = ExchangeTypes.TOPIC,
					durable = "true"),
			key = "#"))
	public void listen() {
	}

}

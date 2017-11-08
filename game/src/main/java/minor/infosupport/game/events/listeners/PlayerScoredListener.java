package minor.infosupport.game.events.listeners;

import minor.infosupport.game.events.senders.GameStoppedSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerScoredListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final GameStoppedSender gameStoppedSender;

	@Autowired
	public PlayerScoredListener(GameStoppedSender gameStoppedSender) {
		this.gameStoppedSender = gameStoppedSender;
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(
					value = "pong",
					type = ExchangeTypes.TOPIC,
					durable = "true"),
			key = "#"))
	public void listen() {
		gameStoppedSender.send();
	}

}

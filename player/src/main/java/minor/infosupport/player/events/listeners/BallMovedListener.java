package minor.infosupport.player.events.listeners;

import com.google.gson.Gson;
import minor.infosupport.player.entities.Position;
import minor.infosupport.player.events.senders.BallDeflectedSender;
import minor.infosupport.player.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BallMovedListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PlayerService playerService;

	@Autowired
	private BallDeflectedSender ballDeflectedSender;

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(
					value = "pong",
					type = ExchangeTypes.TOPIC,
					durable = "true"),
			key = "ball.moved"))
	public void listen(String message) {
		logger.debug(message);

		Position position = new Gson().fromJson(message, Position.class);
		if (playerService.collision(position)) {
			ballDeflectedSender.send();
		}
	}

}

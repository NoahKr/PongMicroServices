package minor.infosupport.arena.events.listeners;

import com.google.gson.Gson;
import minor.infosupport.arena.entities.ArenaSide;
import minor.infosupport.arena.entities.Position;
import minor.infosupport.arena.events.senders.BallDeflectedSender;
import minor.infosupport.arena.events.senders.PlayerScoredSender;
import minor.infosupport.arena.services.ArenaService;
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
	private ArenaService arenaService;

	@Autowired
	private BallDeflectedSender ballDeflectedSender;

	@Autowired
	private PlayerScoredSender playerScoredSender;

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
		if (arenaService.collision(position) == ArenaSide.LEFT) {
			playerScoredSender.send("left");
		} else if (arenaService.collision(position) == ArenaSide.RIGHT) {
			playerScoredSender.send("right");
		} else if (arenaService.collision(position) == ArenaSide.TOP || arenaService.collision(position) == ArenaSide.BOTTOM) {
			ballDeflectedSender.send("y");
		}
	}

}

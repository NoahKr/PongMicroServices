package minor.infosupport.arena.events.receivers;

import com.google.gson.Gson;
import minor.infosupport.arena.entities.ArenaSide;
import minor.infosupport.arena.entities.Position;
import minor.infosupport.arena.events.senders.BallDeflectedSender;
import minor.infosupport.arena.events.senders.PlayerScoredSender;
import minor.infosupport.arena.services.ArenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "#{ballMovedQueue.name}")
public class BallMovedReceiver {

	private final Logger logger = LoggerFactory.getLogger(BallMovedReceiver.class);

	@Autowired
	private ArenaService arenaService;

	@Autowired
	private BallDeflectedSender ballDeflectedSender;

	@Autowired
	private PlayerScoredSender playerScoredSender;

	@RabbitHandler
	public void receive(String message) {
		logger.debug("Received ball.moved:" + message);

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

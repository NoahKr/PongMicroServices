package minor.infosupport.player.events.receivers;

import com.google.gson.Gson;
import minor.infosupport.player.entities.Position;
import minor.infosupport.player.events.senders.BallDeflectedSender;
import minor.infosupport.player.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "#{ballMovedQueue.name}")
public class BallMovedReceiver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PlayerService playerService;

	@Autowired
	private BallDeflectedSender ballDeflectedSender;

	@RabbitHandler
	public void receive(String message) {
		Position position = new Gson().fromJson(message, Position.class);

		logger.debug(message);

		if (playerService.collision(position)) {
			ballDeflectedSender.send();
		}
	}

}

package minor.infosupport.player.events.senders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerScoredSender {

	private final Logger logger = LoggerFactory.getLogger(PlayerScoredSender.class);

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue playerScored;

	public void send(String message) {
		template.convertAndSend(playerScored.getName(), message);
		logger.debug("Sent " + playerScored.getName() + ":" + message);
	}

}

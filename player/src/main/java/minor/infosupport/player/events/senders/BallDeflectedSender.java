package minor.infosupport.player.events.senders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class BallDeflectedSender {

	private final Logger logger = LoggerFactory.getLogger(BallDeflectedSender.class);

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue ballDeflected;

	public void send() {
		template.convertAndSend(ballDeflected.getName(), "true");
		logger.debug("Deflected");
	}

}

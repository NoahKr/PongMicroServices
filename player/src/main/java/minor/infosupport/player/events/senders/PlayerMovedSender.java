package minor.infosupport.player.events.senders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMovedSender {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RabbitTemplate template;

	public void send() {
		String message = "";
		template.convertAndSend("pong", "player.moved", message);
		logger.debug(message);
	}

}

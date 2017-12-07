package minor.infosupport.game.events.senders;

import minor.infosupport.game.events.events.GameStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameStartedSender {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RabbitTemplate template;

	private ApplicationContext context;

	@Autowired
	public GameStartedSender(ApplicationContext context) {
		this.context = context;
	}

	public void send() {
		String message = "started";

		final String myUniqueId = context.getId();

		final GameStartedEvent event =
				new GameStartedEvent(this, myUniqueId, message);

		context.publishEvent(event);
		logger.debug(message);
	}

}

package minor.infosupport.score.events.receivers;

import com.google.gson.Gson;
import minor.infosupport.score.entities.Score;
import minor.infosupport.score.repositories.ScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "player.scored")
public class PlayerScoredReceiver {

	private final Logger logger = LoggerFactory.getLogger(PlayerScoredReceiver.class);

	@Autowired
	private ScoreRepository scoreRepository;

	@RabbitHandler
	public void receive(String message) {
		long id;
		if ("left".equals(message)) {
			id = 1;
		}
		else {
			id = 2;
		}

		Score score = scoreRepository.findOne(id);

		if (score == null) {
			score = new Score().setId(1).setPoints(0);
		}

		scoreRepository.save(score.setPoints(score.getPoints() + 1));

		logger.debug("Score increased for player #" + id);
	}

}

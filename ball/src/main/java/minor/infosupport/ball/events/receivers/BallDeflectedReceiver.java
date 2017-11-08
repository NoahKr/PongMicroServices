package minor.infosupport.ball.events.receivers;

import minor.infosupport.ball.services.BallService;
import minor.infosupport.ball.controllers.BallController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "ball.deflected")
public class BallDeflectedReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BallController ballController;

    @Autowired
    BallService ballService;

    //This method should be called when a message arrives on the queue
    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        logger.debug(message);

        ballService.changeBallDirection(message);
    }
}
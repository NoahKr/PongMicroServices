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

    private final Logger logger = LoggerFactory.getLogger(BallDeflectedReceiver.class);

    @Autowired
    BallController ballController;

    @Autowired
    BallService ballService;

    //This method should be called when a message arrives on the queue
    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        logger.debug("Received BallDeflectedEvent: " + message);

        ballService.changeBallDirection(message);
    }

    private void doWork(String in) throws InterruptedException {

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i); // Work hard for every character in the payload
            Thread.sleep(1000); // Sleep a second for every character send representing the hardwork
        }
    }
}
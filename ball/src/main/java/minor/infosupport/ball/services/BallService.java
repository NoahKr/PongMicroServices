package minor.infosupport.ball.services;

import minor.infosupport.ball.events.senders.BallMovedSender;
import minor.infosupport.ball.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BallService {

    private Ball ball;

    @Autowired
    private BallMovedSender ballMovedSender;

    BallService() {
        this.ball = new Ball();
    }

    public void changeBallDirection() {
        ball.setDirectionX(ball.getDirectionX() * -1);
        ball.setDirectionY(ball.getDirectionY() * -1);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    private void moveBall() {
        int xIncrease = ball.getDirectionX() * ball.getSpeed();
        int yIncrease = ball.getDirectionY() * ball.getSpeed();

        ball.getPosition().setX(ball.getPosition().getX() + xIncrease);
//        ball.getPosition().setY(ball.getPosition().getY() + yIncrease);

        this.ballMovedSender.send(ball.getPosition());
    }

}

package minor.infosupport.ball.services;

import minor.infosupport.ball.events.senders.BallMovedSender;
import minor.infosupport.ball.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Service
public class BallService {

    private Ball ball;
    private ScheduledFuture moveBallTask;

    @Autowired
    private BallMovedSender ballMovedSender;

    BallService() {
        this.ball = new Ball();
    }

    public void startGame() {
        TaskScheduler taskScheduler = new DefaultManagedTaskScheduler();
        Runnable task = this::moveBall;

        this.moveBallTask = taskScheduler.scheduleAtFixedRate(task, 1000);
    }

    public void stopGame() {
        this.moveBallTask.cancel(true);
        this.resetBall();
    }

    private void resetBall() {
        this.ball = new Ball();
    }

    public void changeBallDirection(String axis) {
        if (axis.equals("x")) {
            ball.setDirectionX(ball.getDirectionX() * -1);
        } else if (axis.equals("y")) {
            ball.setDirectionY(ball.getDirectionY() * -1);
        }
    }

    private void moveBall() {
        int xIncrease = ball.getDirectionX() * ball.getSpeed();
        int yIncrease = ball.getDirectionY() * ball.getSpeed();

        ball.getPosition().setX(ball.getPosition().getX() + xIncrease);
        ball.getPosition().setY(ball.getPosition().getY() + yIncrease);

        this.ballMovedSender.send(ball.getPosition());
    }

}

package minor.infosupport.ball.controllers;

import minor.infosupport.ball.models.Ball;
import org.springframework.stereotype.Controller;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class BallController {

    private Ball ball;

    public BallController() {
       this.ball = new Ball();

        TimerTask ballTask = new TimerTask() {
            @Override
            public void run() {
                moveBall();
                System.out.println("Ball moved to (" + ball.getPositionX() + "," + ball.getPositionY() + ")");
            }
        };

        Timer timer = new Timer();
        timer.schedule(ballTask, 0, 1000);
    }

    private void moveBall() {
        int xIncrease = ball.getDirectionX() * ball.getSpeed();
        int yIncrease = ball.getDirectionY() * ball.getSpeed();

//        // Check collision With screen edges
//        if (xCollision(xIncrease)) {
//            ((GameView)view).startGame();
//        } else if (yCollision(yIncrease)) {
//            this.directionY *= -1;
//        }

        // Check collision with deflectors
//        if (xDeflectorCollision(xIncrease, yIncrease)) {
//            this.directionX *= -1;
//        }


        ball.setPositionX(ball.getPositionX() + xIncrease);
        ball.setPositionY(ball.getPositionY() + yIncrease);
    }
}

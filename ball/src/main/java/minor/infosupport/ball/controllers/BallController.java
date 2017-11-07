package minor.infosupport.ball.controllers;

import minor.infosupport.ball.events.senders.BallMovedSender;
import minor.infosupport.ball.events.senders.EventSenderConfig;
import minor.infosupport.ball.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class BallController {



    public BallController() {
    }


}

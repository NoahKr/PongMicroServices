package minor.infosupport.ball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

@SpringBootApplication
@RemoteApplicationEventScan
public class BallApplication {

	public static void main(String[] args) {
		SpringApplication.run(BallApplication.class, args);
	}

}

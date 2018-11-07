package myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// Scheduler commente pour des tests
//@EnableScheduling
public class myApplication  {

	public static void main(String[] args) throws Exception  {
		SpringApplication.run(myApplication.class, args);
	}

}

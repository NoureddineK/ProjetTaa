package myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class myApplication  {

	public static void main(String[] args) throws Exception  {
		SpringApplication.run(myApplication.class, args);
	}

}

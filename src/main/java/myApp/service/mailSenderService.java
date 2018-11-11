package myApp.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import myApp.mailSender.SmtpMailSender;

@RestController
@RequestMapping("/sendMail")
@Api(value="mailSenderService", produces =MediaType.APPLICATION_JSON_VALUE)
public class mailSenderService {
	@Autowired
	private SmtpMailSender smtpMailSender;
	private String Object = "Weather App";

	@RequestMapping("/{mail}/{body}")
	public void sendMail(@PathVariable String mail, @PathVariable String body) throws MessagingException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(body);
		smtpMailSender.send(mail, this.Object, stringBuilder);
	}
}

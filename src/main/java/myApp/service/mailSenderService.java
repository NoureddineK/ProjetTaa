package myApp.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.mailSender.SmtpMailSender;

@RestController
@RequestMapping("/sendMail")
public class mailSenderService {
	@Autowired
	private SmtpMailSender smtpMailSender;
	private String Object = "Weather App";

	@RequestMapping("/{mail}/{body}")
	public void sendMail(@PathVariable String mail, @PathVariable String body) throws MessagingException {
		smtpMailSender.send(mail, this.Object, body);
	}
}

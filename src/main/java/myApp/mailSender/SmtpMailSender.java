package myApp.mailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(String to, String subject, StringBuilder body) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body.toString(), true);
		javaMailSender.send(message);
	}
}
package co.edu.uniquindio.cinecoonly.cinecoonly.servicios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Mail;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.MailNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Mail sendSimpleMail(Mail mail) throws MailNoEncontradoException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        message.setTo(mail.getTo());
        message.setSentDate(mail.getSendDate());
        try {
            javaMailSender.send(message);

        } catch (MailException e) {
            e.printStackTrace();
            throw new MailNoEncontradoException("Error al enviar el correo electronico");
        }
        return mail;
    }
}

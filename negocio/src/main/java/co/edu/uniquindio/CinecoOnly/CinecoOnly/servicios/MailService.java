package co.edu.uniquindio.cinecoonly.cinecoonly.servicios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Mail;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.MailNoEncontradoException;

public interface MailService {

    Mail sendSimpleMail(Mail mail) throws MailNoEncontradoException;
}

package co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Mail;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.MailNoEncontradoException;

public interface MailService {

    Mail sendSimpleMail(Mail mail) throws MailNoEncontradoException;
}

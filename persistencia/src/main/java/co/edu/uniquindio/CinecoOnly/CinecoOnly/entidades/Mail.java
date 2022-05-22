package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    @Getter @Setter
    private String username;
    @Getter @Setter
    private String to;
    @Getter @Setter
    private String subject;
    @Getter @Setter
    private String text;
    @Getter @Setter
    private File file;
    @Getter @Setter
    private Date sendDate;
}

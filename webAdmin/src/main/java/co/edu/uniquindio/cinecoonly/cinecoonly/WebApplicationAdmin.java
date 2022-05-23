package co.edu.uniquindio.cinecoonly.cinecoonly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebApplicationAdmin extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return  builder.sources(WebApplicationAdmin.class);
    }
    public static void main(String[] args){
        SpringApplication.run(WebApplicationAdmin.class, args);
    }
}

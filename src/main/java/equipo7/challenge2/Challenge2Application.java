package equipo7.challenge2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Challenge2Application {

    public static void main(String[] args) {
        SpringApplication.run(Challenge2Application.class, args);}
    @GetMapping("/")
    public String apiRoot(){
        return "Hello World";
    }
}



package equipo7.challenge2;

import equipo7.challenge2.entities.Erole;
import equipo7.challenge2.entities.Role;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
@RestController
public class Challenge2Application {

    public static void main(String[] args) {
        SpringApplication.run(Challenge2Application.class, args);
    }

   /*@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Bean
    CommandLineRunner init() {
        return args -> {

            Usuario usuario = Usuario.builder()
                    .correo("Mariosantiago@mail.com")
                    .nombreUsuario("mario1")
                    .contrasena(passwordEncoder.encode("1234"))
                    .roles(Set.of(Role.builder()
                            .role(Erole.valueOf(Erole.ADMIN.name()))
                            .build()))
                    .build();

            Usuario usuario2 = Usuario.builder()
                    .correo("Pablo@mail.com")
                    .nombreUsuario("pablo2")
                    .contrasena(passwordEncoder.encode("1234"))
                    .roles(Set.of(Role.builder()
                            .role(Erole.valueOf(Erole.COMPRADOR.name()))
                            .build()))
                    .build();

            Usuario usuario3 = Usuario.builder()
                    .correo("Omar@mail.com")
                    .nombreUsuario("omar3")
                    .contrasena(passwordEncoder.encode("1234"))
                    .roles(Set.of(Role.builder()
                            .role(Erole.valueOf(Erole.USER.name()))
                            .build()))
                    .build();
            Usuario usuario4 = Usuario.builder()
                    .correo("Paco@mail.com")
                    .nombreUsuario("paco4")
                    .contrasena(passwordEncoder.encode("1234"))
                    .roles(Set.of(Role.builder()
                            .role(Erole.valueOf(Erole.VENDEDOR.name()))
                            .build()))
                    .build();

          repositoryUsuario.save(usuario);
            repositoryUsuario.save(usuario2);
            repositoryUsuario.save(usuario3);
            repositoryUsuario.save(usuario4);

        };*/
    }





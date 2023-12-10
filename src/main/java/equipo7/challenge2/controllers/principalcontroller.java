package equipo7.challenge2.controllers;


import equipo7.challenge2.entities.Erole;
import equipo7.challenge2.entities.Role;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import equipo7.challenge2.request.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class principalcontroller {
    Logger logger = LoggerFactory.getLogger(principalcontroller.class);

    @Autowired

    private PasswordEncoder passwordEncoder;

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserDTO createUserDTO){
        logger.info("Creando usuario: {}", createUserDTO.getNombreUsuario());

        Set<Role> roles = createUserDTO.getRoles().stream()
                .map(role -> Role.builder()
                        .role(Erole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .nombreUsuario(createUserDTO.getNombreUsuario())
                .correo(createUserDTO.getCorreo())
                .contrasena(passwordEncoder.encode(createUserDTO.getContrasena()))
                .roles(roles)
                .build();
        repositoryUsuario.save(usuario);

        logger.info("Usuario creado: {}", usuario.getNombreUsuario());

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deleteUsuario")
    public String deleteUser(@RequestParam String id_usuario){
        logger.info("Borrando usuario con id: {}", id_usuario);

        repositoryUsuario.deleteById(Long.parseLong(id_usuario));

        logger.info("Usuario borrado con id: {}", id_usuario);

        return "Se ha borrado el usuario con id ".concat(id_usuario);
    }
}

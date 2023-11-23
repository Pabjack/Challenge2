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

import java.util.Set;
import java.util.stream.Collectors;

@RestController

public class principalcontroller {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/hello")
    public String hello (){
        return "hello word";
    }
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @PostMapping("/crearUsuario")
    public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserDTO createUserDTO){
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

        return ResponseEntity.ok(usuario);

    }
    @DeleteMapping("/deleteUsuario")
    public String deleteUser(@RequestParam String id_usuario){
        repositoryUsuario.deleteById(Long.parseLong(id_usuario));
        return "Se ha borrado el usuario con id ".concat(id_usuario);

    }
}

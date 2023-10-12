package equipo7.challenge2.controllers;
import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private ServicioUsuario servicioUsuario;
    @GetMapping
    public GenericResponse getAllUsuarios(){
        return new GenericResponse(201, "encontrado", servicioUsuario.allUsuarios().toString());
    }

}

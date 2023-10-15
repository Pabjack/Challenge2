package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private ServicioUsuario servicio;
    @GetMapping
    public GenericResponse getAllUsuarios(){
        return new GenericResponse(201, "encontrado", servicio.allUsuarios().toString());
    }

}

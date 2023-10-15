package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioCategoria;
import equipo7.challenge2.services.ServicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sesiones")
public class ControllerSesion {

    @Autowired
    private ServicioSesion servicio;
    @GetMapping
    public GenericResponse getAllSesion(){
        return new GenericResponse(201, "encontrado", servicio.allSesion().toString());
    }

}

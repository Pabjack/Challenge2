package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioResena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resenas")
public class ControllerResena {

    @Autowired
    private ServicioResena servicio;
    @GetMapping
    public GenericResponse getAllResena(){
        return new GenericResponse(201, "encontrado", servicio.allResenas().toString());
    }

}

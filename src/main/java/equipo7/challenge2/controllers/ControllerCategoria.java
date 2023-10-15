package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    @Autowired
    private ServicioCategoria servicio;
    @GetMapping
    public GenericResponse getAllCategoria(){
        return new GenericResponse(201, "encontrado", servicio.allCategorias().toString());
    }

}

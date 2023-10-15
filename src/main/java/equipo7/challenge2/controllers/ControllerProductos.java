package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ControllerProductos {

    @Autowired
    private ServicioProducto servicio;
    @GetMapping
    public GenericResponse getAllProductos(){
        return new GenericResponse(201, "encontrado", servicio.allProductos().toString());
    }

}

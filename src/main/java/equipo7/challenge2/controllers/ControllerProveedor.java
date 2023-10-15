package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioCategoria;
import equipo7.challenge2.services.ServicioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proveedores")
public class ControllerProveedor {

    @Autowired
    private ServicioProveedor servicio;
    @GetMapping
    public GenericResponse getAllProveedores(){
        return new GenericResponse(201, "encontrado", servicio.allProveedores().toString());
    }

}

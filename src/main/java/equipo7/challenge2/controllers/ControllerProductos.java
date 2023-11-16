package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.services.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/producto")
public class ControllerProductos {

    @Autowired
    private ServicioProducto servicio;
    @GetMapping("/all")
    public GenericResponse getAllProductos(){
        Iterable<Producto> productos = servicio.allProductos();
        String productosStr = StreamSupport.stream(productos.spliterator(), false)
                .map(Producto::toString)
                .collect(Collectors.joining(", "));
        return new GenericResponse(201, "encontrado", productosStr);
    }
}


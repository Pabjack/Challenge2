package equipo7.challenge2.controllers;

import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.services.ServicioCategoria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias" )

@RequiredArgsConstructor
public class ControllerCategoria {

    @Autowired
    private ServicioCategoria servicio;
    @GetMapping("/all")
    public GenericResponse getAllCategoria(){
        return new GenericResponse(201, "encontrado", servicio.allCategorias().toString());
    }
    @PostMapping (value = "categoria")
    public String welcome(){
        return "Welcome form secure endpoint";
    }

}

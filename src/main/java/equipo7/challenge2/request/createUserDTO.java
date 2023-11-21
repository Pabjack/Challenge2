package equipo7.challenge2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class createUserDTO {
    private String nombre_usuario;
    private String correo;
    private String contrasena;
    private Set<String> roles;

}

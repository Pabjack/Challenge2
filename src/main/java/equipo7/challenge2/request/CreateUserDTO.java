package equipo7.challenge2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private Set<String> roles;

}

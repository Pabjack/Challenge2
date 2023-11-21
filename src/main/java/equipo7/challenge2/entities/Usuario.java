package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    private String nombreUsuario; // Cambiado a camel case

    private String correo;
    private String contrasena;
    private String info_pago;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = TipoUsuario.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;
}



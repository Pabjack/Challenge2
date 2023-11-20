package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    private String nombre_usuario;
    private String correo;
    private String contrasena;
    private String info_pago;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_tipoUsuario",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn (name = "id_role", referencedColumnName = "id_role"))
    private List<TipoUsuario> roles = new ArrayList<>();
    @ManyToMany(targetEntity = Transaccion.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_transaccion",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_transaccion"))
    private List<Transaccion> transacciones;
    }

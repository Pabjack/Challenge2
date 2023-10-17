package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;
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
    //contrasena
    private String info_pago;

   // @OneToOne(targetEntity = Sesion.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
   // private Sesion sesion;

   // @OneToMany(targetEntity = Resena.class, fetch = FetchType.LAZY, mappedBy = "usuario", fetch = FetchType.LAZY)
   // private List<Resena> resenas;

    @ManyToMany(targetEntity = Transaccion.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_transaccion",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_transaccion"))
    private List<Transaccion> transacciones;
    }

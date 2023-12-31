package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_resena;
    private String comentarios;
    //comentarioss
    private String calificacion;

    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(targetEntity = Producto.class, cascade =  CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name= "id_producto")
    private Producto producto;
}

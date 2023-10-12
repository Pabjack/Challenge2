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

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_proveedor;
    private String nombre_proveedor;
    private String descripcion;
    private String contacto;

  //  @ManyToMany(targetEntity = Producto.class, fetch = FetchType.LAZY)
  //  private List<Producto> productos;
}

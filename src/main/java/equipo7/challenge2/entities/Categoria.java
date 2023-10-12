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

public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;

  //  @ManyToMany(targetEntity = Producto.class, fetch = FetchType.LAZY)
  //  private List<Producto> productos;
}

package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;
import java.awt.desktop.UserSessionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//jkgjhg
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_transaccion;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    private double monto;
    private String estado;
    private String informacion_app;
//hjghgujyg
  //  @ManyToMany(targetEntity = Producto.class, fetch = FetchType.LAZY)
  //  private List<Producto> productos;

  //  @ManyToMany(targetEntity = Usuario.class, fetch = FetchType.LAZY)
  //  private  List<Usuario> usuarios;
}

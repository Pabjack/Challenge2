package equipo7.challenge2.entities;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sesion;
    //sesion
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    private String estado_sesion;
    //estado-sesion    private long id_usuario;

   // @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.PERSIST)
   // @JoinColumn(name ="id_usuario")
    //private Usuario usuario;
}

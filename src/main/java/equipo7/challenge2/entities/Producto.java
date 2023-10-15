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
//jsjhj
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cproducto;
    private String nombre_producto;
    private String descripcion_producto;
    private long cantidad_producto;

    @ManyToMany(targetEntity = Categoria.class, fetch = FetchType.LAZY)
    private List<Categoria> categorias;

    //@OneToMany(targetEntity = Resena.class, fetch = FetchType.LAZY, mappedBy = "producto")
    //private  List<Resena> resenas;

    @ManyToMany (targetEntity = Proveedor.class, fetch =  FetchType.LAZY)
    private List<Proveedor> proveedoress;

    @ManyToMany(targetEntity = Transaccion.class, fetch = FetchType.LAZY)
    private List<Transaccion> transacciones;
}

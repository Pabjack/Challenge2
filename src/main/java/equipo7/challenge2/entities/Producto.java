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

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private long cantidad_producto;

   @ManyToMany(targetEntity = Categoria.class, fetch = FetchType.LAZY)
   @JoinTable(
           name = "producto_categoria",
           joinColumns = @JoinColumn(name = "id_producto"),
           inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias;


    @ManyToMany (targetEntity = Proveedor.class, fetch =  FetchType.LAZY)
    @JoinTable(
            name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_proveedor"))
    private List<Proveedor> proveedoress;

    @ManyToMany(targetEntity = Transaccion.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "producto_transaccion",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_transaccion"))
    private List<Transaccion> transacciones;
}

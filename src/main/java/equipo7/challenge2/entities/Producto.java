package equipo7.challenge2.entities;
import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.exception.DataException;
import equipo7.challenge2.repositories.RepositoryProducto;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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


    public long getId_cproducto() {
        return id_producto;
    }

    public void setId_cproducto(long id_cproducto) {
        this.id_producto = id_cproducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public long getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(long cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Proveedor> getProveedoress() {
        return proveedoress;
    }

    public void setProveedoress(List<Proveedor> proveedoress) {
        this.proveedoress = proveedoress;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

   /* public ResponseEntity<Object> getProducto(){
        List<Producto> productoList = RepositoryProducto.findAll();
        if(!productoList.isEmpty()){
            RepositoryProducto = new RepositoryProducto(productoList, "Obtencion de todos los productos",200, true);
            return new ResponseEntity<>(RepositoryProducto.response2(), HttpStatus.OK);
        }else {
            System.out.println(new DataException("No se encontraron registros de producto"));
            RepositoryProducto = new RepositoryProducto("No se encontraron registros del producto", 400, false);
            return new ResponseEntity<>(GenericResponse);
        }
    } */




}

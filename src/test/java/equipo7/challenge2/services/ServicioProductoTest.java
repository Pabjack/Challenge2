package equipo7.challenge2.services;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.repositories.RepositoryProducto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ServicioProductoTest {
    @Mock
    private RepositoryProducto repositoryProducto;

    @InjectMocks
    private ServicioProducto servicioProducto;

    private Producto producto;

    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);
    Date fechaHoraActual = new Date();
    SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);
    String mensajeCoFehaHora = fechaHoraFormateada;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        producto = new Producto();
        producto.setId_cproducto(1L);
        producto.setNombre_producto("Producto de prueba");
        producto.setDescripcion_producto("Descripción de prueba");
        producto.setCantidad_producto(10L);

    }

    @Test
    void allProductos() {
        servicioProducto.allProductos();
        verify(repositoryProducto, times(1)).findAll();
        logger.info("Se visualizaron los productos exitosamente " + mensajeCoFehaHora);
    }

    @Test
    void findProducto() {
        when(repositoryProducto.findById(1)).thenReturn(Optional.of(producto));
        servicioProducto.findProducto(1);
        verify(repositoryProducto, times(1)).findById(1);
        logger.info("Se encontro el producto exitosamente " + mensajeCoFehaHora);
    }

    @Test
    void deleteProducto() {
        servicioProducto.deleteProducto(1);
        verify(repositoryProducto, times(1)).deleteById(1);
        logger.info("Se borro el producto exitosamente " + mensajeCoFehaHora);
    }

    @Test
    void addProducto() {
        when(repositoryProducto.save(producto)).thenReturn(producto);
        servicioProducto.addProducto(producto);
        verify(repositoryProducto, times(1)).save(producto);
        logger.info("Se agrego el producto exitosamente " + mensajeCoFehaHora);
    }
}


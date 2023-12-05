package equipo7.challenge2.services;

import equipo7.challenge2.entities.Proveedor;
import equipo7.challenge2.repositories.RepositoryProveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ServicioProveedorTest {
    @Mock
    private RepositoryProveedor repositoryProveedor;

    @InjectMocks
    private ServicioProveedor servicioProveedor;

    private Proveedor proveedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        proveedor = new Proveedor();
        proveedor.setId_proveedor(1L);
        proveedor.setNombre_proveedor("Proveedor de prueba");
        proveedor.setDescripcion("Descripción de prueba");
        proveedor.setContacto("Contacto de prueba");
    }

    @Test
    void allProveedores() {
        servicioProveedor.allProveedores();
        verify(repositoryProveedor, times(1)).findAll();
    }

    @Test
    void findProveedores() {
        when(repositoryProveedor.findById(1)).thenReturn(Optional.of(proveedor));
        servicioProveedor.findProveedores(1);
        verify(repositoryProveedor, times(1)).findById(1);
    }

    @Test
    void deleteProveedor() {
        servicioProveedor.deleteProveedor(1);
        verify(repositoryProveedor, times(1)).deleteById(1);
    }
    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);

    @Test
    void addProveedor() {
        when(repositoryProveedor.save(proveedor)).thenReturn(proveedor);
        servicioProveedor.addProveedor(proveedor);
        verify(repositoryProveedor, times(1)).save(proveedor);
        logger.info("Logger exitoso.");

    }
}

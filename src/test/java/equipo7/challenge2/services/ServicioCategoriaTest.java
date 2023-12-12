package equipo7.challenge2.services;
import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.repositories.RepositoryCategoria;
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

public class ServicioCategoriaTest {
    @Mock
    private RepositoryCategoria repositoryCategoria;

    @InjectMocks
    private ServicioCategoria servicioCategoria;

    private Categoria categoria;

    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);
    Date fechaHoraActual = new Date();
    SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);
    String mensajeCoFehaHora = fechaHoraFormateada;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoria = new Categoria();
        categoria.setId_categoria(1L);
        categoria.setNombre_categoria("Categoria de prueba");
        categoria.setDescripcion_categoria("Descripción de prueba");
    }

    @Test
    void allCategorias() {
        servicioCategoria.allCategorias();
        verify(repositoryCategoria, times(1)).findAll();
        logger.info("Estas son todas las categorias a la fecha " + mensajeCoFehaHora);
    }

    @Test
    void findCategoria() {
        when(repositoryCategoria.findById(1)).thenReturn(Optional.of(categoria));
        servicioCategoria.findCategoria(1);
        verify(repositoryCategoria, times(1)).findById(1);
        logger.info("Estas son las categorias encontradas " + mensajeCoFehaHora);
    }

    @Test
    void deleteCategoria() {
        servicioCategoria.deleteCategoria(1);
        verify(repositoryCategoria, times(1)).deleteById(1);
        logger.info("Se borro la categoria " + mensajeCoFehaHora);
    }


    @Test
    void addCategoria() {
        when(repositoryCategoria.save(categoria)).thenReturn(categoria);
        servicioCategoria.addCategoria(categoria);
        verify(repositoryCategoria, times(1)).save(categoria);
        logger.info("Se añadio la categoria exitosamente " + mensajeCoFehaHora);
    }


}

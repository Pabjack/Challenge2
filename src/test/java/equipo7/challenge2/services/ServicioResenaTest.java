package equipo7.challenge2.services;

import equipo7.challenge2.entities.Resena;
import equipo7.challenge2.repositories.RepositoryResena;
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

public class ServicioResenaTest {
    @Mock
    private RepositoryResena repositoryResena;

    @InjectMocks
    private ServicioResena servicioResena;

    private Resena resena;

    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);
    Date fechaHoraActual = new Date();
    SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);
    String mensajeCoFehaHora = fechaHoraFormateada;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        resena = new Resena();
        resena.setId_resena(1L);
        resena.setComentarios("Comentario de prueba");
        resena.setCalificacion("Calificación de prueba");
    }

    @Test
    void allResenas() {
        servicioResena.allResenas();
        verify(repositoryResena, times(1)).findAll();
        logger.info("Estas son todas las reseñas a la fecha " + mensajeCoFehaHora);
    }

    @Test
    void findResena() {
        when(repositoryResena.findById(1)).thenReturn(Optional.of(resena));
        servicioResena.findResena(1);
        verify(repositoryResena, times(1)).findById(1);
        logger.info("Estas son las reseñas encontradas a la fecha " + mensajeCoFehaHora);
    }

    @Test
    void deleteResena() {
        servicioResena.deleteResena(1);
        verify(repositoryResena, times(1)).deleteById(1);
        logger.info("Se elimino la reseña " + mensajeCoFehaHora);
    }

    @Test
    void addResena() {
        when(repositoryResena.save(resena)).thenReturn(resena);
        servicioResena.addResena(resena);
        verify(repositoryResena, times(1)).save(resena);
        logger.info("Se añadio la reseña " + mensajeCoFehaHora);
    }
}

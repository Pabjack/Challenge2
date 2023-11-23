package equipo7.challenge2.services;

import equipo7.challenge2.entities.Resena;
import equipo7.challenge2.repositories.RepositoryResena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ServicioResenaTest {
    @Mock
    private RepositoryResena repositoryResena;

    @InjectMocks
    private ServicioResena servicioResena;

    private Resena resena;

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
    }

    @Test
    void findResena() {
        when(repositoryResena.findById(1)).thenReturn(Optional.of(resena));
        servicioResena.findResena(1);
        verify(repositoryResena, times(1)).findById(1);
    }

    @Test
    void deleteResena() {
        servicioResena.deleteResena(1);
        verify(repositoryResena, times(1)).deleteById(1);
    }

    @Test
    void addResena() {
        when(repositoryResena.save(resena)).thenReturn(resena);
        servicioResena.addResena(resena);
        verify(repositoryResena, times(1)).save(resena);
    }
}

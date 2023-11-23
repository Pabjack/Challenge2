package equipo7.challenge2.services;

import equipo7.challenge2.entities.Transaccion;
import equipo7.challenge2.repositories.RepositoryTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ServicioTransaccionTest {
    @Mock
    private RepositoryTransaccion repositoryTransaccion;

    @InjectMocks
    private ServicioTransaccion servicioTransaccion;

    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        transaccion = new Transaccion();
        transaccion.setId_transaccion(1L);
        transaccion.setFecha(LocalDate.now());
        transaccion.setMonto(100.0);
        transaccion.setEstado("Estado de prueba");
        transaccion.setInformacion_pago("Información de pago de prueba");
    }

    @Test
    void allTransaccion() {
        servicioTransaccion.allTransaccion();
        verify(repositoryTransaccion, times(1)).findAll();
    }

    @Test
    void findTransaccion() {
        when(repositoryTransaccion.findById(1)).thenReturn(Optional.of(transaccion));
        servicioTransaccion.findTransaccion(1);
        verify(repositoryTransaccion, times(1)).findById(1);
    }

    @Test
    void deleteSesion() {
        servicioTransaccion.deleteSesion(1);
        verify(repositoryTransaccion, times(1)).deleteById(1);
    }

    @Test
    void addTransaccion() {
        when(repositoryTransaccion.save(transaccion)).thenReturn(transaccion);
        servicioTransaccion.addTransaccion(transaccion);
        verify(repositoryTransaccion, times(1)).save(transaccion);
    }
}


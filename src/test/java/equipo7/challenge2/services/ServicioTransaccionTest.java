package equipo7.challenge2.services;

import equipo7.challenge2.entities.Transaccion;
import equipo7.challenge2.repositories.RepositoryTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ServicioTransaccionTest {
    @Mock
    private RepositoryTransaccion repositoryTransaccion;

    @InjectMocks
    private ServicioTransaccion servicioTransaccion;

    private Transaccion transaccion;

    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);
    Date fechaHoraActual = new Date();
    SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);
    String mensajeCoFehaHora = fechaHoraFormateada;
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
        logger.info("Se encontro la transaccion " + mensajeCoFehaHora);
    }

    @Test
    void deleteSesion() {
        servicioTransaccion.deleteSesion(1);
        verify(repositoryTransaccion, times(1)).deleteById(1);
        logger.info("Se borro la transaccion " + mensajeCoFehaHora);
    }

    @Test
    void addTransaccion() {
        when(repositoryTransaccion.save(transaccion)).thenReturn(transaccion);
        servicioTransaccion.addTransaccion(transaccion);
        verify(repositoryTransaccion, times(1)).save(transaccion);
        logger.info("Se añadio la transaccion " + mensajeCoFehaHora);
    }
}


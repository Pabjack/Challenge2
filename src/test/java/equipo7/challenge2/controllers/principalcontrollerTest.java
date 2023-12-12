package equipo7.challenge2.controllers;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import equipo7.challenge2.request.CreateUserDTO;
import equipo7.challenge2.services.ServicioCategoriaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class principalcontrollerTest {
    @Mock
    private RepositoryUsuario repositoryUsuario;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private principalcontroller principalController;

    private MockMvc mockMvc;
    private Usuario usuario;
    private CreateUserDTO createUserDTO;

    private static final Logger logger = LoggerFactory.getLogger(ServicioCategoriaTest.class);
    Date fechaHoraActual = new Date();
    SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);
    String mensajeCoFehaHora = fechaHoraFormateada;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(principalController).build();

        Set<String> roles = new HashSet<>();
        roles.add("USER");

        createUserDTO = new CreateUserDTO();
        createUserDTO.setNombreUsuario("Usuario de prueba");
        createUserDTO.setCorreo("correo@prueba.com");
        createUserDTO.setContrasena("contraseña");
        createUserDTO.setRoles(roles);

        usuario = new Usuario();
        usuario.setId_usuario(1L);
        usuario.setNombreUsuario(createUserDTO.getNombreUsuario());
        usuario.setCorreo(createUserDTO.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(createUserDTO.getContrasena()));

        logger.info("Prueba de creacion de usuario ejecutada correctamente con fecha de " + mensajeCoFehaHora);
    }

    @Test
    void createUser() throws Exception {
        doReturn(usuario).when(repositoryUsuario).save(usuario);
        mockMvc.perform(post("/crearUsuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombreUsuario\":\"Usuario de prueba\",\"correo\":\"correo@prueba.com\",\"contrasena\":\"contraseña\",\"roles\":[\"USER\"]}"))
                .andExpect(status().isOk());
        logger.info("Creacion de usuario correcta " + mensajeCoFehaHora);
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/deleteUsuario")
                        .param("id_usuario", "1"))
                .andExpect(status().isOk());
        logger.info("Borrado de usuario realizado exitosamente el dia " + mensajeCoFehaHora);
    }
}

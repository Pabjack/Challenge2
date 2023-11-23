package equipo7.challenge2.controllers;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import equipo7.challenge2.request.CreateUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
    }

    @Test
    void createUser() throws Exception {
        doReturn(usuario).when(repositoryUsuario).save(usuario);
        mockMvc.perform(post("/crearUsuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombreUsuario\":\"Usuario de prueba\",\"correo\":\"correo@prueba.com\",\"contrasena\":\"contraseña\",\"roles\":[\"USER\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/deleteUsuario")
                        .param("id_usuario", "1"))
                .andExpect(status().isOk());
    }
}

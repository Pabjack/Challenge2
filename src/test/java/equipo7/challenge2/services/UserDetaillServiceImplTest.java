package equipo7.challenge2.services;

import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserDetaillServiceImplTest {
    @Mock
    private RepositoryUsuario repositoryUsuario;

    @InjectMocks
    private UserDetaillServiceImpl userDetaillService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario();
        usuario.setId_usuario(1L);
        usuario.setNombreUsuario("Usuario de prueba");
        usuario.setCorreo("correo@prueba.com");
        usuario.setContrasena("contraseña");
        usuario.setRoles(new HashSet<>());
    }

    @Test
    void loadUserByUsername() {
        when(repositoryUsuario.findByNombreUsuario(usuario.getNombreUsuario())).thenReturn(Optional.of(usuario));
        UserDetails userDetails = userDetaillService.loadUserByUsername(usuario.getNombreUsuario());
        assertEquals(usuario.getNombreUsuario(), userDetails.getUsername());
    }

    @Test
    void loadUserByUsernameNotFound() {
        when(repositoryUsuario.findByNombreUsuario(usuario.getNombreUsuario())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userDetaillService.loadUserByUsername(usuario.getNombreUsuario()));
    }
}

package equipo7.challenge2.services;

import equipo7.challenge2.Security.JWT.JWTUtils;
import equipo7.challenge2.Security.filters.JwtAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    @Mock
    private JWTUtils jwtUtils;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Test
    void testAttemptAuthentication() throws Exception {
        // Preparar
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        doReturn(new ByteArrayInputStream("{\"nombreUsuario\":\"testUser\",\"contrasena\":\"testPassword\"}".getBytes()))
                .when(request).getInputStream();
        when(authenticationManager.authenticate(any())).thenReturn(mock(Authentication.class));
        // Ejecutar
        jwtAuthenticationFilter.attemptAuthentication(request, response);
        // Verificar
        verify(authenticationManager).authenticate(any());
    }
}

package equipo7.challenge2.config;

import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = repositoryUsuario
                .findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email" + correo + "no existe"));

        return new UserDetailsImpl(usuario);

    }


}

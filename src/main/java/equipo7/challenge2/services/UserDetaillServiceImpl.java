package equipo7.challenge2.services;

import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetaillServiceImpl implements UserDetailsService {
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = repositoryUsuario.findByNombreUsuario(nombreUsuario).orElseThrow(() ->
        new UsernameNotFoundException("El usuario "  + nombreUsuario + "no existe"));

        Collection<? extends GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name())))
                .collect(Collectors.toSet()) ;

        return new User(
                usuario.getNombreUsuario(),
                usuario.getContrasena(),
                true,
                true,
                true,
                true,
                authorities);
    }
}

package equipo7.challenge2.config;

import equipo7.challenge2.entities.TipoUsuario;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    public UserDetailServiceImpl(RepositoryUsuario repositoryUsuario) {
        this.repositoryUsuario = repositoryUsuario;
    }

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = repositoryUsuario.findByName(correo).orElseThrow(()-> new UsernameNotFoundException("No se encontro el usuario"));


        return new User(usuario.getNombre_usuario(), usuario.getContrasena(),mapRolesTiAuthorities(usuario.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesTiAuthorities(List<TipoUsuario> tipoUsuarios){
        return tipoUsuarios.stream().map(tipoUsuario -> new SimpleGrantedAuthority(tipoUsuario.getRole())).collect(Collectors.toList());
    }
}

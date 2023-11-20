package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryUsuario extends CrudRepository <Usuario, Integer>{
    Optional<Usuario> findByName(String correo);
    Boolean existsUsuarioBy(String correo);
}

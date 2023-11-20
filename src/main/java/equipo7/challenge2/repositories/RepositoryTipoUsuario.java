package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryTipoUsuario  extends CrudRepository<TipoUsuario, Integer> {
    Optional<TipoUsuario> findBy(String tipo_usuario);
}

package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryUsuario extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario); // Cambiado a camel case
}
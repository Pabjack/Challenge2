package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRole  extends CrudRepository<Role, Long> {



}

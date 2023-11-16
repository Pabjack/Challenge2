package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositoryProducto extends CrudRepository<Producto, Integer> {

}


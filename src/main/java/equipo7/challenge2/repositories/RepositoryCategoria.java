package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositoryCategoria extends CrudRepository <Categoria, Integer>{

}

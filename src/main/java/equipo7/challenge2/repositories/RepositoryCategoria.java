package equipo7.challenge2.repositories;

import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryCategoria extends CrudRepository <Categoria, Integer>{

}

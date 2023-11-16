package equipo7.challenge2.services;


import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.repositories.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioProducto {
    @Autowired
    private RepositoryProducto repositoryProducto;

    public Iterable<Producto> allProductos(){
        return repositoryProducto.findAll();
    }
    public Optional<Producto> findProducto(int id){
        return repositoryProducto.findById(id);
    }

    public void deleteProducto(int id){
        repositoryProducto.deleteById(id);
    }
    public Producto addProducto(Producto p){
        return repositoryProducto.save(p);
    }
}


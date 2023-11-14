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

    public RepositoryProducto allProductos(){
        return repositoryProducto;
    }
    public RepositoryProducto findProducto(int id){
        return repositoryProducto;
    }

    public Optional <Producto> deleteProducto(int id){
         repositoryProducto.deleteById(id);
         return null;
    }
    public Optional<Producto> addProducto(Producto p){
        return null;
    }
    }


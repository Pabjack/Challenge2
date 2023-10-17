package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryCategoria;
import equipo7.challenge2.repositories.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioProducto {
    @Autowired
    private RepositoryProducto repository;

    public Iterable<Producto> allProductos(){
        return  repository.findAll();
    }
    public Optional<Producto> findProducto(int id){
        return repository.findById(id);
    }

    public Optional <Producto> deleteProducto(int id){
         repository.deleteById(id);
         return null;
    }
    public Optional<Producto> addProducto(Producto p){
        repository.save(p);
        return null;
    }
    }


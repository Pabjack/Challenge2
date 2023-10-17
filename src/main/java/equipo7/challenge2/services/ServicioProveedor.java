package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.entities.Proveedor;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryCategoria;
import equipo7.challenge2.repositories.RepositoryProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioProveedor {
    @Autowired
    private RepositoryProveedor repository;

    public Iterable<Proveedor> allProveedores(){
        return  repository.findAll();
    }
    public Optional<Proveedor> findProveedores(int id){
        return repository.findById(id);
    }
    public Optional <Proveedor> deleteProveedor(int id){
        repository.deleteById(id);
        return null;
    }
    public Optional<Proveedor> addProveedor(Proveedor p){
        repository.save(p);
        return null;
    }
    }



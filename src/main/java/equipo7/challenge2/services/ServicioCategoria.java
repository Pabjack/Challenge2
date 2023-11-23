package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioCategoria {

    @Autowired
    private  RepositoryCategoria repository;

    public Iterable<Categoria> allCategorias(){
        return  repository.findAll();
    }
    public Optional<Categoria> findCategoria(int id){
        return repository.findById(id);
    }
    public Optional <Categoria> deleteCategoria(int id){
        repository.deleteById(id);
        return null;
    }
    public Optional<Categoria> addCategoria(Categoria c){
        repository.save(c);
        return null;
    }
    }


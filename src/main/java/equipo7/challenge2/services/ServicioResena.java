package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.entities.Resena;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryCategoria;
import equipo7.challenge2.repositories.RepositoryResena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioResena {
    @Autowired
    private RepositoryResena repository;

    public Iterable<Resena> allResenas(){
        return  repository.findAll();
    }
    public Optional<Resena> findResena(int id){
        return repository.findById(id);
    }
    public Optional <Resena> deleteResena(int id){
        repository.deleteById(id);
        return null;
    }
    public Optional<Resena> addResena(Resena r){
        repository.save(r);
        return null;
    }
    }


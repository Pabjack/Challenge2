package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Producto;
import equipo7.challenge2.entities.Sesion;
import equipo7.challenge2.repositories.RepositoryCategoria;
import equipo7.challenge2.repositories.RepositorySesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioSesion {
    @Autowired
    private RepositorySesion repository;

    public Iterable<Sesion> allSesion(){
        return  repository.findAll();
    }
    public Optional<Sesion> findSesion(int id){
        return repository.findById(id);
    }
    public Optional <Producto> deleteSesion(int id){
        repository.deleteById(id);
        return null;
    }
    }


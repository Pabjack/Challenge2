package equipo7.challenge2.services;


import equipo7.challenge2.entities.Categoria;
import equipo7.challenge2.entities.Transaccion;
import equipo7.challenge2.repositories.RepositoryCategoria;
import equipo7.challenge2.repositories.RepositoryTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioTransaccion {
    @Autowired
    private RepositoryTransaccion repository;

    public Iterable<Transaccion> allTransaccion(){
        return  repository.findAll();
    }
    public Optional<Transaccion> findTransaccion(int id){
        return repository.findById(id);
    }
    }


package equipo7.challenge2.services;


import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    @Autowired
    private RepositoryUsuario repository;

    public List<Usuario> allUsuarios(){
        return (List<Usuario>) repository.findAll();
    }
    public Optional<Usuario> findUsuario(int id){
        return repository.findById(id);
    }
    }


package equipo7.challenge2.services;


import equipo7.challenge2.domain.GenericResponse;
import equipo7.challenge2.entities.Usuario;
import equipo7.challenge2.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {
    @Autowired
    private RepositoryUsuario repository;

    public List<Usuario> allUsuarios(){
        return repository.findAll();
    }
    }


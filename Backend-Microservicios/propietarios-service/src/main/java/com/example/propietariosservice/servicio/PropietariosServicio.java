package com.example.propietariosservice.servicio;

import com.example.propietariosservice.modelo.Propietarios;
import com.example.propietariosservice.repository.PropietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietariosServicio {

    @Autowired
    private PropietariosRepository propietariosRepository;
    public List<Propietarios> obtenerTodosLosPropietarios() {
        return propietariosRepository.findAll();
    }
    public Optional<Propietarios> obtenerPropietarioPorId(Long id) {
        return propietariosRepository.findById(id);
    }
    public Propietarios guardarPropietario(Propietarios propietario) {
        return propietariosRepository.save(propietario);
    }

    public void eliminarPropietario(Long id) {
        propietariosRepository.deleteById(id);
    }
}

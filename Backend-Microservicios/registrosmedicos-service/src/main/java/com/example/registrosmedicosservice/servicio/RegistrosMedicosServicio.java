package com.example.registrosmedicosservice.servicio;

import com.example.registrosmedicosservice.modelo.RegistrosMedicos;
import com.example.registrosmedicosservice.repository.RegistrosMedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrosMedicosServicio {

    @Autowired
    private RegistrosMedicosRepository registrosMedicosRepository;

    public List<RegistrosMedicos> obtenerTodosLosRegistros() {
        return registrosMedicosRepository.findAll();
    }
    public Optional<RegistrosMedicos> obtenerRegistroPorId(Long id) {
        return registrosMedicosRepository.findById(id);
    }
    public RegistrosMedicos guardarRegistro(RegistrosMedicos registro) {
        return registrosMedicosRepository.save(registro);
    }
    public void eliminarRegistro(Long id) {
        registrosMedicosRepository.deleteById(id);
    }
}

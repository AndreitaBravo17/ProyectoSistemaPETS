package com.example.vacunasservice.servicio;

import com.example.vacunasservice.modelo.Vacunas;
import com.example.vacunasservice.repository.VacunasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacunasServicio {

    @Autowired
    private VacunasRepository vacunasRepository;

    public long contarMascotasVacunadas() {
        return vacunasRepository.countDistinctByMascotaId();
    }
    public List<Vacunas> obtenerTodasLasVacunas() {
        return vacunasRepository.findAll();
    }
    public Optional<Vacunas> obtenerVacunaPorId(Long id) {
        return vacunasRepository.findById(id);
    }
    public Vacunas guardarVacuna(Vacunas vacuna) {
        return vacunasRepository.save(vacuna);
    }
    public void eliminarVacuna(Long id) {
        vacunasRepository.deleteById(id);
    }
}

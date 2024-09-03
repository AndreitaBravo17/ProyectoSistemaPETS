package com.example.citasmedicasservice.servicio;
import com.example.citasmedicasservice.modelo.CitasMedicas;
import com.example.citasmedicasservice.repository.CitasMedicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CitasMedicasServicio {
    @Autowired
    private CitasMedicasRepository citasMedicasRepository;
    public long contarCitasMedicas() {
        return citasMedicasRepository.count();
    }
    public List<CitasMedicas> obtenerTodasLasCitas() {
        return citasMedicasRepository.findAll();
    }
    public Optional<CitasMedicas> obtenerCitaPorId(Long id) {
        return citasMedicasRepository.findById(id);
    }
    public CitasMedicas guardarCita(CitasMedicas cita) {
        return citasMedicasRepository.save(cita);
    }
    public void eliminarCita(Long id) {
        citasMedicasRepository.deleteById(id);
    }
    /*public Map<String, Integer> obtenerVisitasPorFecha() {
        List<CitasMedicas> citas = citasMedicasRepository.findAll(Sort.by(Sort.Direction.ASC, "fechaCita"));
        Map<String, Integer> visitasPorFecha = new HashMap<>();

        for (CitasMedicas cita : citas) {
            String fecha = cita.getFechaCita().toString(); // Asegúrate de formatear la fecha adecuadamente
            visitasPorFecha.put(fecha, visitasPorFecha.getOrDefault(fecha, 0) + 1);
        }

        return visitasPorFecha;
    }*/
}

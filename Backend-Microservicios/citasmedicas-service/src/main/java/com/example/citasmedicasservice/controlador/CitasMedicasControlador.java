package com.example.citasmedicasservice.controlador;
import com.example.citasmedicasservice.modelo.CitasMedicas;
import com.example.citasmedicasservice.servicio.CitasMedicasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/citas-medicas")
public class CitasMedicasControlador {

    @Autowired
    private CitasMedicasServicio citasMedicasServicio;
    @GetMapping("/count")
    public long countCitasMedicas() {
        return citasMedicasServicio.contarCitasMedicas();
    }
    @GetMapping
    public List<CitasMedicas> obtenerTodasLasCitas() {
        return citasMedicasServicio.obtenerTodasLasCitas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CitasMedicas> obtenerCitaPorId(@PathVariable Long id) {
        Optional<CitasMedicas> cita = citasMedicasServicio.obtenerCitaPorId(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CitasMedicas crearCita(@RequestBody CitasMedicas cita) {
        return citasMedicasServicio.guardarCita(cita);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CitasMedicas> actualizarCita(@PathVariable Long id,
                                                       @RequestBody CitasMedicas cita) {
        Optional<CitasMedicas> citaExistente = citasMedicasServicio.obtenerCitaPorId(id);
        if (citaExistente.isPresent()) {
            cita.setId(id);
            return ResponseEntity.ok(citasMedicasServicio.guardarCita(cita));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citasMedicasServicio.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }
    /*@GetMapping("/visitas-por-fecha")
    public Map<String, Integer> obtenerVisitasPorFecha() {
        return citasMedicasServicio.obtenerVisitasPorFecha();
    }*/
}

package com.example.vacunasservice.controlador;
import com.example.vacunasservice.modelo.Vacunas;
import com.example.vacunasservice.servicio.VacunasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/vacunas")
public class VacunasControlador {

    @Autowired
    private VacunasServicio vacunasServicio;
    @GetMapping("/countDistinctMascotas")
    public long countDistinctMascotas() {
        return vacunasServicio.contarMascotasVacunadas();
    }
    @GetMapping
    public List<Vacunas> obtenerTodasLasVacunas() {
        return vacunasServicio.obtenerTodasLasVacunas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vacunas> obtenerVacunaPorId(@PathVariable Long id) {
        Optional<Vacunas> vacuna = vacunasServicio.obtenerVacunaPorId(id);
        return vacuna.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vacunas crearVacuna(@RequestBody Vacunas vacuna) {
        return vacunasServicio.guardarVacuna(vacuna);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vacunas> actualizarVacuna(@PathVariable Long id,
                                                    @RequestBody Vacunas vacuna) {
        Optional<Vacunas> vacunaExistente = vacunasServicio.obtenerVacunaPorId(id);
        if (vacunaExistente.isPresent()) {
            vacuna.setId(id);
            return ResponseEntity.ok(vacunasServicio.guardarVacuna(vacuna));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVacuna(@PathVariable Long id) {
        vacunasServicio.eliminarVacuna(id);
        return ResponseEntity.noContent().build();
    }
}

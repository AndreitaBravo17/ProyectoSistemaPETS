package com.example.mascotasservice.controlador;

import com.example.mascotasservice.modelo.Mascotas;
import com.example.mascotasservice.servicio.MascotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/mascotas")
public class MascotasControlador {

    @Autowired
    private MascotasServicio mascotasServicio;
    @GetMapping("/count")
    public long countMascotas() {
        return mascotasServicio.contarMascotas();
    }
    @GetMapping
    public List<Mascotas> obtenerTodasLasMascotas() {
        return mascotasServicio.obtenerTodasLasMascotas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mascotas> obtenerMascotaPorId(@PathVariable Long id) {
        Optional<Mascotas> mascota = mascotasServicio.obtenerMascotaPorId(id);
        return mascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mascotas crearMascota(@RequestBody Mascotas mascota) {
        return mascotasServicio.guardarMascota(mascota);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mascotas> actualizarMascota(@PathVariable Long id,
                                                      @RequestBody Mascotas mascota) {
        Optional<Mascotas> mascotaExistente = mascotasServicio.obtenerMascotaPorId(id);
        if (mascotaExistente.isPresent()) {
            mascota.setId(id);
            return ResponseEntity.ok(mascotasServicio.guardarMascota(mascota));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotasServicio.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/cantidad-por-raza")
    public Map<String, Long> contarMascotasPorRaza() {
        return mascotasServicio.contarMascotasPorRaza();
    }
}

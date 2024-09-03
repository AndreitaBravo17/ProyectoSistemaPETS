package com.example.propietariosservice.controlador;

import com.example.propietariosservice.modelo.Propietarios;
import com.example.propietariosservice.servicio.PropietariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/propietarios")
public class PropietariosControlador {

    @Autowired
    private PropietariosServicio propietariosServicio;

    @GetMapping
    public List<Propietarios> obtenerTodosLosPropietarios() {
        return propietariosServicio.obtenerTodosLosPropietarios();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Propietarios> obtenerPropietarioPorId(@PathVariable Long id) {
        Optional<Propietarios> propietario = propietariosServicio.obtenerPropietarioPorId(id);
        return propietario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Propietarios crearPropietario(@RequestBody Propietarios propietario) {
        return propietariosServicio.guardarPropietario(propietario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Propietarios> actualizarPropietario(@PathVariable Long id,
                                                              @RequestBody Propietarios propietario) {
        Optional<Propietarios> propietarioExistente = propietariosServicio.obtenerPropietarioPorId(id);
        if (propietarioExistente.isPresent()) {
            propietario.setId(id);
            return ResponseEntity.ok(propietariosServicio.guardarPropietario(propietario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable Long id) {
        propietariosServicio.eliminarPropietario(id);
        return ResponseEntity.noContent().build();
    }
}

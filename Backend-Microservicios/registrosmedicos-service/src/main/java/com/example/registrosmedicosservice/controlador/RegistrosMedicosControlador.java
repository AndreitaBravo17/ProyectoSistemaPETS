package com.example.registrosmedicosservice.controlador;
import com.example.registrosmedicosservice.modelo.RegistrosMedicos;
import com.example.registrosmedicosservice.servicio.RegistrosMedicosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/registros-medicos")
public class RegistrosMedicosControlador {

    @Autowired
    private RegistrosMedicosServicio registrosMedicosServicio;
    @GetMapping
    public List<RegistrosMedicos> obtenerTodosLosRegistros() {
        return registrosMedicosServicio.obtenerTodosLosRegistros();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistrosMedicos> obtenerRegistroPorId(@PathVariable Long id) {
        Optional<RegistrosMedicos> registro = registrosMedicosServicio.obtenerRegistroPorId(id);
        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public RegistrosMedicos crearRegistro(@RequestBody RegistrosMedicos registro) {
        return registrosMedicosServicio.guardarRegistro(registro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrosMedicos> actualizarRegistro(@PathVariable Long id,
                                                               @RequestBody RegistrosMedicos registro) {
        Optional<RegistrosMedicos> registroExistente = registrosMedicosServicio.obtenerRegistroPorId(id);
        if (registroExistente.isPresent()) {
            registro.setId(id);
            return ResponseEntity.ok(registrosMedicosServicio.guardarRegistro(registro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistro(@PathVariable Long id) {
        registrosMedicosServicio.eliminarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}

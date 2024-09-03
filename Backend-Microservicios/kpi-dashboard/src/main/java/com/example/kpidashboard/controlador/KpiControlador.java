package com.example.kpidashboard.controlador;

import com.example.kpidashboard.servicio.KpiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/kpi")
public class KpiControlador {

    @Autowired
    private KpiServicio kpiServicio;

    @GetMapping("/total-mascotas")
    public long obtenerTotalMascotasRegistradas() {
        return kpiServicio.obtenerTotalMascotasRegistradas();
    }

    @GetMapping("/total-citas")
    public long obtenerTotalCitasMedicas() {
        return kpiServicio.obtenerTotalCitasMedicas();
    }

    @GetMapping("/porcentaje-vacunadas")
    public double obtenerPorcentajeMascotasVacunadas() {
        return kpiServicio.obtenerPorcentajeMascotasVacunadas();
    }

    // Nuevo endpoint para obtener los datos de visitas al veterinario
    /*@GetMapping("/visitas-por-fecha")
    public Map<String, Integer> obtenerDatosVisitasVeterinario() {
        return kpiServicio.obtenerDatosVisitasVeterinario();
    }*/
}

// kpi-servicio.java
package com.example.kpidashboard.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class KpiServicio {

    @Autowired
    private RestTemplate restTemplate;

    // URLs base de los microservicios
    private final String BASE_URL_MASCOTAS = "http://localhost:3000/api/mascotas";
    private final String BASE_URL_CITAS_MEDICAS = "http://localhost:3000/api/citas-medicas";
    private final String BASE_URL_VACUNAS = "http://localhost:3000/api/vacunas";

    // KPI 1: Número Total de Mascotas Registradas
    public long obtenerTotalMascotasRegistradas() {
        String url = BASE_URL_MASCOTAS + "/count";
        return restTemplate.getForObject(url, Long.class);
    }

    // KPI 2: Número Total de Citas Médicas
    public long obtenerTotalCitasMedicas() {
        String url = BASE_URL_CITAS_MEDICAS + "/count";
        return restTemplate.getForObject(url, Long.class);
    }

    // KPI 3: Porcentaje de Mascotas Vacunadas
    public double obtenerPorcentajeMascotasVacunadas() {
        String urlMascotas = BASE_URL_MASCOTAS + "/count";
        String urlVacunas = BASE_URL_VACUNAS + "/countDistinctMascotas";
        long totalMascotas = restTemplate.getForObject(urlMascotas, Long.class);
        long mascotasVacunadas = restTemplate.getForObject(urlVacunas, Long.class);

        if (totalMascotas == 0) {
            return 0;
        }

        double porcentaje = (double) mascotasVacunadas / totalMascotas * 100;

        // Redondear a 2 decimales
        BigDecimal porcentajeRedondeado = new BigDecimal(porcentaje).setScale(2, RoundingMode.HALF_UP);

        // Asegurarse de que el porcentaje no exceda 100
        return Math.min(porcentajeRedondeado.doubleValue(), 100);
    }


}

package com.example.mascotasservice.servicio;
import com.example.mascotasservice.modelo.Mascotas;
import com.example.mascotasservice.repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotasServicio {

    @Autowired
    private MascotasRepository mascotasRepository;
    public long contarMascotas() {
        return mascotasRepository.count();
    }
    public List<Mascotas> obtenerTodasLasMascotas() {
        return mascotasRepository.findAll();
    }
    public Optional<Mascotas> obtenerMascotaPorId(Long id) {
        return mascotasRepository.findById(id);
    }
    public Mascotas guardarMascota(Mascotas mascota) {
        return mascotasRepository.save(mascota);
    }
    public void eliminarMascota(Long id) {
        mascotasRepository.deleteById(id);
    }
    public Map<String, Long> contarMascotasPorRaza() {
        return mascotasRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Mascotas::getRaza, Collectors.counting()));
    }
}

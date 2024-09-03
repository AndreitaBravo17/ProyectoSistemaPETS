package com.example.mascotasservice.repository;

import com.example.mascotasservice.modelo.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRepository extends JpaRepository<Mascotas, Long> {
}

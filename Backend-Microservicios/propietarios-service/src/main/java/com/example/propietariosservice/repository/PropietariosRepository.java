package com.example.propietariosservice.repository;


import com.example.propietariosservice.modelo.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietariosRepository extends JpaRepository<Propietarios, Long> {
}


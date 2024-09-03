package com.example.registrosmedicosservice.repository;

import com.example.registrosmedicosservice.modelo.RegistrosMedicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrosMedicosRepository extends JpaRepository<RegistrosMedicos, Long> {
}

package com.example.vacunasservice.repository;

import com.example.vacunasservice.modelo.Vacunas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunasRepository extends JpaRepository<Vacunas, Long> {

   @Query("SELECT COUNT(DISTINCT v.mascotaId) FROM Vacunas v")
    long countDistinctByMascotaId();
}

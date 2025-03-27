package com.si.responsableapi.repository;

import com.si.responsableapi.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
    Optional<Responsable> findByEmail(String email);
    boolean existsByEmail(String email);
}

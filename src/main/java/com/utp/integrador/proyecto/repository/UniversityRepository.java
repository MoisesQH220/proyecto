package com.utp.integrador.proyecto.repository;

import com.utp.integrador.proyecto.domain.University;
import com.utp.integrador.proyecto.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository <University, Integer> {
}

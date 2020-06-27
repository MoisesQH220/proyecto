package com.utp.integrador.proyecto.repository;

import com.utp.integrador.proyecto.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
}

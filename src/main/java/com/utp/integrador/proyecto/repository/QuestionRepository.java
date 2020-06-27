package com.utp.integrador.proyecto.repository;

import com.utp.integrador.proyecto.domain.Answer;
import com.utp.integrador.proyecto.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Integer> {
}

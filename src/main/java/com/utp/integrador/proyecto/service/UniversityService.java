package com.utp.integrador.proyecto.service;


import com.utp.integrador.proyecto.domain.University;
import com.utp.integrador.proyecto.repository.UniversityRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class UniversityService {
  
  private final UniversityRepository repo;
  
  public UniversityService(UniversityRepository repo){
    this.repo = repo;
  }
  
  public Flux<University> getUsers (){
    return Flux.fromIterable(repo.findAll());
  }
  
  public Mono<University> postUser (@NotNull University university){
    return Mono.fromSupplier(() -> university)
            .flatMap(json -> Mono.fromSupplier(() -> this.repo.save(json)));
            
  }
  
  public Mono<University> getUser (Integer id){
    return Mono.fromSupplier(() -> id)
            .flatMap(key -> Mono.fromSupplier(()-> this.repo.findById(key)
            .orElseThrow(RuntimeException::new))); 
  }
    
  
  
}

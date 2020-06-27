package com.utp.integrador.proyecto.service;


import com.utp.integrador.proyecto.domain.User;
import com.utp.integrador.proyecto.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class UserService {
  
  private final UserRepository repo;
  
  public UserService(UserRepository repo){
    this.repo = repo;
  }
  
  public Flux<User> getUsers (){
    return Flux.fromIterable(repo.findAll());
  }
  
  public Mono<User> postUser (@NotNull User user){
    return Mono.fromSupplier(() -> user)
            .flatMap(json -> Mono.fromSupplier(() -> this.repo.save(json)));
            
  }
  
  public Mono<User> getUser (Integer id){
    return Mono.fromSupplier(() -> id)
            .flatMap(key -> Mono.fromSupplier(()-> this.repo.findById(key)
            .orElseThrow(RuntimeException::new))); 
  }
    
  
  
}

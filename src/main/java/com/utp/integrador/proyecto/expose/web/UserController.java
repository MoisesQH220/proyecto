package com.utp.integrador.proyecto.expose.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

import com.utp.integrador.proyecto.domain.User;
import com.utp.integrador.proyecto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("users")
public class UserController {

  private final UserService service;

  public UserController(UserService service){
    this.service = service;
  }
  
  @GetMapping("/{id}")
  public Mono<User> getAUser(@PathVariable Integer id) {
    return this.service.getUser(id);
  }
  
  
  @GetMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_STREAM_JSON_VALUE})
  public Flux<User> getAllUsers() {
    return this.service.getUsers();
  }
  
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public Mono<User> createUser(@RequestBody @NotNull User user) {
    return this.service.postUser(user);
  }
  
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
  public Mono<Void> totalUpdate(@PathVariable Integer id,
                                   @RequestBody @NotNull User user) {
    return this.service.totalUpdate(id, user)
            .then();
  }
  
  
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  protected Mono<Void> delete(@PathVariable Integer id) {
    return this.service.delete(id)
            .then();
  }
  

}

package com.utp.integrador.proyecto.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "university")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class University {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, columnDefinition = "serial")
  private Integer id;

  @NotNull
  @Column(unique = true)
  @Size(min = 3, max = 100)
  private String name;

  @NotNull
  @Size(min = 3, max = 50)
  private String district;

  @NotNull
  @Size(min = 3, max = 50)
  private String city;

  @NotNull
  @Column(unique = true)
  @Size(min = 3, max = 10)
  private String ruc;

  @NotNull
  @Size(min = 2, max = 10)
  private String country;
}

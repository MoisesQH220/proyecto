package com.utp.integrador.proyecto.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.utp.integrador.proyecto.domain.detail.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, columnDefinition = "id")
  private Integer id;

  @NotNull
  private String name;

  @NotNull
  private String lastName;

  private String email;

  private String password;

  @NotNull
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private University university;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Role role;

}

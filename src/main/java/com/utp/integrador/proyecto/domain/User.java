package com.utp.integrador.proyecto.domain;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.utp.integrador.proyecto.domain.types.Role;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Getter
@Setter
@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, columnDefinition = "serial")
  private Integer id;

  @NotNull
  @Size(min = 3, max = 100)
  private String name;

  @NotNull
  @Size(min = 3, max = 50)
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Size(min = 3, max = 50)
  private String email;

  @NotNull
  @Size(min = 3, max = 50)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotNull
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @Basic(optional = false, fetch = FetchType.LAZY)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private University university;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "role")
  @Type(type = "pgsql_enum")
  private Role role;

}

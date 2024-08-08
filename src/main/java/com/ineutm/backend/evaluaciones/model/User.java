package com.ineutm.backend.evaluaciones.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USUARIO")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private long id;

  @Column(name = "NOMBRE")
  private String name;

  @Column(name = "NUMERODOCUMENTO")
  private String documentNumber;

  @Column(name = "ESTADO")
  private Integer state;

  @Column(name = "TIPO")
  String typeUser;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Account> accounts;

  


}
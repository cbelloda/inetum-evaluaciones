package com.ineutm.backend.evaluaciones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MOVIMIENTO")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class AccountDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private long id;
  
  @ManyToOne
  @JoinColumn(name = "IDCUENTA", referencedColumnName = "ID")
  private Account account;
  
  @Column(name = "DESCRIPCION")
  String description;
  
  @Column(name = "INTERESES")
  Double interests;

}
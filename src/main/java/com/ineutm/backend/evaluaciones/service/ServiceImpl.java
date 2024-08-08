package com.ineutm.backend.evaluaciones.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

  public String getAccount(String userIdentity) {
    return "el numero "+userIdentity;
  }
  
}

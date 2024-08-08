package com.ineutm.backend.evaluaciones.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ServiceImpl {

  public Flux<String> getAccount(String userIdentity) {
    return Flux.range(1, 220).map(number -> "el numero "+userIdentity+" -->  "+number);
  }
  
}

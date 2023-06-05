package com.ineutm.backend.evaluaciones.expose.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountController {

  @GetMapping("/{user-identity}")
  public Mono<String> getAllAccounts(@PathVariable("user-identity") String userIdentity) {

    return Mono.empty();
  }
  
}

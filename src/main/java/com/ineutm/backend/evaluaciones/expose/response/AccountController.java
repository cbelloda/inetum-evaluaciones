package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.service.ServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

  private final ServiceImpl service;

  @GetMapping("/{user-identity}")
  public Mono<List<String>> getAllAccounts(@PathVariable("user-identity") String userIdentity) {

    return service.getAccount(userIdentity).collectList();

  }
  
}

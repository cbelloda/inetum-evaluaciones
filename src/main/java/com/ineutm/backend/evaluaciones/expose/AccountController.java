package com.ineutm.backend.evaluaciones.expose;

import com.ineutm.backend.evaluaciones.business.AccountService;
import com.ineutm.backend.evaluaciones.business.UserIdentity;
import com.ineutm.backend.evaluaciones.expose.response.UserResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@Slf4j
@RequiredArgsConstructor
@Validated
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/{user-identity}")
  public Mono<UserResponse> getAllAccounts(@PathVariable("user-identity") @Valid @UserIdentity String userIdentity) {

    return accountService.evaluate(userIdentity);
    
  }

}

package com.ineutm.backend.evaluaciones.business;

import com.ineutm.backend.evaluaciones.expose.response.UserResponse;
import com.ineutm.backend.evaluaciones.model.User;
import java.util.function.BiFunction;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TypeUser {
  PREMIUM(AccountService::getInfoAccountInfoPremium),
  NORMAL(AccountService::getInfoAccountInfoNormal);

  public final BiFunction<AccountService, User, Mono<UserResponse>> evaluator;
}

package com.ineutm.backend.evaluaciones.business;

import com.ineutm.backend.evaluaciones.expose.response.AccountDetailResponse;
import com.ineutm.backend.evaluaciones.expose.response.AccountResponse;
import com.ineutm.backend.evaluaciones.expose.response.UserResponse;
import com.ineutm.backend.evaluaciones.model.Account;
import com.ineutm.backend.evaluaciones.model.User;
import com.ineutm.backend.evaluaciones.repository.AccountDetailRepository;
import com.ineutm.backend.evaluaciones.repository.UserRepository;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

  private final UserRepository userRepository;
  private final AccountDetailRepository accountDetailRepository;

  public Mono<UserResponse> getInfoAccountInfoPremium(User user) {
    return infoBase(user, account -> AccountResponse.MAPPER.apply(account)
        .interest(Double.valueOf(100d))
        .details(accountDetailRepository
            .findByAccount(account).stream().map(AccountDetailResponse.MAPPER::apply)
            .collect(Collectors.toList()))
        .build());
  }

  public Mono<UserResponse> getInfoAccountInfoNormal(User user) {
    return infoBase(user, account -> AccountResponse.MAPPER.apply(account)
        .build());

  }

  private Mono<UserResponse> infoBase(User userBase, Function<Account, AccountResponse> strategy) {
    return Mono.just(userBase).map(user -> UserResponse.MAPPER.apply(user)
        .accounts(user.getAccounts().stream()
            .map(strategy)
            .collect(Collectors.toList()))
        .build());
  }


  public Mono<UserResponse> evaluate(String documentNumber) {
    return Mono.just(documentNumber).map(userRepository::findByDocumentNumber)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .flatMap(user -> TypeUser.valueOf(user.getTypeUser()).evaluator.apply(this, user));    
  }

}

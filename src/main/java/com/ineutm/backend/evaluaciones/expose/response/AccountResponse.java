package com.ineutm.backend.evaluaciones.expose.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ineutm.backend.evaluaciones.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountResponse implements Serializable {

  @Schema(name = "accountNumber", type = "String", format = "alphanumeric", description = "account number form the database", example = "3321-2333-2231-3231") 
  private String accountNumber;

  private Double interest;
  @Transient
  private List<AccountDetailResponse> details;

  public static final Function<Account, AccountResponseBuilder> MAPPER = account -> AccountResponse.builder()
      .accountNumber(account.getNumber());

}

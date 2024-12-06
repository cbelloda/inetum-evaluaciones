package com.ineutm.backend.evaluaciones.expose.response;

import com.ineutm.backend.evaluaciones.model.AccountDetail;
import java.io.Serializable;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDetailResponse implements Serializable {

  String description;
  Double interests;

  public static final Function<AccountDetail, AccountDetailResponse> MAPPER = detail -> AccountDetailResponse.builder()
      .description(detail.getDescription())
      .interests(detail.getInterests())
      .build()
      ;

}

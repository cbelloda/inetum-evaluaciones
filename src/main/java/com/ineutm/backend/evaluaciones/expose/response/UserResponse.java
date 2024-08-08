package com.ineutm.backend.evaluaciones.expose.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ineutm.backend.evaluaciones.model.User;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse implements Serializable {

  private String userName;
  private String documentNumber;

  private List<AccountResponse> accounts;

  public static final Function<User, UserResponseBuilder> MAPPER = user -> UserResponse.builder()
      .userName(user.getName())
      .documentNumber(user.getDocumentNumber());

}

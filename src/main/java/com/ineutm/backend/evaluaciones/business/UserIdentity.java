package com.ineutm.backend.evaluaciones.business;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/** <b>Class</b>: File ApplicationUser <br/>
 * <b>Copyright</b>: 2021 Pacifico Seguros - La Chakra <br/>
 * .
 *
 * @author 2021 Pacifico Seguros - La Chakra <br/>
 *         <u>Service Provider</u>: Inetum <br/>
 *         <u>Developed by</u>: Carlos Belloda <br/>
 *         <u>Changes:</u><br/>
 *         <ul>
 *         <li>February 5, 2021 Creación de Clase.</li>
 *         </ul>
 *
*/
@NotBlank(message = "user-identity" + ":" + "El campo no puede ser vacío")
@Pattern(regexp = "^((ce-\\w{9})|(dni-\\d{8}))$", message = "user-identity:Formato inválido '${validatedValue}'" )
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface UserIdentity {
  /**
   * This method return Message.
   *
   * @return Message.
   */
  String message() default "user-identity";

  /**
   * This method return Message.
   *
   * @return Array.
   */
  Class<?>[] groups() default {};

  /**
   * This method return Message.
   *
   * @return Payload.
   */
  Class<? extends Payload>[] payload() default {};
}


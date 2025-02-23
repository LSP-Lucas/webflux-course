package br.com.curse.webflux.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy = {TrimStringValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface TrimString {

    String message() default "field cannot have blank spaces at the beginning or at end";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

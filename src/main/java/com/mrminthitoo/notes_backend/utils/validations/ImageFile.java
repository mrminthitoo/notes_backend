package com.mrminthitoo.notes_backend.utils.validations;

import com.mrminthitoo.notes_backend.utils.validations.implememtations.ImageFileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ImageFileValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageFile {
    String message() default "image must be jpg or png.";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}

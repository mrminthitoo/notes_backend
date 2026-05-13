package com.mrminthitoo.notes_backend.utils.validations;

import com.mrminthitoo.notes_backend.utils.validations.implememtations.TagListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TagListValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TagList {

    String message() default "{type.post.tags}";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

}

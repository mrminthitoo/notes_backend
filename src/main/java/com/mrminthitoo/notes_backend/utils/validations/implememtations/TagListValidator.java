package com.mrminthitoo.notes_backend.utils.validations.implememtations;

import com.mrminthitoo.notes_backend.utils.validations.TagList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class TagListValidator implements ConstraintValidator<TagList, Set<Long>> {
    @Override
    public boolean isValid(Set<Long> ids, ConstraintValidatorContext constraintValidatorContext) {

        boolean isValid = true;

        if (ids.isEmpty()){
            return true;
        }

        for (Object id : ids){
            if (!(id instanceof Long)) {
                isValid = false;
                break;
            }
        }

        return isValid;

    }
}

package io.github.delano_almeida_filho.social_media.infra.exceptions;

import org.springframework.validation.FieldError;

public record BeanValidationFieldCustomized(String field, String message) {
    public BeanValidationFieldCustomized(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}

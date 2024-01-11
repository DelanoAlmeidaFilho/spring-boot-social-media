package io.github.delano_almeida_filho.social_media.infra.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

public record BeanValidationException(int status, List<BeanValidationFieldCustomized> message, String code) {
    public BeanValidationException(List<BeanValidationFieldCustomized> message) {
        this(HttpStatus.BAD_REQUEST.value(), message, "badrequest.error");
    }
}

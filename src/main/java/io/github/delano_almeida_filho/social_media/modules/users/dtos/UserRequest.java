package io.github.delano_almeida_filho.social_media.modules.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
                @NotBlank String name,
                @Email String email,
                String description,
                @NotBlank String password) {
}

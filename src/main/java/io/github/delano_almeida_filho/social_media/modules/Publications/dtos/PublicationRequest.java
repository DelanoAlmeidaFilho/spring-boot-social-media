package io.github.delano_almeida_filho.social_media.modules.Publications.dtos;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PublicationRequest(
                @NotNull MultipartFile image,
                @NotBlank String description) {

}

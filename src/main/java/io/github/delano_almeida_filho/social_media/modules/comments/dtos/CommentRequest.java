package io.github.delano_almeida_filho.social_media.modules.comments.dtos;

import jakarta.validation.constraints.NotBlank;

public record CommentRequest(
                @NotBlank String description,
                @NotBlank String publication_id) {

}

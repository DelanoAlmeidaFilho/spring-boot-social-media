package io.github.delano_almeida_filho.social_media.modules.comments.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateCommentRequest(
        @NotBlank String comment_id,
        @NotBlank String description) {

}

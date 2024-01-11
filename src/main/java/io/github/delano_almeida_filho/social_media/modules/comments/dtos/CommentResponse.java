package io.github.delano_almeida_filho.social_media.modules.comments.dtos;

import java.util.Date;

import io.github.delano_almeida_filho.social_media.modules.comments.models.Comment;

public record CommentResponse(
                String id,
                String description,
                Date created_at,
                Date updated_at,
                String user_name,
                String user_avatar) {

        public CommentResponse(Comment data) {
                this(
                                data.getId(),
                                data.getDescription(),
                                data.getCreated_at(),
                                data.getUpdated_at(),
                                data.getUser().getName(),
                                data.getUser().getAvatar_link());
        }

}

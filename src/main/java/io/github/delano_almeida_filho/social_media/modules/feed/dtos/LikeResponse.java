package io.github.delano_almeida_filho.social_media.modules.feed.dtos;

import io.github.delano_almeida_filho.social_media.modules.likes.models.Like;

public record LikeResponse(String id, String user_name,
        String user_avatar) {
    public LikeResponse(Like data) {
        this(
                data.getUser().getId(),
                data.getUser().getName(),
                data.getUser().getAvatar_link());
    }
}

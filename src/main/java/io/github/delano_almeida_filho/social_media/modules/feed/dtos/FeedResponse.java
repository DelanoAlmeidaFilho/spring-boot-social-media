package io.github.delano_almeida_filho.social_media.modules.feed.dtos;

import java.util.List;

import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;

public record FeedResponse(String id, String image_url, String description, String user_name,
        String user_avatar, List<LikeResponse> likes) {
    public FeedResponse(Publication data) {

        this(
                data.getId(),
                data.getImage_url(),
                data.getDescription(),
                data.getUser().getName(),
                data.getUser().getAvatar_link(),
                data.getLikes().stream().map(LikeResponse::new).toList());
    }

}
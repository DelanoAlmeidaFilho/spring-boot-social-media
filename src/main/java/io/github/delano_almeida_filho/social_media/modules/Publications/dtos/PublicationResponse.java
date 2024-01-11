package io.github.delano_almeida_filho.social_media.modules.Publications.dtos;

import java.util.Date;

import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;

public record PublicationResponse(String id, Date created_at, String image_url, String description, String user_name,
        String user_avatar) {
    public PublicationResponse(Publication data) {
        this(
                data.getId(),
                data.getCreated_at(),
                data.getImage_url(),
                data.getDescription(),
                data.getUser().getName(),
                data.getUser().getAvatar_link());
    }

}

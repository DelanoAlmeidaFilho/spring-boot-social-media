package io.github.delano_almeida_filho.social_media.modules.users.dtos;

import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public record UserResponse(String id, String name, String description, String email, String avatar_link, String role) {
    public UserResponse(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getDescription(),
                user.getEmail(),
                user.getAvatar_link(),
                user.getRole().name());
    }
}

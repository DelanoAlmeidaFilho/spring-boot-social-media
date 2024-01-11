package io.github.delano_almeida_filho.social_media.modules.users.dtos;

import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public record AuthenticationUserResponse(String token, String id, String name, String description, String email,
        String avatar_link,
        String role) {
    public AuthenticationUserResponse(String token, User user) {
        this(
                token,
                user.getId(),
                user.getName(),
                user.getDescription(),
                user.getEmail(),
                user.getAvatar_link(),
                user.getRole().name());
    }
}

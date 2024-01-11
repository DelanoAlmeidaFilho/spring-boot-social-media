package io.github.delano_almeida_filho.social_media.providers;

import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public interface TokenService {
    public String generateToken(User user);

    public String validateToken(String token);
}

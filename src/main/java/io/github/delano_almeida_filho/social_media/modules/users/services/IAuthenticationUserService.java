package io.github.delano_almeida_filho.social_media.modules.users.services;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserResponse;

public interface IAuthenticationUserService {
    public AuthenticationUserResponse execute(AuthenticationUserRequest dto);
}

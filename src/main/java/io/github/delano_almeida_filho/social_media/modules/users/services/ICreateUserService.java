package io.github.delano_almeida_filho.social_media.modules.users.services;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;

public interface ICreateUserService {
    public UserResponse execute(UserRequest dto);
}

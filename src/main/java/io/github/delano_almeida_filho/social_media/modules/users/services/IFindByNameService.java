package io.github.delano_almeida_filho.social_media.modules.users.services;

import java.util.List;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;

public interface IFindByNameService {
    public List<UserResponse> execute(String name);
}

package io.github.delano_almeida_filho.social_media.modules.users.services;

import org.springframework.web.multipart.MultipartFile;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;

public interface IUpdateAvatarService {
    public UserResponse execute(MultipartFile avatar);
}

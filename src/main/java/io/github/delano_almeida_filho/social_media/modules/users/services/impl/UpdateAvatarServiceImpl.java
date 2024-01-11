package io.github.delano_almeida_filho.social_media.modules.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.modules.users.repositories.UserRepository;
import io.github.delano_almeida_filho.social_media.modules.users.services.IUpdateAvatarService;
import io.github.delano_almeida_filho.social_media.providers.UploadService;

@Service
public class UpdateAvatarServiceImpl implements IUpdateAvatarService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UploadService uploadService;

    @Override
    @Transactional
    public UserResponse execute(MultipartFile avatar) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user.getAvatar_link() != null) {
            this.uploadService.delete(user.getAvatar_link());
        }

        var avatar_link = this.uploadService.upload(avatar);

        user.setAvatar_link(avatar_link);

        return new UserResponse(this.userRepository.save(user));
    }

}

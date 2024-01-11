package io.github.delano_almeida_filho.social_media.modules.users.services.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.modules.users.services.IgetLoggedInUserService;

@Service
public class getLoggedInUserServiceImpl implements IgetLoggedInUserService {

    @Override
    public UserResponse execute() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new UserResponse(user);
    }

}

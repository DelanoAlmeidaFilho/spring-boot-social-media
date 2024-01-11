package io.github.delano_almeida_filho.social_media.modules.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.BadRequestException;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.modules.users.repositories.UserRepository;
import io.github.delano_almeida_filho.social_media.modules.users.services.ICreateUserService;

@Service
public class CreateUserServiceImpl implements ICreateUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse execute(UserRequest dto) {
        var user_exists = this.userRepository.findByEmail(dto.email());

        if (user_exists != null) {
            throw new BadRequestException("user already exists.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());

        User user = new User(dto.name(), dto.email(), encryptedPassword, dto.description());

        return new UserResponse(userRepository.save(user));
    }

}

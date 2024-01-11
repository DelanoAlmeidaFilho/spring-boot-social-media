package io.github.delano_almeida_filho.social_media.modules.users.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.repositories.UserRepository;
import io.github.delano_almeida_filho.social_media.modules.users.services.IFindByNameService;

@Service
public class FindByNameServiceImpl implements IFindByNameService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponse> execute(String name) {
        var users = this.userRepository.findUsersByNameContaining(name);

        return users.stream().map(UserResponse::new).toList();
    }

}

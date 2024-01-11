package io.github.delano_almeida_filho.social_media.modules.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.modules.users.services.IAuthenticationUserService;
import io.github.delano_almeida_filho.social_media.providers.TokenService;

@Service
public class AuthenticationUserServiceImpl implements IAuthenticationUserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public AuthenticationUserResponse execute(AuthenticationUserRequest dto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

        var authentication = this.authenticationManager.authenticate(usernamePassword);

        var user = (User) authentication.getPrincipal();

        var token = tokenService.generateToken(user);

        return new AuthenticationUserResponse(token, user);

    }

}

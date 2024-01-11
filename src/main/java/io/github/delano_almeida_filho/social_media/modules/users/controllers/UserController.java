package io.github.delano_almeida_filho.social_media.modules.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.AuthenticationUserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserRequest;
import io.github.delano_almeida_filho.social_media.modules.users.dtos.UserResponse;
import io.github.delano_almeida_filho.social_media.modules.users.services.IAuthenticationUserService;
import io.github.delano_almeida_filho.social_media.modules.users.services.ICreateUserService;
import io.github.delano_almeida_filho.social_media.modules.users.services.IFindByNameService;
import io.github.delano_almeida_filho.social_media.modules.users.services.IUpdateAvatarService;
import io.github.delano_almeida_filho.social_media.modules.users.services.IgetLoggedInUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController()
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private ICreateUserService createUserService;

    @Autowired
    private IAuthenticationUserService authenticationUserService;

    @Autowired
    private IUpdateAvatarService updateAvatarService;

    @Autowired
    private IFindByNameService findByNameService;

    @Autowired
    private IgetLoggedInUserService loggedInUserService;

    @PostMapping("/session")
    public ResponseEntity<AuthenticationUserResponse> login(@RequestBody @Valid AuthenticationUserRequest dto) {

        return ResponseEntity.ok(this.authenticationUserService.execute(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest dto) {

        return ResponseEntity.ok(this.createUserService.execute(dto));
    }

    @PatchMapping(path = "/avatar", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<UserResponse> updateAvatar(@ModelAttribute MultipartFile avatar) {

        return ResponseEntity.ok(this.updateAvatarService.execute(avatar));
    }

    @GetMapping("/search")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<UserResponse>> findByName(@RequestParam("name") String name) {

        return ResponseEntity.ok(this.findByNameService.execute(name));
    }

    @GetMapping("/me")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<UserResponse> me() {
        return ResponseEntity.ok(this.loggedInUserService.execute());
    }
}

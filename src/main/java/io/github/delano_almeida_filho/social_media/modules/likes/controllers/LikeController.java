package io.github.delano_almeida_filho.social_media.modules.likes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.delano_almeida_filho.social_media.modules.likes.services.ILikeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/like")
@SecurityRequirement(name = "bearer-key")
public class LikeController {
    @Autowired
    private ILikeService likeService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> toggle(@PathVariable String id) {
        this.likeService.execute(id);

        return ResponseEntity.noContent().build();
    }

}

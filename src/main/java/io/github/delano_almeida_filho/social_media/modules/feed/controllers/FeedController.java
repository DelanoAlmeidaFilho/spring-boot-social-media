package io.github.delano_almeida_filho.social_media.modules.feed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.delano_almeida_filho.social_media.modules.feed.dtos.FeedResponse;
import io.github.delano_almeida_filho.social_media.modules.feed.services.IFeedService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    private IFeedService feedService;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<FeedResponse>> listAll() {
        return ResponseEntity.ok(this.feedService.execute());
    }
}

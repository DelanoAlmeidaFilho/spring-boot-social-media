package io.github.delano_almeida_filho.social_media.modules.comments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentRequest;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.UpdateCommentRequest;
import io.github.delano_almeida_filho.social_media.modules.comments.services.ICreateCommentService;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IDeleteCommentService;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IListAllCommentsByPublicationService;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IUpdateCommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comments")
@SecurityRequirement(name = "bearer-key")
public class CommentController {
    @Autowired
    private ICreateCommentService createCommentService;

    @Autowired
    private IListAllCommentsByPublicationService listAllCommentsByPublicationService;

    @Autowired
    private IDeleteCommentService deleteCommentService;

    @Autowired
    private IUpdateCommentService updateCommentService;

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody @Valid CommentRequest dto) {
        return ResponseEntity.ok(createCommentService.execute(dto));
    }

    @GetMapping("/{publication_id}")
    public ResponseEntity<List<CommentResponse>> findAllbyPublication(@PathVariable String publication_id) {
        var comments = this.listAllCommentsByPublicationService.execute(publication_id);

        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.deleteCommentService.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping()
    public ResponseEntity<CommentResponse> update(@RequestBody @Valid UpdateCommentRequest dto) {

        return ResponseEntity.ok(this.updateCommentService.execute(dto));
    }

}

package io.github.delano_almeida_filho.social_media.modules.comments.services;

import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentRequest;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;

public interface ICreateCommentService {
    public CommentResponse execute(CommentRequest dto);
}

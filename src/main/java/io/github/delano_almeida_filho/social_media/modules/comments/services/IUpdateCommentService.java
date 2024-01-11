package io.github.delano_almeida_filho.social_media.modules.comments.services;

import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.UpdateCommentRequest;

public interface IUpdateCommentService {
    public CommentResponse execute(UpdateCommentRequest dto);
}

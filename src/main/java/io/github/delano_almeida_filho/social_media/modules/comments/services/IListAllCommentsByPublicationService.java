package io.github.delano_almeida_filho.social_media.modules.comments.services;

import java.util.List;

import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;

public interface IListAllCommentsByPublicationService {
    public List<CommentResponse> execute(String publication_id);
}

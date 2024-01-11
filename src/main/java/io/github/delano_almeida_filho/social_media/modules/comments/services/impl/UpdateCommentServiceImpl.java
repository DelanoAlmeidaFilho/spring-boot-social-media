package io.github.delano_almeida_filho.social_media.modules.comments.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.UpdateCommentRequest;
import io.github.delano_almeida_filho.social_media.modules.comments.repositories.CommentRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IUpdateCommentService;

@Service
public class UpdateCommentServiceImpl implements IUpdateCommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentResponse execute(UpdateCommentRequest dto) {
        var comment_exists = this.commentRepository.findById(dto.comment_id());

        if (comment_exists.isEmpty()) {
            throw new NotFoundException("comment not found.");
        }

        var comment = comment_exists.get();

        comment.update(dto);

        return new CommentResponse(this.commentRepository.save(comment));

    }
}

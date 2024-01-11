package io.github.delano_almeida_filho.social_media.modules.comments.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.comments.repositories.CommentRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IDeleteCommentService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

@Service
public class DeleteCommentServiceImpl implements IDeleteCommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void execute(String comment_id) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var comment = this.commentRepository.findByIdAndUser_Id(comment_id, user.getId());

        if (comment.isEmpty()) {
            throw new NotFoundException("comment not found.");
        }

        this.commentRepository.delete(comment.get());
    }

}

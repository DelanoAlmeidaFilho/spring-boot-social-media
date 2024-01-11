package io.github.delano_almeida_filho.social_media.modules.comments.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentRequest;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;
import io.github.delano_almeida_filho.social_media.modules.comments.models.Comment;
import io.github.delano_almeida_filho.social_media.modules.comments.repositories.CommentRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.services.ICreateCommentService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

@Service
public class CreateCommentServiceImpl implements ICreateCommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    @Transactional
    public CommentResponse execute(CommentRequest dto) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var publication = this.publicationRepository.findById(dto.publication_id());

        if (publication.isEmpty()) {
            throw new NotFoundException("publication not found.");
        }

        var comment = new Comment(dto.description(), user, publication.get());

        return new CommentResponse(this.commentRepository.save(comment));
    }

}

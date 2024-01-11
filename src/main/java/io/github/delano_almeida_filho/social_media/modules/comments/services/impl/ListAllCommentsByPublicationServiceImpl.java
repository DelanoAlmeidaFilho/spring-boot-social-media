package io.github.delano_almeida_filho.social_media.modules.comments.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.dtos.CommentResponse;
import io.github.delano_almeida_filho.social_media.modules.comments.repositories.CommentRepository;
import io.github.delano_almeida_filho.social_media.modules.comments.services.IListAllCommentsByPublicationService;

@Service
public class ListAllCommentsByPublicationServiceImpl implements IListAllCommentsByPublicationService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<CommentResponse> execute(String publication_id) {
        var publication = this.publicationRepository.findById(publication_id);

        if (publication.isEmpty()) {
            throw new NotFoundException("publication not found.");
        }

        var comments = this.commentRepository.findAllByPublication(publication.get());

        return comments.stream().map(CommentResponse::new).toList();
    }

}

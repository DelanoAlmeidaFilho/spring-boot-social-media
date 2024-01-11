package io.github.delano_almeida_filho.social_media.modules.likes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.likes.models.Like;
import io.github.delano_almeida_filho.social_media.modules.likes.repositories.LikeRepository;
import io.github.delano_almeida_filho.social_media.modules.likes.services.ILikeService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    @Transactional
    public void execute(String publication_id) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var publication = this.publicationRepository.findById(publication_id);

        if (publication.isEmpty()) {
            throw new NotFoundException("publication not found.");
        }

        var liked = this.likeRepository.findByUserAndPublication(user, publication.get());

        if (liked != null) {
            this.likeRepository.delete(liked);
        } else {
            var new_like = new Like(user, publication.get());

            this.likeRepository.save(new_like);
        }
    }

}

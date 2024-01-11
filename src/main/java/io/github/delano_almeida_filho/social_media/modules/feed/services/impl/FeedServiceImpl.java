package io.github.delano_almeida_filho.social_media.modules.feed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.feed.dtos.FeedResponse;
import io.github.delano_almeida_filho.social_media.modules.feed.services.IFeedService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

@Service
public class FeedServiceImpl implements IFeedService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<FeedResponse> execute() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var publications = this.publicationRepository.findPublicationsByFollowedUsers(user);

        return publications.stream().map(FeedResponse::new).toList();
    }

}

package io.github.delano_almeida_filho.social_media.modules.feed.services;

import java.util.List;

import io.github.delano_almeida_filho.social_media.modules.feed.dtos.FeedResponse;

public interface IFeedService {
    public List<FeedResponse> execute();
}

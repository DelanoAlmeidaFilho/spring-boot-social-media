package io.github.delano_almeida_filho.social_media.modules.Publications.services;

import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationResponse;

public interface IFindPublicationService {
    public PublicationResponse execute(String id);
}

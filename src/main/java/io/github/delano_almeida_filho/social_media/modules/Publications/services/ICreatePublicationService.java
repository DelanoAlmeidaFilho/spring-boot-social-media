package io.github.delano_almeida_filho.social_media.modules.Publications.services;

import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationRequest;
import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationResponse;

public interface ICreatePublicationService {
    public PublicationResponse execute(PublicationRequest dto);
}

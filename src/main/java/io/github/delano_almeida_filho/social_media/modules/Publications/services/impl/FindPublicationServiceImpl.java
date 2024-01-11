package io.github.delano_almeida_filho.social_media.modules.Publications.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationResponse;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.IFindPublicationService;

@Service
public class FindPublicationServiceImpl implements IFindPublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public PublicationResponse execute(String id) {
        var publication = this.publicationRepository.findById(id);

        if (publication.isEmpty()) {
            throw new NotFoundException("publication not found.");
        }

        return new PublicationResponse(publication.get());
    }

}

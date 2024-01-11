package io.github.delano_almeida_filho.social_media.modules.Publications.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationRequest;
import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationResponse;
import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.ICreatePublicationService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.providers.UploadService;

@Service
public class CreatePublicationServiceImpl implements ICreatePublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UploadService uploadService;

    @Override
    @Transactional
    public PublicationResponse execute(PublicationRequest dto) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var image_url = this.uploadService.upload(dto.image());

        var publication = new Publication(dto.description(), image_url, user);

        this.publicationRepository.save(publication);

        return new PublicationResponse(publication);
    }

}

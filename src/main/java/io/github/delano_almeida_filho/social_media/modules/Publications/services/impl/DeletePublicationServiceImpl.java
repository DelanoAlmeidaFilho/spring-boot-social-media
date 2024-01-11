package io.github.delano_almeida_filho.social_media.modules.Publications.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.Publications.repositories.PublicationRepository;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.IDeletePublicationService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.providers.UploadService;

@Service
public class DeletePublicationServiceImpl implements IDeletePublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UploadService uploadService;

    @Override
    @Transactional
    public void execute(String id) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var publication_exists = this.publicationRepository.findByIdAndUser_Id(id, user.getId());

        if (publication_exists.isEmpty()) {
            throw new NotFoundException("publication not found.");
        }

        var publication = publication_exists.get();

        this.uploadService.delete(publication.getImage_url());

        this.publicationRepository.delete(publication);
    }

}

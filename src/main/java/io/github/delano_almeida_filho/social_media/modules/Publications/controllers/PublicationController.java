package io.github.delano_almeida_filho.social_media.modules.Publications.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationRequest;
import io.github.delano_almeida_filho.social_media.modules.Publications.dtos.PublicationResponse;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.ICreatePublicationService;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.IDeletePublicationService;
import io.github.delano_almeida_filho.social_media.modules.Publications.services.IFindPublicationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/publication")
@SecurityRequirement(name = "bearer-key")
public class PublicationController {
    @Autowired
    private ICreatePublicationService createPublicationService;

    @Autowired
    private IDeletePublicationService deletePublicationService;

    @Autowired
    private IFindPublicationService findPublicationService;

    @PostMapping(path = "/", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<PublicationResponse> create(@ModelAttribute @Valid PublicationRequest dto) {

        return ResponseEntity.ok(this.createPublicationService.execute(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.deletePublicationService.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> findOne(@PathVariable String id) {
        return ResponseEntity.ok(this.findPublicationService.execute(id));
    }
}

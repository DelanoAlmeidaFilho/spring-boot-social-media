package io.github.delano_almeida_filho.social_media.modules.comments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.delano_almeida_filho.social_media.modules.comments.models.Comment;
import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, String> {
    Optional<Comment> findByIdAndUser_Id(String id, String userId);

    List<Comment> findAllByPublication(Publication publication);
}

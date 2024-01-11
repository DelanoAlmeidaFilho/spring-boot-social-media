package io.github.delano_almeida_filho.social_media.modules.likes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.delano_almeida_filho.social_media.modules.likes.models.Like;
import io.github.delano_almeida_filho.social_media.modules.likes.models.LikeId;
import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
    Like findByUserAndPublication(User user, Publication publication);

    List<Like> findAllByPublication(Publication publication);
}

package io.github.delano_almeida_filho.social_media.modules.followers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.delano_almeida_filho.social_media.modules.followers.models.Followers;
import io.github.delano_almeida_filho.social_media.modules.followers.models.FollowersId;
import java.util.List;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public interface FollowersRepository extends JpaRepository<Followers, FollowersId> {
    Followers findByFollowerAndFollowed(User follower, User followed);

    List<Followers> findAllByFollower(User follower);

    List<Followers> findByFollowed(User followed);
}

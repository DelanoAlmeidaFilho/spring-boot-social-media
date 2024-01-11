package io.github.delano_almeida_filho.social_media.modules.Publications.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public interface PublicationRepository extends JpaRepository<Publication, String> {
    Optional<Publication> findByIdAndUser_Id(String id, String userId);

    @Query("SELECT p FROM Publication p " +
            "JOIN FETCH p.user u " +
            "JOIN Followers f ON f.followed = u " +
            "LEFT JOIN FETCH p.likes " +
            "WHERE f.follower = :loggedInUser")
    List<Publication> findPublicationsByFollowedUsers(@Param("loggedInUser") User loggedInUser);
}

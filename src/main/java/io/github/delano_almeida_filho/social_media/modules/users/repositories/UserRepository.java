package io.github.delano_almeida_filho.social_media.modules.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByEmail(String email);

    UserDetails findByName(String name);

    List<User> findUsersByNameContaining(String name);
}

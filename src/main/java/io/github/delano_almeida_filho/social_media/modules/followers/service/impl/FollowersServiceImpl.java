package io.github.delano_almeida_filho.social_media.modules.followers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.delano_almeida_filho.social_media.infra.exceptions.NotFoundException;
import io.github.delano_almeida_filho.social_media.modules.followers.models.Followers;
import io.github.delano_almeida_filho.social_media.modules.followers.repositories.FollowersRepository;
import io.github.delano_almeida_filho.social_media.modules.followers.service.IFollowersService;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import io.github.delano_almeida_filho.social_media.modules.users.repositories.UserRepository;

@Service
public class FollowersServiceImpl implements IFollowersService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowersRepository followersRepository;

    @Override
    @Transactional
    public void execute(String followed_id) {
        var follower = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var followed = this.userRepository.findById(followed_id);

        if (followed.isEmpty()) {
            throw new NotFoundException("followed not found.");
        }

        var followers = this.followersRepository.findByFollowerAndFollowed(follower, followed.get());

        if (followers != null) {
            this.followersRepository.delete(followers);
        } else {
            var new_followers = new Followers(follower, followed.get());

            this.followersRepository.save(new_followers);
        }
    }

}

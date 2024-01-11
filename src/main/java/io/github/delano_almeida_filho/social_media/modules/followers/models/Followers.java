package io.github.delano_almeida_filho.social_media.modules.followers.models;

import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "followers")
@Entity
@IdClass(FollowersId.class)
public class Followers {
    @Id
    @ManyToOne
    @JoinColumn(name = "follower")
    private User follower;

    @Id
    @ManyToOne
    @JoinColumn(name = "followed")
    private User followed;

    public Followers() {
    }

    public Followers(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }

    // #region Getters and Setters

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    // #endregion
}

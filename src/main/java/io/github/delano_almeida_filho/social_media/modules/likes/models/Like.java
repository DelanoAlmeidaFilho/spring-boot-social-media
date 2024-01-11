package io.github.delano_almeida_filho.social_media.modules.likes.models;

import io.github.delano_almeida_filho.social_media.modules.Publications.models.Publication;
import io.github.delano_almeida_filho.social_media.modules.users.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "likes")
@Entity
@IdClass(LikeId.class)
public class Like {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    public Like() {
    }

    public Like(User user, Publication publication) {
        this.user = user;
        this.publication = publication;
    }

    // #region Getters and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    // #endregion
}

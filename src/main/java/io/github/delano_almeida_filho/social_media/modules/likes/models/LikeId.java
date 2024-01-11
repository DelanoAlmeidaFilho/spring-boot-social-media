package io.github.delano_almeida_filho.social_media.modules.likes.models;

import java.io.Serializable;
import java.util.Objects;

public class LikeId implements Serializable {

    private String user;
    private String publication;

    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(user, likeId.user) && Objects.equals(publication, likeId.publication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, publication);
    }
}

package io.github.delano_almeida_filho.social_media.modules.followers.models;

import java.io.Serializable;

public class FollowersId implements Serializable {
    private String follower;
    private String followed;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((follower == null) ? 0 : follower.hashCode());
        result = prime * result + ((followed == null) ? 0 : followed.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FollowersId other = (FollowersId) obj;
        if (follower == null) {
            if (other.follower != null)
                return false;
        } else if (!follower.equals(other.follower))
            return false;
        if (followed == null) {
            if (other.followed != null)
                return false;
        } else if (!followed.equals(other.followed))
            return false;
        return true;
    }
}

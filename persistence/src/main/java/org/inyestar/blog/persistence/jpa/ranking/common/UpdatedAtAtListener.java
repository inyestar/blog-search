package org.inyestar.blog.persistence.jpa.ranking.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UpdatedAtAtListener {
    @PreUpdate
    @PrePersist
    public void setUpdatedAt(DateMetadata entity) {
        entity.setUpdatedAt(LocalDateTime.now());
    }
}

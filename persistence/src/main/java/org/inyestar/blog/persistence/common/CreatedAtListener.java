package org.inyestar.blog.persistence.common;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.Objects;

public class CreatedAtListener {
    @PrePersist
    public void setCreatedAt(DateMetadata entity) {
        if (Objects.isNull(entity.getCreatedAt())) {
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
        }
    }
}

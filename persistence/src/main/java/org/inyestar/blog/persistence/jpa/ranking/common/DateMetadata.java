package org.inyestar.blog.persistence.jpa.ranking.common;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface DateMetadata extends Serializable {
    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}

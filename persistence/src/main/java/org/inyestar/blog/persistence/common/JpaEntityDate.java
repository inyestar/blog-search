package org.inyestar.blog.persistence.common;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface JpaEntityDate extends Serializable {
    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}

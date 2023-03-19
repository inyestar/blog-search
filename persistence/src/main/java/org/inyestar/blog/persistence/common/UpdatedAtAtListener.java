package org.inyestar.blog.persistence.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UpdatedAtAtListener {
    @PreUpdate
    @PrePersist
    public void setUpdatedAt() {
//        this.updatedAt = LocalDateTime.now();
    }
}

package org.inyestar.blog.persistence.common;

import javax.persistence.PrePersist;

public class CreatedAtListener {
    @PrePersist
    public void setCreatedAt() {
//        if () {
//            this.createdAt = LocalDateTime.now();
//            this.updatedAt = LocalDateTime.now();
//        }
    }
}

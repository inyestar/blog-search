package org.inyestar.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Blog {
    private String postTitle;
    private String postContents;
    private String postUrl;
    private String blogName;
    private String thumbnailUrl;
    private LocalDateTime postDate;
}

package org.inyestar.blog.api.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SearchBlogResponseDto {
    private String postTitle;
    private String postContents;
    private String postUrl;
    private String blogName;
    private String thumbnailUrl;
    private LocalDateTime postDate;
}

package org.inyestar.blog.api.dto;

import lombok.Getter;

@Getter
public class SearchBlogRequestDto {
    private String keyword;
    private String ordering;
    private Integer size;
    private Integer page;
}

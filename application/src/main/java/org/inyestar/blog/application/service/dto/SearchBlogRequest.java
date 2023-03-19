package org.inyestar.blog.application.service.dto;

import lombok.Getter;

@Getter
public class SearchBlogRequest {
    private String keyword;
    private String ordering;
    private Integer size;
    private Integer page;
}

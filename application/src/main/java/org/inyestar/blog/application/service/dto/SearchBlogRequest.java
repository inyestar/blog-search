package org.inyestar.blog.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlogRequest {
    private String keyword;
    private String ordering;
    private Integer size;
    private Integer page;
}

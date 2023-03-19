package org.inyestar.blog.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.constants.SortType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlogRequest {
    private String keyword;
    private SortType sortType;
    private Integer size;
    private Integer page;
}

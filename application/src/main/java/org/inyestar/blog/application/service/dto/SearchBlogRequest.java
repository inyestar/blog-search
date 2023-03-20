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
    private String sort;
    private Integer size;
    private Integer page;

    public static SearchBlogRequest sample() {
        return new SearchBlogRequest(
            "keyword",
            SortType.ACCURACY.name(),
            10,
            1
        );
    }
}

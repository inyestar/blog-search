package org.inyestar.blog.domain.port.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.constants.SortType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
    private String keyword;
    private SortType sortType;
    private Integer size;
    private Integer page;

    public static BlogRequest sample() {
        return new BlogRequest(
            "keyword",
            SortType.ACCURACY,
            10,
            1
        );
    }
}

package org.inyestar.blog.domain.constants;

import org.inyestar.blog.domain.exception.SearchBlogException;

import java.util.Arrays;

public enum SortType {
    ACCURACY,
    RECENCY,
    DATE
    ;

    public static SortType of(String requestedSort) {
        return Arrays.stream(values())
            .filter(sortType -> sortType.name().equals(requestedSort))
            .findFirst()
            .orElseThrow(new SearchBlogException("지원하지 않는 정렬 필드입니다."));
    }
}

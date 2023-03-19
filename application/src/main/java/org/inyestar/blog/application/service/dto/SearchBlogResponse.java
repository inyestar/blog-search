package org.inyestar.blog.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlogResponse {
    private String keyword;
    private String ordering;
    private Integer size;
    private Integer page;
    private Long totalCount;
    private List<Result> list;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private String postTitle;
        private String postContents;
        private String postUrl;
        private String blogName;
        private String thumbnailUrl;
    }
}

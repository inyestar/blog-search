package org.inyestar.blog.application.service.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchBlogResponse {
    private String keyword;
    private String ordering;
    private Integer size;
    private Integer page;
    private List<Result> list;

    public static class Result {
        private String postTitle;
        private String postContents;
        private String postUrl;
        private String blogName;
        private String thumbnailUrl;
    }
}

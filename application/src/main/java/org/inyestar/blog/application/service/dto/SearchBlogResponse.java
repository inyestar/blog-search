package org.inyestar.blog.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.constants.SortType;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlogResponse {
    private String keyword;
    private SortType sortType;
    private Integer size;
    private Integer page;
    private Long totalCount;
    private List<BlogInfo> list;

    public static SearchBlogResponse sample() {
        return new SearchBlogResponse(
            "검색어",
            SortType.RECENCY,
            10,
            1,
            11232L,
            Collections.singletonList(BlogInfo.sample())
        );
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BlogInfo {
        private String postTitle;
        private String postContents;
        private String postUrl;
        private String blogName;
        private String thumbnailUrl;

        public static BlogInfo sample() {
            return new BlogInfo(
                "포스트 입니다",
                "내용입니다",
                "https://post.com",
                "꿈을 꾸는 사람",
                "https://thumbnail.jpeg"
            );
        }
    }
}

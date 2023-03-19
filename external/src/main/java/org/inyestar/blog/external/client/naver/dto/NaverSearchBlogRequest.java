package org.inyestar.blog.external.client.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NaverSearchBlogRequest {
    private String query;
    private Integer start;
    private Integer display;
    private String sort;

    public static NaverSearchBlogRequest sample() {
        return new NaverSearchBlogRequest(
            "%EB%A6%AC%EB%B7%B0",
            1,
            10,
            "sim"
            );
    }
}

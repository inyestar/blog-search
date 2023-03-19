package org.inyestar.blog.external.client.kakao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoSearchBlogRequest {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;

    public static KakaoSearchBlogRequest sample() {
        return new KakaoSearchBlogRequest(
            "https://brunch.co.kr/@tourism 집짓기",
            "accuracy",
            1,
            10
        );
    }
}

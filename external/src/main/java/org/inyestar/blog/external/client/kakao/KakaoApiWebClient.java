package org.inyestar.blog.external.client.kakao;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.external.client.dto.KakaoSearchBlogRequest;
import org.inyestar.blog.external.client.dto.KakaoSearchBlogResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KakaoApiWebClient {
    private final WebClient kakaoWebClient;

    public KakaoSearchBlogResponse searchBlog(KakaoSearchBlogRequest request) {
        return kakaoWebClient.get()
            .uri(uriBuilder -> uriBuilder.path("/search/blog")
                .queryParam("query", request.getQuery())
                .queryParamIfPresent("sort", Optional.ofNullable(request.getSort()))
                .queryParamIfPresent("page", Optional.ofNullable(request.getPage()))
                .queryParamIfPresent("size", Optional.ofNullable(request.getSize()))
                .build())
            .retrieve()
            .bodyToMono(KakaoSearchBlogResponse.class)
            .block();
    }
}

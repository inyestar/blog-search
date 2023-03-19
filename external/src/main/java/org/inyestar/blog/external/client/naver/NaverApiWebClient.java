package org.inyestar.blog.external.client.naver;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogRequest;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NaverApiWebClient {
    private final WebClient naverWebClient;

    public NaverSearchBlogResponse searchBlog(NaverSearchBlogRequest request) {
        return naverWebClient.get()
            .uri(uriBuilder -> uriBuilder.path("/v1/search/blog.json")
                .queryParam("query", request.getQuery())
                .queryParamIfPresent("display", Optional.ofNullable(request.getDisplay()))
                .queryParamIfPresent("start", Optional.ofNullable(request.getStart()))
                .queryParamIfPresent("sort", Optional.ofNullable(request.getSort()))
                .build())
            .retrieve()
            .bodyToMono(NaverSearchBlogResponse.class)
            .block();
    }
}

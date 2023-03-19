package org.inyestar.blog.external.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${auth.rest-api.kakao.key")
    private String kakaoRestApiKey;
    @Value("${auth.rest-api.naver.client-id")
    private String naverClientId;
    @Value("${auth.rest-api.naver.client-secret")
    private String naverClientSecret;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
            .baseUrl("https://dapi.kakao.com/v2")
            .defaultHeader(HttpHeaders.AUTHORIZATION, kakaoRestApiKey)
            .build();
    }

    @Bean
    public WebClient naverWebClient() {
        return WebClient.builder()
            .baseUrl("https://openapi.naver.com/v1")
            .defaultHeader("X-Naver-Client-Id", naverClientId)
            .defaultHeader("X-Naver-Client-Secret", naverClientSecret)
            .build();
    }
}

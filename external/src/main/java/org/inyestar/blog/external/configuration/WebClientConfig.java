package org.inyestar.blog.external.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@PropertySource("classpath:/external.properties")
@Configuration
public class WebClientConfig {
    @Value("${auth.rest-api.kakao.host}")
    private String kakaoHost;
    @Value("${auth.rest-api.kakao.key}")
    private String kakaoRestApiKey;
    @Value("${auth.rest-api.naver.host}")
    private String naverHost;
    @Value("${auth.rest-api.naver.client-id}")
    private String naverClientId;
    @Value("${auth.rest-api.naver.client-secret}")
    private String naverClientSecret;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
            .baseUrl(kakaoHost)
            .defaultHeader(HttpHeaders.AUTHORIZATION, kakaoRestApiKey)
            .build();
    }

    @Bean
    public WebClient naverWebClient() {
        return WebClient.builder()
            .baseUrl(naverHost)
            .defaultHeader("X-Naver-Client-Id", naverClientId)
            .defaultHeader("X-Naver-Client-Secret", naverClientSecret)
            .build();
    }
}

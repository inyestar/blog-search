package org.inyestar.blog.external.client.kakao;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.client.KakaoApiClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class KakaoApiWebClient implements KakaoApiClient {
    private final WebClient kakaoWebClient;
}

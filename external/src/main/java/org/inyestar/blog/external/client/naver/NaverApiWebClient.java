package org.inyestar.blog.external.client.naver;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.client.NaverApiClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class NaverApiWebClient implements NaverApiClient {
    private final WebClient naverWebClient;
}

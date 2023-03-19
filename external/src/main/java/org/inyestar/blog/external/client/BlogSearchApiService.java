package org.inyestar.blog.external.client;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.client.BlogSearchApiClient;
import org.inyestar.blog.application.service.dto.SearchBlogRequest;
import org.inyestar.blog.application.service.dto.SearchBlogResponse;
import org.inyestar.blog.external.client.kakao.KakaoApiWebClient;
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogRequest;
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogResponse;
import org.inyestar.blog.external.client.naver.NaverApiWebClient;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogRequest;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogSearchApiService implements BlogSearchApiClient {
    private final KakaoApiWebClient kakaoApiWebClient;
    private final NaverApiWebClient naverApiWebClient;

    @Override
    public SearchBlogResponse searchBlog(SearchBlogRequest request) {
        try {
            KakaoSearchBlogResponse response = kakaoApiWebClient.searchBlog(new KakaoSearchBlogRequest(
                request.getKeyword(),
                request.getOrdering(),
                request.getPage(),
                request.getSize()
            ));
            return new SearchBlogResponse(
                request.getKeyword(),
                request.getOrdering(),
                request.getSize(),
                request.getPage(),
                response.getMeta().getTotalCount(),
                response.getDocuments()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toList())
            );
        } catch (RuntimeException e) {
            NaverSearchBlogResponse response = naverApiWebClient.searchBlog(new NaverSearchBlogRequest(
                request.getKeyword(),
                request.getPage(),
                request.getSize(),
                request.getOrdering()
            ));
            return new SearchBlogResponse(
                request.getKeyword(),
                request.getOrdering(),
                request.getSize(),
                request.getPage(),
                response.getTotal(),
                response.getItems()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toList())
            );
        }
    }

    private SearchBlogResponse.Result convert(KakaoSearchBlogResponse.Document document) {
        return new SearchBlogResponse.Result(
            document.getTitle(),
            document.getContents(),
            document.getUrl(),
            document.getBlogname(),
            document.getThumbnail()
        );
    }

    private SearchBlogResponse.Result convert(NaverSearchBlogResponse.Item item) {
        return new SearchBlogResponse.Result(
            item.getTitle(),
            item.getDescription(),
            item.getBloggerlink(),
            item.getBloggername(),
            null
        );
    }
}

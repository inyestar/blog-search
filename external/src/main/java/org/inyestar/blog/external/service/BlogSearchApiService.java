package org.inyestar.blog.external.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.inyestar.blog.domain.entity.Blog;
import org.inyestar.blog.domain.port.client.BlogSearchApiClient;
import org.inyestar.blog.domain.port.dto.BlogRequest;
import org.inyestar.blog.domain.port.dto.BlogResponse;
import org.inyestar.blog.external.client.kakao.KakaoApiWebClient;
import org.inyestar.blog.external.client.kakao.contants.KakaoSortType;
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogRequest;
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogResponse;
import org.inyestar.blog.external.client.naver.NaverApiWebClient;
import org.inyestar.blog.external.client.naver.contants.NaverSortType;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogRequest;
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogResponse;
import org.inyestar.blog.external.utils.DateConvertUtil;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogSearchApiService implements BlogSearchApiClient {
    private final KakaoApiWebClient kakaoApiWebClient;
    private final NaverApiWebClient naverApiWebClient;

    @Override
    public BlogResponse searchBlog(BlogRequest request) {
        try {
            KakaoSearchBlogResponse response = kakaoApiWebClient.searchBlog(new KakaoSearchBlogRequest(
                request.getKeyword(),
                KakaoSortType.getType(request.getSortType()),
                request.getPage(),
                request.getSize()
            ));
            return new BlogResponse(
                response.getMeta().getTotalCount(),
                response.getDocuments()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toList())
            );
        } catch (RuntimeException e) {
            log.error("failed to get result from kakao api - {}", e.getMessage(), e);
            NaverSearchBlogResponse response = naverApiWebClient.searchBlog(new NaverSearchBlogRequest(
                request.getKeyword(),
                request.getPage(),
                request.getSize(),
                NaverSortType.getType(request.getSortType())
            ));
            return new BlogResponse(
                response.getTotal(),
                response.getItems()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toList())
            );
        }
    }

    private Blog convert(KakaoSearchBlogResponse.Document document) {
        return new Blog(
            document.getTitle(),
            document.getContents(),
            document.getUrl(),
            document.getBlogname(),
            document.getThumbnail(),
            DateConvertUtil.convertKakaoDate(document.getDatetime())
        );
    }

    private Blog convert(NaverSearchBlogResponse.Item item) {
        return new Blog(
            item.getTitle(),
            item.getDescription(),
            item.getBloggerlink(),
            item.getBloggername(),
            null,
            DateConvertUtil.convertNaverDate(item.getPostdate())
        );
    }
}

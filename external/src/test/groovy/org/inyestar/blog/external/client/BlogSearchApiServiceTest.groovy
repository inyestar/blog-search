package org.inyestar.blog.external.client

import org.inyestar.blog.domain.port.dto.BlogRequest
import org.inyestar.blog.external.client.kakao.KakaoApiWebClient
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogRequest
import org.inyestar.blog.external.client.kakao.dto.KakaoSearchBlogResponse
import org.inyestar.blog.external.client.naver.NaverApiWebClient
import org.inyestar.blog.external.client.naver.dto.NaverSearchBlogResponse
import org.inyestar.blog.external.service.BlogSearchApiService
import spock.lang.Specification

class BlogSearchApiServiceTest extends Specification {
    KakaoApiWebClient kakaoApiWebClient = Mock()
    NaverApiWebClient naverApiWebClient = Mock()
    def service = new BlogSearchApiService(
            kakaoApiWebClient,
            naverApiWebClient
    )

    def "카카오 블로그 검색 시 장애 발생하면 네이버에서 검색"() {
        given:
        kakaoApiWebClient.searchBlog(_ as KakaoSearchBlogRequest) >> { throw new RuntimeException("hong hong") }

        when:
        service.searchBlog(BlogRequest.sample())

        then:
        1 * naverApiWebClient.searchBlog(_) >> NaverSearchBlogResponse.sample()
    }

    def "카카오 블로그 검색 시 검색"() {
        given:
        kakaoApiWebClient.searchBlog(_ as KakaoSearchBlogRequest) >> KakaoSearchBlogResponse.sample()

        when:
        service.searchBlog(BlogRequest.sample())

        then:
        0 * naverApiWebClient.searchBlog(_) >> NaverSearchBlogResponse.sample()
    }

}

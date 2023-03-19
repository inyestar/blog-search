package org.inyestar.blog.application.service

import org.inyestar.blog.application.port.client.BlogSearchApiClient
import org.inyestar.blog.application.service.dto.SearchBlogRequest
import org.inyestar.blog.application.service.dto.SearchBlogResponse
import spock.lang.Specification

class KeywordSearchCombineServiceTest extends Specification {
    KeywordRankingService keywordRankingService = Mock()
    BlogSearchApiClient blogSearchApiClient = Mock()
    def service = new KeywordSearchCombineService(
            keywordRankingService,
            blogSearchApiClient
    )

    def "블로그 검색"() {
        when:
        service.search(SearchBlogRequest.sample())

        then:
        1 * keywordRankingService.putKeywordRanking(_)
        1 * blogSearchApiClient.searchBlog(_) >> SearchBlogResponse.sample()
    }
}

package org.inyestar.blog.application.service;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.client.BlogSearchApiClient;
import org.inyestar.blog.application.service.dto.SearchBlogRequest;
import org.inyestar.blog.application.service.dto.SearchBlogResponse;
import org.inyestar.blog.domain.entity.Keyword;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordSearchCombineService {
    private final KeywordRankingService keywordRankingService;
    private final BlogSearchApiClient blogSearchApiClient;
    @Transactional
    public SearchBlogResponse search(SearchBlogRequest request) {
        keywordRankingService.putKeywordRanking(new Keyword(request.getKeyword()));
        return blogSearchApiClient.searchBlog(request);
    }
}

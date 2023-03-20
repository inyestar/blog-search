package org.inyestar.blog.application.service;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.service.dto.SearchBlogRequest;
import org.inyestar.blog.application.service.dto.SearchBlogResponse;
import org.inyestar.blog.domain.constants.SortType;
import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.port.client.BlogSearchApiClient;
import org.inyestar.blog.domain.port.dto.BlogRequest;
import org.inyestar.blog.domain.port.dto.BlogResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordSearchCombineService {
    private final KeywordRankingService keywordRankingService;
    private final BlogSearchApiClient blogSearchApiClient;
    @Transactional
    public SearchBlogResponse search(SearchBlogRequest request) {
        keywordRankingService.putKeywordRanking(new Keyword(request.getKeyword()));
        SortType sortType = SortType.of(request.getSort());
        BlogResponse response = blogSearchApiClient.searchBlog(new BlogRequest(
            request.getKeyword(),
            sortType,
            request.getSize(),
            request.getPage()
        ));
        return new SearchBlogResponse(
            request.getKeyword(),
            sortType,
            request.getSize(),
            request.getPage(),
            response.getTotalCount(),
            response.getList()
                .stream()
                .map(SearchBlogResponse.BlogInfo::new)
                .collect(Collectors.toList())
        );
    }
}

package org.inyestar.blog.application.service;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.service.dto.TopKeywordResponse;
import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;
import org.inyestar.blog.domain.port.jpa.KeywordRankingPersistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordRankingService {
    private final KeywordRankingPersistence persistence;

    @Transactional
    public void putKeywordRanking(Keyword keyword) {
        boolean exists = persistence.existsByKeyword(keyword);
        if (exists) {
            persistence.modifyKeywordRanking(keyword);
        } else {
            persistence.addKeywordRanking(keyword);
        }
    }

    public List<TopKeywordResponse> findTop10() {
        List<KeywordRanking> rankings = persistence.findTop10Keyword();
        return IntStream.range(0, rankings.size())
            .mapToObj(idx -> {
                KeywordRanking ranking = rankings.get(idx);
                return new TopKeywordResponse(
                    idx + 1,
                    ranking.getKeyword().getInput(),
                    ranking.getCount()
                );
            })
            .collect(Collectors.toList());
    }
}

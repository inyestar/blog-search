package org.inyestar.blog.application.service;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.jpa.KeywordRankingPersistence;
import org.inyestar.blog.domain.entity.Keyword;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

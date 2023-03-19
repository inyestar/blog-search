package org.inyestar.blog.persistence.jpa.ranking;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.jpa.KeywordRankingPersistence;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordRankingJpaPersistence implements KeywordRankingPersistence {
    private final KeywordRankingJpaRepository keywordRankingJpaRepository;
}

package org.inyestar.blog.persistence.ranking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordRankingJpaPersistence {
    private final KeywordRankingJpaRepository keywordRankingJpaRepository;
}

package org.inyestar.blog.persistence.jpa.ranking;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.jpa.KeywordRankingPersistence;
import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;
import org.inyestar.blog.domain.exception.SearchBlogException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeywordRankingJpaPersistence implements KeywordRankingPersistence {
    private final KeywordRankingJpaRepository keywordRankingJpaRepository;

    @Override
    public boolean existsByKeyword(Keyword keyword) {
        return keywordRankingJpaRepository.existsByKeywordHash(keyword.getHash());
    }

    @Override
    public Optional<KeywordRanking> getKeywordRanking(Keyword keyword) {
        return keywordRankingJpaRepository.findByKeywordHash(keyword.getHash())
            .map(KeywordRankingJpaEntity::toDomain);
    }

    @Override
    public void addKeywordRanking(Keyword keyword) {
        KeywordRankingJpaEntity entity = keywordRankingJpaRepository.save(new KeywordRankingJpaEntity(keyword));
    }

    @Override
    public void modifyKeywordRanking(Keyword keyword) {
        KeywordRankingJpaEntity entity = keywordRankingJpaRepository.findByKeywordHash(keyword.getHash()).orElseThrow(new SearchBlogException("키워드 횟수 정보를 찾을 수 없습니다."));
        entity.count();
    }
}

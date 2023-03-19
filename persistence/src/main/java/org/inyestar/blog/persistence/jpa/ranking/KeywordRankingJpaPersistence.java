package org.inyestar.blog.persistence.jpa.ranking;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.port.jpa.KeywordRankingPersistence;
import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;
import org.inyestar.blog.domain.exception.SearchBlogException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        keywordRankingJpaRepository.save(new KeywordRankingJpaEntity(keyword));
    }

    @Override
    public void modifyKeywordRanking(Keyword keyword) {
        KeywordRankingJpaEntity entity = keywordRankingJpaRepository.findByKeywordHash(keyword.getHash()).orElseThrow(new SearchBlogException("키워드 횟수 정보를 찾을 수 없습니다."));
        entity.addCount();
    }

    @Override
    public List<KeywordRanking> findTop10Keyword() {
        return keywordRankingJpaRepository.findAll(PageRequest.of(0, 10, Sort.by("count").descending()))
            .stream()
            .map(KeywordRankingJpaEntity::toDomain)
            .collect(Collectors.toList());
    }
}

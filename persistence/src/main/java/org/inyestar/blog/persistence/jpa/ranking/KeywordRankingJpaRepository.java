package org.inyestar.blog.persistence.jpa.ranking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRankingJpaRepository extends JpaRepository<KeywordRankingJpaEntity, Long> {
    boolean existsByKeywordHash(String keywordHash);
    Optional<KeywordRankingJpaEntity> findByKeywordHash(String keywordHash);
}

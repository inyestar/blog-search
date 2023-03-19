package org.inyestar.blog.application.port.jpa;

import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;

import java.util.List;
import java.util.Optional;

public interface KeywordRankingPersistence {
    boolean existsByKeyword(Keyword keyword);
    Optional<KeywordRanking> getKeywordRanking(Keyword keyword);
    void addKeywordRanking(Keyword keyword);
    void modifyKeywordRanking(Keyword keyword);
    List<KeywordRanking> findTop10Keyword();
}

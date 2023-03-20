package org.inyestar.blog.domain.port.jpa;

import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;

import java.util.List;

public interface KeywordRankingPersistence {
    boolean existsByKeyword(Keyword keyword);
    void addKeywordRanking(Keyword keyword);
    void modifyKeywordRanking(Keyword keyword);
    List<KeywordRanking> findTop10Keyword();
}

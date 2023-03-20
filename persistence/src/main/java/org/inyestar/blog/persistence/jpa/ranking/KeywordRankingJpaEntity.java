package org.inyestar.blog.persistence.jpa.ranking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.inyestar.blog.domain.entity.Keyword;
import org.inyestar.blog.domain.entity.KeywordRanking;
import org.inyestar.blog.persistence.jpa.ranking.common.CreatedAtListener;
import org.inyestar.blog.persistence.jpa.ranking.common.DateMetadata;
import org.inyestar.blog.persistence.jpa.ranking.common.UpdatedAtAtListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "keyword_ranking",
    indexes = {
        @Index(name = "keyword_ranking_created_at_index", columnList = "created_at"),
        @Index(name = "keyword_ranking_updated_at_index", columnList = "updated_at"),
        @Index(name = "keyword_ranking_keyword_hash_index", columnList = "keyword_hash")
    })
@EntityListeners({
    CreatedAtListener.class,
    UpdatedAtAtListener.class
})
public class KeywordRankingJpaEntity implements DateMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "keyword_ranking_id_seq")
    @SequenceGenerator(name = "keyword_ranking_id_seq", sequenceName = "keyword_ranking_id_seq", allocationSize = 1)
    @Column(name = "keyword_ranking_id", nullable = false)
    @Comment("테이블 pk")
    private Long keywordRankingId;

    @Column(name ="keyword_hash", nullable = false)
    @Comment("검색어 해싱 값")
    private String keywordHash;

    @Column(name = "keyword", nullable = false)
    @Comment("사용자 입력 키워드")
    private String keyword;

    @Column(name = "count", nullable = false)
    @Comment("키워드 요청 횟수")
    private Long count;

    @Setter
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    @Comment("데이터 생성일")
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    @Comment("데이터 수정일")
    private LocalDateTime updatedAt;

    public KeywordRankingJpaEntity(Keyword keyword) {
        this.keywordHash = keyword.getHash();
        this.keyword = keyword.getInput();
        this.count = 1L;
    }

    public void addCount() {
        this.count++;
    }

    public KeywordRanking toDomain() {
        return new KeywordRanking(
            new Keyword(keyword, keywordHash),
            count,
            createdAt,
            updatedAt
        );
    }
}

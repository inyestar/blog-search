package org.inyestar.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class KeywordRanking {
    private Keyword keyword;
    private Long count;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package org.inyestar.blog.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TopKeywordResponse {
    private Integer no;
    private String keyword;
    private Long count;
}

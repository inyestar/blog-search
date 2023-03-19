package org.inyestar.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.utils.HashUtil;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Keyword {
    private String input;
    private String hash;

    public Keyword(String keyword) {
        this.input = keyword;
        this.hash = HashUtil.hash(keyword);
    }
}

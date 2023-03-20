package org.inyestar.blog.domain.port.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.entity.Blog;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {
    private Long totalCount;
    private List<Blog> list;

    public static BlogResponse sample() {
        return new BlogResponse(
            11232L,
            Collections.singletonList(Blog.sample())
        );
    }
}

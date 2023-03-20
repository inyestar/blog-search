package org.inyestar.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Blog {
    private String postTitle;
    private String postContents;
    private String postUrl;
    private String blogName;
    private String thumbnailUrl;
    private LocalDateTime postDate;

    public static Blog sample() {
        return new Blog(
            "포스트 입니다",
            "내용입니다",
            "https://post.com",
            "꿈을 꾸는 사람",
            "https://thumbnail.jpeg",
            LocalDateTime.now()
        );
    }
}

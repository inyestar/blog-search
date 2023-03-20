package org.inyestar.blog.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.inyestar.blog"})
public class SearchBlogApiApplication {
    public static void main(String [] args) {
        SpringApplication.run(SearchBlogApiApplication.class, args);
    }
}

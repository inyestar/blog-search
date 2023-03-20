package org.inyestar.blog.api.controller;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.service.KeywordSearchCombineService;
import org.inyestar.blog.application.service.dto.SearchBlogRequest;
import org.inyestar.blog.application.service.dto.SearchBlogResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class SearchBlogController {
    private final KeywordSearchCombineService keywordSearchCombineService;
    @GetMapping("/search/blog")
    public SearchBlogResponse searchBlog(
        @NotBlank(message = "검색어는 필수 값 입니다") @RequestParam String keyword,
        @Positive(message = "페이지 사이즈는 0보다 커야 합니다.") @RequestParam(required = false) Integer size,
        @Positive(message = "페이지 번호는 0보다 커야 합니다.") @RequestParam(required = false) Integer page,
        @RequestParam(required = false) String sort) {
        return keywordSearchCombineService.search(new SearchBlogRequest(
            keyword,
            sort,
            size,
            page
        ));
    }

}
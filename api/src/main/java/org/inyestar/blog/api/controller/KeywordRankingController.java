package org.inyestar.blog.api.controller;

import lombok.RequiredArgsConstructor;
import org.inyestar.blog.application.service.KeywordRankingService;
import org.inyestar.blog.application.service.dto.TopKeywordResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KeywordRankingController {
    private final KeywordRankingService keywordRankingService;

    @GetMapping("/keyword/top-10")
    public List<TopKeywordResponse> findTop10() {
        return keywordRankingService.findTop10();
    }
}
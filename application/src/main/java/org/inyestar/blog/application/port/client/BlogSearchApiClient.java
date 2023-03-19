package org.inyestar.blog.application.port.client;

import org.inyestar.blog.application.service.dto.SearchBlogRequest;
import org.inyestar.blog.application.service.dto.SearchBlogResponse;

public interface BlogSearchApiClient {
    SearchBlogResponse searchBlog(SearchBlogRequest request);
}

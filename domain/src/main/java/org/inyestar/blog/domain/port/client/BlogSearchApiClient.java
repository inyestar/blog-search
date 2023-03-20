package org.inyestar.blog.domain.port.client;

import org.inyestar.blog.domain.port.dto.BlogRequest;
import org.inyestar.blog.domain.port.dto.BlogResponse;

public interface BlogSearchApiClient {
    BlogResponse searchBlog(BlogRequest request);
}

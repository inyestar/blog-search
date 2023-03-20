package org.inyestar.blog.api.configuration;

import org.inyestar.blog.domain.exception.SearchBlogException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleInternalServerError(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(value = SearchBlogException.class)
    public final ResponseEntity<Object> handleBadRequest(SearchBlogException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // TODO: validation 에러 핸들링 -> 메시지 포멧 변경 필요
    // kakao 실패 시 naver 확인
    // kakao totalCount 안나오는 이슈 확인
}

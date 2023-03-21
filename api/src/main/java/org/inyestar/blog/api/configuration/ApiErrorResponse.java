package org.inyestar.blog.api.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private int code;
    private String status;
    private String message;
}

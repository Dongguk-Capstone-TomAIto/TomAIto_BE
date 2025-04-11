package com.example.TomAIto_BE.common.code;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorReasonDTO(
        HttpStatus httpStatus,
        String code,
        String message,
        boolean isSuccess
) {
}

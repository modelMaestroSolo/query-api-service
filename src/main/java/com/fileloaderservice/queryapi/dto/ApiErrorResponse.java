package com.fileloaderservice.queryapi.dto;

import java.time.LocalDateTime;

public record ApiErrorResponse(
        String error,
        String message,
        int status,
        String detail,
        LocalDateTime timestamp
) {
}

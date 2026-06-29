package com.fileloaderservice.queryapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CrdQueryRequest(
        @NotNull(message = "record_date_start is required")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("record_date_start")
        LocalDateTime recordDateStart,


        @NotNull(message = "record_date_end is required")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("record_date_end")
        LocalDateTime recordDateEnd,

        String msisdn,
        String imsi
) {
}

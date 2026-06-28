package com.fileloaderservice.queryapi.repository;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public interface CdrQueryRepository {
    List<CdrRecordResponse> findRecords(
            @NotNull(message = "record_date_start is required") LocalDateTime recordDateStart,
            @NotNull(message = "record_date_end is required") LocalDateTime recordDateEnd,
            String msisdn, String imsi);
}

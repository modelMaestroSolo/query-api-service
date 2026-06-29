package com.fileloaderservice.queryapi.repository;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository contract for executing CDR queries against the database.
 */
public interface CdrQueryRepository {

    /**
     * Retrieves CDR records within the given date range, optionally filtered by MSISDN and/or IMSI.
     *
     * @param recordDateStart start of the date range (inclusive)
     * @param recordDateEnd   end of the date range (inclusive)
     * @param msisdn          optional MSISDN filter; ignored if {@code null} or blank
     * @param imsi            optional IMSI filter; ignored if {@code null} or blank
     * @return list of matching records; empty list if none found
     */
    List<CdrRecordResponse> findRecords(
            @NotNull(message = "record_date_start is required") LocalDateTime recordDateStart,
            @NotNull(message = "record_date_end is required") LocalDateTime recordDateEnd,
            String msisdn, String imsi);
}

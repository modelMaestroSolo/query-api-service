package com.fileloaderservice.queryapi.service;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import com.fileloaderservice.queryapi.dto.CrdQueryRequest;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service contract for querying Call Detail Records (CDRs).
 */
public interface QueryService {

    /**
     * Executes a CDR query using the filters provided in the request.
     *
     * @param request validated request body containing a mandatory date range and optional filters
     * @return list of matching {@link CdrRecordResponse} records; empty list if none found
     * @throws IllegalArgumentException if {@code recordDateStart} is after {@code recordDateEnd}
     */
    List<CdrRecordResponse> query(@Valid CrdQueryRequest request);
}
